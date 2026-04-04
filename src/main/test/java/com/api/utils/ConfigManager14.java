package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ConfigManager14 {
	
	private static Properties prop= new Properties();
	public static String path="properties/config.properties";
	private ConfigManager14() {
		//Private constructor to prevent creating object of this class
	}
	
	public static String env;
	
	static {
		env= System.getProperty("env","qa");
		  //env= System.getProperty("env" , "qa");//default set to qa even if no env mentioned in run command mvn test
		 env= env.toLowerCase().trim();// if " qa " - trims extra space.
		  switch(env){
		  case "dev" -> path="properties/config.dev.properties";
		  case "qa"-> path="properties/config.qa.properties";
		  case "uat"->path="properties/config.uat.properties";
		  default->   path="properties/config.qa.properties"; 
		  }
		System.out.println("Environment used = " +env);
		
		  
		InputStream input= Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		
		try {
			prop.load(input);
			} catch (IOException e) {
			
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
	
