package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Users {
	public static void main (String[] args) {
		CachedServices factorizer = new CachedServices ();
		Thread tr1 = new Thread (new MyRunnable(factorizer));
		Thread tr2 = new Thread (new MyRunnable(factorizer));
		tr1.start();
		tr2.start();
		
		try {
			tr1.join();
			tr2.join();
		}
		catch (Exception e) {
			
		}
	}
}

class MyRunnable implements Runnable {
	private CachedServices factorizer;
	
	public MyRunnable (CachedServices factorizer) {
		this.factorizer = factorizer; 
	}
	
	public void run () {
		factorizer.service("some query");
	}
}

public class CachedServices {
	private String lastQuery;
	private List<Object> lastResults;
	private long hits;
	private long cacheHits;
	
	public synchronized long getHits () {
		return hits;
	}
	
	public synchronized double getCacheHitRatio () {
		return (double) cacheHits/ (double) hits;
	}
	
	public synchronized List<Object> service (String input) {
		List<Object> results = null;
		++hits;
		
		if (input.equals(lastQuery)) {
			++cacheHits;
			results = new ArrayList<Object>(lastResults);
		}
		
		if (results == null) {
			results = backendService(input);
			lastQuery = input;
			lastResults = results;
		}
		
		return results;
	}
	
	public List<Object> backendService(String query) {	
		List<Object> results = new ArrayList<Object>();
		//conduct some length service to provide the results.
		return results;
	}
}