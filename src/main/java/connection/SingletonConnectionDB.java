package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnectionDB {
	private static String stringConnection = "jdbc:mysql://localhost/tsspersonalfinance";
	private static String username = "root";
	private static String password = "102057";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		conectar();
	}
	
	private SingletonConnectionDB() {
		throw new IllegalStateException("Utility class");
	}

	private static void conectar() {
		try {
			
			if(connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(stringConnection, username, password);
				connection.setAutoCommit(false);
			}				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
