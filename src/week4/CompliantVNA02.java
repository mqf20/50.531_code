package week4;


public class CompliantVNA02 implements Runnable {
	private boolean flag = true;

	public synchronized void toggle() { // Unsafe
		flag = !flag;
	}

	public boolean getFlag() { // Unsafe
		return flag;
	}
	
	public static void main (String[] args) throws Exception {
		CompliantVNA02 t = new CompliantVNA02();
		t.toggle();
		
		Thread[] threads = new Thread[10001];
		for (int i = 0; i < 10001; i++) {
			threads[i] = new Thread(t);
		}

		for (int i = 0; i < 10001; i++) {
			threads[i].start();;
		}
		
		System.out.println("finally flag is: " + t.getFlag());

	}

	@Override
	public void run() {
		toggle();
	}
	
}