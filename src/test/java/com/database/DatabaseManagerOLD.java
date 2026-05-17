package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.api.utils.ConfigManager;
import com.api.utils.ConfigManager14;

public class DatabaseManagerOLD {
	
	private static String DB_URL=ConfigManager14.getProprty("DB_URL");
	private static String DB_USER_NAME=ConfigManager14.getProprty("DB_USER_NAME");
	private static String DB_PASSWORD=ConfigManager14.getProprty("DB_PASSWORD");
	
private volatile static Connection conn;//Informs all threads that conn  has value already in thread
	
	private DatabaseManagerOLD() {
		// Not allowing to create object , and static method class hence ---> Singleton class
	}
	public static void createConnection() throws SQLException
	{
		synchronized(DatabaseManagerOLD.class) {
		
				if(conn== null) {//ONLY & Only for the first the connection request.
			
					conn = DriverManager.getConnection(DB_URL, DB_USER_NAME,DB_PASSWORD);
			}
	}
		System.out.println(conn);
	}
}
