package week4;

import java.util.Calendar;

/**
 * Submission by FOO, Ming Qing (1003260, mingqing_foo@mymail.sutd.edu.sg),
 * 
 * The problem with the non-compliant code is: 
 * - CalendarSubclass overrides after() so that after() returns true when two objects 
 *   represent the same date.
 * - However, after() depends on the compareTo() method, which has also been overridden in
 *   CalendarSubclass. This causes after() to return the wrong results.
 * 
 * The fix is to: 
 * - Implement CalendarSubclass's own comparison.
 */
public class exercise4 {
  
    /**
     * Unit test
     */
	public static void main (String[] args) {
	  
        CalendarSubclass cal1 = new CalendarSubclass();
        cal1.set(1999, 12, 31);
        System.out.printf("cal1 is %s-%s-%s\n", cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), 
            cal1.get(Calendar.DAY_OF_MONTH));

        CalendarSubclass cal2 = new CalendarSubclass();
        cal2.set(2018, 1, 12);
        System.out.printf("cal2 is %s-%s-%s\n", cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), 
            cal2.get(Calendar.DAY_OF_MONTH));
        
        System.out.println("\n>> start of tests...\n");
        
//        System.out.println(cal2.after(cal1));  // true
        System.out.println(cal2.after(cal2));  // true
//        System.out.println(cal1.after(cal2));  // prints *true* but should be *false*

	}
}

class CalendarSubclass extends Calendar {
	@Override
	public boolean after(Object when) {

	    if (!(when instanceof Calendar)) {
	      throw new IllegalArgumentException();
	    }

	    Calendar when_calendar = (Calendar) when;

        System.out.printf("this is %s-%s-%s\n", this.get(Calendar.YEAR), this.get(Calendar.MONTH), 
            this.get(Calendar.DAY_OF_MONTH));
	    
        System.out.printf("when_calendar is %s-%s-%s\n", when_calendar.get(Calendar.YEAR), 
            when_calendar.get(Calendar.MONTH), when_calendar.get(Calendar.DAY_OF_MONTH));
	    
	    if (this.get(Calendar.YEAR) > when_calendar.get(Calendar.YEAR)) {
	      return true;
	    }

	    if (this.get(Calendar.YEAR) < when_calendar.get(Calendar.YEAR)) {
	      return false;
	    }
	    
	    if (this.get(Calendar.MONTH) > when_calendar.get(Calendar.MONTH)) {
	      return true;
	    }

	    if (this.get(Calendar.MONTH) < when_calendar.get(Calendar.MONTH)) {
	      return false;
	    }

	    if (this.get(Calendar.DAY_OF_MONTH) > when_calendar.get(Calendar.DAY_OF_MONTH)) {
	      return true;
	    }

	    if (this.get(Calendar.DAY_OF_MONTH) < when_calendar.get(Calendar.DAY_OF_MONTH)) {
	      return false;
	    }

	    if (this.get(Calendar.HOUR) > when_calendar.get(Calendar.HOUR)) {
	      return true;
	    }

	    if (this.get(Calendar.HOUR) < when_calendar.get(Calendar.HOUR)) {
	      return false;
	    }

	    if (this.get(Calendar.MINUTE) > when_calendar.get(Calendar.MINUTE)) {
	      return true;
	    }

	    if (this.get(Calendar.MINUTE) < when_calendar.get(Calendar.MINUTE)) {
	      return false;
	    }

	    if (this.get(Calendar.SECOND) > when_calendar.get(Calendar.SECOND)) {
	      return true;
	    }

	    if (this.get(Calendar.SECOND) < when_calendar.get(Calendar.SECOND)) {
	      return false;
	    }

	    if (this.get(Calendar.MILLISECOND) > when_calendar.get(Calendar.MILLISECOND)) {
	      return true;
	    }

	    if (this.get(Calendar.MILLISECOND) < when_calendar.get(Calendar.MILLISECOND)) {
	      return false;
	    }
	    

        System.out.println(">> super.compareTo() is " +super.compareTo((Calendar) when));
        System.out.println(">> super.equals() is " + super.equals((Calendar) when));
        System.out.println(">> super.before() is " + super.before(when));
        System.out.println(">> super.after() is " + super.after(when));
        
		if (super.compareTo(when_calendar) == 0) {
			//System.out.println("lala");
			return true;
		}
		return super.after(when);
	}

	@Override
	public int compareTo(Calendar anotherCalendar) {
		return compareDays(this.getFirstDayOfWeek(), anotherCalendar.getFirstDayOfWeek());
	}

	private int compareDays(int currentFirstDayOfWeek, int anotherFirstDayOfWeek) {
		return (currentFirstDayOfWeek > anotherFirstDayOfWeek) ? 1
				: (currentFirstDayOfWeek == anotherFirstDayOfWeek) ? 0 : -1;
	}
	

	// Implementation of other Calendar abstract methods skipped

	@Override
	public void add(int field, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void computeFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void computeTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getGreatestMinimum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeastMaximum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaximum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinimum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void roll(int field, boolean up) {
		// TODO Auto-generated method stub
		
	}
}