package fr.eni.ecole.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {
	private static String URL;
	
	private static String USER;
	
	private static String PASSWORD;
	
	private static String DRIVERDB;
	
	static {
		URL = Settings.getProperty("url");
		USER = Settings.getProperty("user");
		PASSWORD = Settings.getProperty("password");
		DRIVERDB = Settings.getProperty("driverdb");
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVERDB);
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
