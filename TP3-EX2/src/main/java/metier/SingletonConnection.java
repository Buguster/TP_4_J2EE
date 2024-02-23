package metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static String jdbc_url = "jdbc:mysql://localhost:3306/DB_MVC";
	private static String userName = "MVC_APP1";
	private static String mdp = "12345678";
	private static Connection connection = null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbc_url, userName, mdp);
			if (connection != null) {
				System.out.println("------------------------------");
				System.out.println("Bien Connecté");
				System.out.println("------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}
}