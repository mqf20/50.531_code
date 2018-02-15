package week4;

public class CompliantLCK6 implements Runnable {
	private static volatile int counter;
	private static final int numberOfThreads = 10000;
	private static final Object lock = new Object ();

	public void run() {
		synchronized (lock) {
			counter++;			
		}
	}
	
	public static void main (String[] args) throws Exception {
		Thread[] tester = new Thread[numberOfThreads];
		
		for (int i = 0; i < numberOfThreads; i++) {
			tester[i] = new Thread(new CompliantLCK6());
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
