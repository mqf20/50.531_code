package week4;

import java.util.Calendar;

public class exercise4 {
	public static void main (String[] args) {
		CalendarSubclass cal1 = new CalendarSubclass();
		System.out.println(cal1);
		CalendarSubclass cal2 = new CalendarSubclass();
		System.out.println(cal2.after(cal1));
		System.out.println(cal2.after(cal2));
		System.out.println(cal1.after(cal2));
	}
}

class CalendarSubclass extends Calendar {
	@Override
	public boolean after(Object when) {
		// correctly calls Calendar.compareTo()
		if (when instanceof Calendar && compareTo((Calendar) when) == 0) {
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