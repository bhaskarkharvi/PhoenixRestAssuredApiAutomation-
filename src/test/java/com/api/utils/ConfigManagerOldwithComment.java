package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ConfigManagerOldwithComment {
	
	private static Properties prop= new Properties();
	public static String path="properties/config.properties";
	
	public static String env;
	
	static {
		//File configFilepath= new File(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		 //Make it platform independent
		//File configFilepath= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"properties"+File.separator+"config.properties");
		 
		//avoid big path in file like below frominput stream
		 InputStream input= Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		//FileReader fileRead;
		// if(path==null) {
		//	 throw new RuntimeException("pathe not found "+path );
		 //}
		try {
			//fileRead = new FileReader(configFilepath);- Change to stream
			prop.load(input);
			//prop.input(input); --> load input stream
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
//WAP to read data from property file, path- /src/test/resources/proprties/config.properties
	public static String getProprty(String key) {
		
	
	//Properties prop= new Properties(); -->converted this into static variable
	
	//Now have to load config file to read property inside Config File
	//prop.load();//Parameter must be passed here--> File parameter to load
	//so file object is required, 
	
	//File configFilepath= new File(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
//	File configFilepath= new File(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
//----> moved to static block
	//to load properties,the data read from config is passed.
	//so have to create file reader as well
	// FileReader fileRead= new FileReader(configFilepath);//----> moved to static block
	 //once file is read then we have to load using prop.load
	// prop.load(fileRead);//----> moved to static block
	 //System.out.println(prop.getProperty("BASE_URI"));
	 return prop.getProperty(key);
	 
	}
	
}	
	
