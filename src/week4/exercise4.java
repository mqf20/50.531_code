package week4;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
 * - Use forwarding -- we take advantage of the compareTo() method provided by GregorianCalendar to 
 * 	implement the after() logic in CalendarSubclass.
 * - The limitation is that our approach would not work if the calendars compared to are not Gregorian.
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
        
        System.out.println(cal2.after(cal1));  // true
        System.out.println(cal2.after(cal2));  // true
        System.out.println(cal1.after(cal2));  // *false*

	}
}

class CalendarSubclass extends Calendar {
	@Override
	public boolean after(Object when) {

	    if (!(when instanceof Calendar)) {
	      throw new IllegalArgumentException();
	    }
		
        GregorianCalendar this_calendar = convertCalendarToGregorian(this);
        GregorianCalendar when_calendar = convertCalendarToGregorian((Calendar) when);
        
        int compareResult = this_calendar.compareTo(when_calendar);

		if (compareResult == 0) {
			//System.out.println("lala");
			return true;
		}
		return compareResult > 0;
	}
	
	/**
	 * Given a calendar, convert it to Gregorian by copying the timezone, year, month, ..., millisecond
	 * attributes.
	 */
	private GregorianCalendar convertCalendarToGregorian(Calendar anotherCalendar) {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTimeZone(anotherCalendar.getTimeZone());
		gregorianCalendar.set(GregorianCalendar.YEAR, anotherCalendar.get(Calendar.YEAR));
		gregorianCalendar.set(GregorianCalendar.MONTH, anotherCalendar.get(Calendar.MONTH));
		gregorianCalendar.set(GregorianCalendar.DAY_OF_MONTH, anotherCalendar.get(Calendar.DAY_OF_MONTH));
		gregorianCalendar.set(GregorianCalendar.HOUR, anotherCalendar.get(Calendar.HOUR));
		gregorianCalendar.set(GregorianCalendar.MINUTE, anotherCalendar.get(Calendar.MINUTE));
		gregorianCalendar.set(GregorianCalendar.SECOND, anotherCalendar.get(Calendar.SECOND));
		gregorianCalendar.set(GregorianCalendar.MILLISECOND, anotherCalendar.get(Calendar.MILLISECOND));
		return gregorianCalendar;
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