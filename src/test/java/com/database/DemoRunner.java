package com.database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoRunner {

	public static void main(String[] args) throws SQLException {
		DatabaseManager.createConnection();
		DatabaseManager.createConnection();
		DatabaseManager.createConnection();
		DatabaseManager.createConnection();// multiple connection creates multiple memory allocation which is time consuming
		// SO in DBManager class Singleton pattern has to be created by declaring conn as static class variable
	}

}
