package com.database;

import java.sql.Connection;
import java.sql.SQLException;

public class DemoRUnner_CheckingOfHikariDatabseManager {

	public static void main(String[] args) throws SQLException {
		
			Connection conn= DatabaseManager.getConnection();
			System.out.println("iiiiiiiiiiiiiiiiiiiii");
		System.out.println(conn);

	}

}
