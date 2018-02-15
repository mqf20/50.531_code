package week4;


import java.util.concurrent.atomic.AtomicInteger;

public class CompliantVNA03 {
	private final AtomicInteger lower = new AtomicInteger(0);
	private final AtomicInteger upper = new AtomicInteger(0);
	//invariant: lower <= upper
	
	public synchronized void setLower(int i) {
		if (i > upper.get()) {
			throw new IllegalArgumentException ("Can't set lower to " + i + " > upper");
		}
		
		lower.set(i);
	}
	
	public synchronized void setUpper(int i) {
		if (i < lower.get()) {
			throw new IllegalArgumentException ("Can't set upper to " + i + " < lower");
		}
		
		upper.set(i);
	}
	
	public boolean isInRange(int i) {
		return (i >= lower.get()) && i <= upper.get();
	}
	
	public boolean isValid() {
		return lower.get() <= upper.get();
	}
}
