package week5;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Vector;


public class FirstExample {
	public static Object getLast(Vector list) {
		synchronized (list) {
	       int lastIndex = list.size()-1;
	       return list.get(lastIndex);
		}
	}

	public static void deleteLast(Vector list) {
		synchronized (list) {
	      int lastIndex = list.size()-1;
	      list.remove(lastIndex);
		}
	}	
	
	public static boolean contains(Vector list, Object obj) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(obj)) {
				return true;
			}
		}

		return false;
	}
	
	class HiddenIterator {
		private final Set<Integer> set = new HashSet<Integer>();
		
		public synchronized void add(Integer i) { set.add(i); }
		
		public synchronized void remove (Integer i) { set.remove(i); }
		
		public void addTenThings() {
			Random r = new Random();
			for (int i = 0; i < 10; i++) {
				add(r.nextInt());
			}
			System.out.println ("DEBUG: added ten elements to " + set);
		}
		
	}
}
