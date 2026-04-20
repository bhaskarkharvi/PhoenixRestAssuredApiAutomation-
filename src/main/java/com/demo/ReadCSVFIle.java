package com.demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSVFIle {

	public static void main(String[] args) throws IOException, CsvException {
		
		File csvFile= new File("D:\\RestAssured 2026 -Jatin Sharma\\PhoenixRestAssuredAPIAutomation\\src\\main.java\\ReadCSVFIle.java");
		
		FileReader fr= new FileReader(csvFile);
		CSVReader csvReader= new CSVReader(fr);
		List<String[]> loginCredList= csvReader.readAll();
		
		for(String[] loginDataArray:loginCredList) {
			for(String loginCredData: loginDataArray) {
				System.out.println(loginCredData);
			}
			
		}

	}

}
