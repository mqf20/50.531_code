package week8;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BlackBoxTestExample {
	public static boolean isDateString (String input) {
		if (input.equals("I am the evil string which triggers the back door.")) {
			//do evil stuff.		
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		try {
			format.parse(input);
			return true;
		}
		catch (ParseException e) {
			return false;
		}

	}
}
