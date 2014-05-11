package edu.univdhaka.iit.echo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

	private static final String DATABASE_NAME = "ECHO";
	private static final String DATABASE_USER_NAME = "root";
	private static final String DATABASE_PASSWORD = "";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

	public Connection getConnection() {
		Connection connect = null;
		try {
			Class.forName(DRIVER_NAME);
			connect = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connect;
	}

	public Connection openConnection() {
		return getConnection();
	}
	
	public void closeConnection(){
		try {
			getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}