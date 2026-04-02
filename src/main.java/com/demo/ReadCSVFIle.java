package com.demo;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSVFIle {

	public static void main(String[] args) throws IOException, CsvException {
		
		/*
		 * File csvFile= new
		 * File("D:\\RestAssured 2026 -Jatin Sharma\\PhoenixRestAssuredAPIAutomation\\src\\main.java\\ReadCSVFIle.java"
		 * );
		 * 
		 * FileReader fr= new FileReader(csvFile); 
		 */
		 
		InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream("testData//loginCreds.csv");
		 
		InputStreamReader isr= new InputStreamReader(is);
		CSVReader csvReader= new CSVReader(isr);
		List<String[]> loginCredList= csvReader.readAll();
		
		for(String[] loginDataArray:loginCredList) {
			//for(String loginCredData: loginDataArray) {
				System.out.println(loginDataArray[0]);
				System.out.println(loginDataArray[1]);
			//}
			
		}

	}

}
