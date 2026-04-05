package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.dataproviders.api.bean.UserPOJO;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReaderUtil {
	
	private CSVReaderUtil() {
		//Private constructor - so no object should be created for this
		
	}
	
	public static Iterator<UserPOJO> loadCSV(String pathOfCSVfile) {
		
		InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOfCSVfile);
		 
		InputStreamReader isr= new InputStreamReader(is);
		CSVReader csvReader= new CSVReader(isr);

		CsvToBean<UserPOJO> csvToBean= new CsvToBeanBuilder(csvReader)
				.withType(UserPOJO.class)
				.withIgnoreEmptyLine(true)
				.build();
			List<UserPOJO> userList= csvToBean.parse();
			return userList.iterator();
			//System.out.println(userList);
		}

}
