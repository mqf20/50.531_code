package week9;

public class GeneticPalindrome {

	public static final int SIZE = 64; //

	/**
	 * Measure the fitness function of a palindromic string.
	 */
	public static int getFitness(Individual individual) {
		int fitness = 0;
		for (int i = 0; i < SIZE / 2; i++) {
			fitness -= Math.abs(individual.getGene(i) - individual.getGene(SIZE - i - 1));
		}
		return fitness;
	}

	/**
	 * Generate a palindromic string using the genetic algorithm.
	 */
	public static void main(String[] args) {

		// Create an initial population
		Population myPop = new Population(50, true);

		// Evolve our population until we reach an optimum solution
		int generationCount = 0;
		while (getFitness(myPop.getFittest()) < FitnessCalc.getMaxFitness()) {
			generationCount++;
			System.out.println("Generation: " + generationCount + " Fittest: " + getFitness(myPop.getFittest()));
			System.out.println("Current Fittest: " + myPop.getFittest());
			myPop = Algorithm.evolvePopulation(myPop);
		}
		System.out.println("\nSolution: " + myPop.getFittest());

	}

}