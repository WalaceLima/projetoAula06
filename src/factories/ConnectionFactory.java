package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String DATABASE = "jdbc:mysql://localhost:3306/projetoAula06?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "coti";

	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
	}
}
