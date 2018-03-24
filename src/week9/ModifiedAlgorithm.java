package week9;

import java.util.Random;

public class ModifiedAlgorithm {

    /* Guided algorithm parameters */
    private static final char[] PREFIX = "http://".toCharArray();
    private static final int MAX_DIVIDERS = 5;  // at most 5 dividers or "."

    /* GA parameters */
    private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    /* Public methods */

    // Evolve a population to generate strings that match the format "http://*.*.*.*.*.*"
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.size(), false);

        // Keep our best individual
        if (elitism) {
            newPopulation.saveIndividual(0, pop.getFittest());
        }

        // Crossover population
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        // Loop over the population size and create new individuals with
        // crossover
        for (int i = elitismOffset; i < pop.size(); i++) {
            Individual indiv1 = tournamentSelection(pop);
            Individual indiv2 = tournamentSelection(pop);
            Individual newIndiv = crossover(indiv1, indiv2);
            newPopulation.saveIndividual(i, newIndiv);
        }

        // Mutate population
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    // Crossover individuals and match the format "http://*.*.*.*.*.*"
    private static Individual crossover(Individual indiv1, Individual indiv2) {
        Individual newSol = new Individual();
        // prefix is constant
        for (int i = 0; i < PREFIX.length; i++) {
            newSol.setGene(i, PREFIX[i]);
        }
        // Crossover at least once
        for (int i = PREFIX.length; i < indiv1.size(); i++) {
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, indiv1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        while (!isEligible(newSol)) {
            for (int i = PREFIX.length; i < indiv1.size(); i++) {
                if (Math.random() <= uniformRate) {
                    newSol.setGene(i, indiv1.getGene(i));
                } else {
                    newSol.setGene(i, indiv2.getGene(i));
                }
            }
        }
        return newSol;
    }

    // Mutate an individual (modified)
    private static void mutate(Individual indiv) {
        for (int i = PREFIX.length; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                Random r = new Random();
                char c = (char) (r.nextInt(95) + 32);
                indiv.setGene(i, c);
            }
        }
        while (!isEligible(indiv)) {
            // mutate genes after prefix
            for (int i = PREFIX.length; i < indiv.size(); i++) {
                if (Math.random() <= mutationRate) {
                    Random r = new Random();
                    char c = (char) (r.nextInt(95) + 32);
                    indiv.setGene(i, c);
                }
            }
        }
    }
    
    // Select individuals for crossover
    private static Individual tournamentSelection(Population pop) {
        // Create a tournament population
        Population tournament = new Population(tournamentSize, false);
        // For each place in the tournament get a random individual
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.saveIndividual(i, pop.getIndividual(randomId));
        }
        // Get the fittest
        Individual fittest = tournament.getFittest();
        return fittest;
    }
    
    // Check if a string matches the format of "*.*.*.*.*.*" (we have ignored the prefix)
    private static boolean isEligible(Individual indiv) {
        int dividerCount = 0;
        int lastDividerIndex = 0;
        for (int i = PREFIX.length; i < indiv.size(); i++) {
            if (indiv.getGene(i) == '.') {
                dividerCount++;
                lastDividerIndex = i;
            }
        }
        if (dividerCount > MAX_DIVIDERS) {
            return false;
        }
        // no dots allowed before last divider
        if (dividerCount > 1) {
            for (int i = 0; i < lastDividerIndex; i++) {
                if (indiv.getGene(i) == ' ') {
                    return false;
                }
            }
        }
        boolean terminated = false;
        for (int i = lastDividerIndex; i < indiv.size(); i++) {  
            // must include lastDividerIndex (in case there are no dividers)
            if (indiv.getGene(i) == ' ') {
                if (!terminated) {
                    terminated = true;
                }
            } else if (terminated) {  // already terminated; should have no more non-whitespace characters
                return false;
            }
        }
        return true;  // all tests passed
    }

}