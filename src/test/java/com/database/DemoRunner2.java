package com.database;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.stream.events.EndDocument;

public class DemoRunner2 {

	public static void main(String[] args) throws SQLException {
		
		long startTime=System.currentTimeMillis();
		for(int i=0;i<1000;i++) {
			
			  DatabaseManagerOLD.createConnection(); DatabaseManagerOLD.createConnection();
			  DatabaseManagerOLD.createConnection(); DatabaseManagerOLD.createConnection();
			 // multiple connection creates multiple memory allocation which is time consuming
		// SO in DBManager class Singleton pattern has to be created by declaring conn as static class variable
	}
		
		long endTime=System.currentTimeMillis();
		
		System.out.println("Duration = "+ (endTime-startTime)+" ms");
	}

}
