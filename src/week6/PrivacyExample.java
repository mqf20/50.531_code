package week6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class PrivacyExample {
	private final HashMap<String, String> accounts = new HashMap<String, String>(); //accounts is the secret 

	public void register(String username, String password) throws Exception {
		if (accounts.containsKey(username)) {
			throw new SecurityException("User name already exists");
		}

		accounts.put(username, password);
	}

	private String hashPassword(char[] password) {
		// create hash of password
		return null;
	}

	public void doPrivilegedAction(String username, char[] password) throws Exception {
		String pwd = hashPassword(password);
		// Ensure that the length of user name is legitimate
		if (username.length() > 8) {
			// Handle error
		}
		
		if (!accounts.containsKey(username)) {
			throw new SecurityException("User name incorrect");			
		}
		
		if (!accounts.get(username).equals(pwd)) {
			throw new SecurityException("password incorrect");			
		}		
	}
}
