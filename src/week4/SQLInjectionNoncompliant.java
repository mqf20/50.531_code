package week4;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjectionNoncompliant {
	String hashPassword(char[] password) {
		// create hash of password
		return null;
	}

	public void doPrivilegedAction(String username, char[] password) throws SQLException {
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

	private Connection getConnection() {
		// this method establishes a connection to a DBMS
		return null;
	}
}
