package week4;

public class NoncompliantLCK06 implements Runnable {
	private static volatile int counter;
	private static final int numberOfThreads = 10000;

	public synchronized void run() {
		counter++;
	}
	
	public static void main (String[] args) throws Exception {
		Thread[] tester = new Thread[numberOfThreads];
		
		for (int i = 0; i < numberOfThreads; i++) {
			tester[i] = new Thread(new NoncompliantLCK06());
		}
		
		for (int i = 0; i < numberOfThreads; i++) {
			tester[i].start();
		}

		for (int i = 0; i < numberOfThreads; i++) {
			tester[i].join();
		}
		
		System.out.println(counter);
	}
}
