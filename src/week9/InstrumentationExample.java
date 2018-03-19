package week9;

public class InstrumentationExample {

	public static void foo() {
		Float yesterday = WellHouseInput.readNumber();
		float today = WellHouseInput.readNumber();
		if (yesterday > today) {
			System.out.println("something");
			// add instrument_1 here
		} 
		else {
			if (yesterday != today) {
				System.out.println("something");
				// add instrument_2 here
			} 
			else {
				System.out.println("something");
			}
		}
	}
	
	static class WellHouseInput {
		static Float readNumber() {
			return null;
		}
	}

}