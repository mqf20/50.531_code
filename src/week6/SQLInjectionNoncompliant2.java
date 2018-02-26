package week6;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjectionNoncompliant2 {
	static String hashPassword(char[] password) {
		// create hash of password
		return null;
	}

	public static void main (String[] args) throws Exception {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a name: ");
		String username = reader.next(); // Scans the next token of the input as an int.
		System.out.println("Enter a password: ");
		char[] password = reader.next().toCharArray();
		//once finished
		reader.close(); 
		doPrivilegedAction(username, password);
	}
	
	public static void doPrivilegedAction(String username, char[] password) throws SQLException {
		Connection connection = getConnection();
		if (connection == null) {
			// handle error
		}
		try {
			String pwd = hashPassword(password);
			String sqlString = "SELECT * FROM db_user WHERE username = '" + username + "' AND password = '" + pwd + "'";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			if (!rs.next()) {
				throw new SecurityException("User name or password incorrect");
			}
			// Authenticated; proceed
		} finally {
			try {
				connection.close();
			} catch (SQLException x) {
				// forward to handler
			}
		}
	}

	private static Connection getConnection() {
		// this method establishes a connection to a DBMS
		return null;
	}
}
