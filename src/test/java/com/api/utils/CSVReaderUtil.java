package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.dataproviders.api.bean.UserBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReaderUtil {
	
	private CSVReaderUtil() {
		//Private constructor - so no object should be created for this
		
	}
	
	public static <T> Iterator<T> loadCSV(String pathOfCSVfile, Class<T> bean) {
		
		InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOfCSVfile);
		 
		InputStreamReader isr= new InputStreamReader(is);
		CSVReader csvReader= new CSVReader(isr);

		CsvToBean<T> csvToBean= new CsvToBeanBuilder(csvReader)
				.withType(bean)
				.withIgnoreEmptyLine(true)
				.withIgnoreLeadingWhiteSpace(true)
		        .withThrowExceptions(true)  
				.build();
			List<T> list= csvToBean.parse();
			return list.iterator();
			//System.out.println(userList);
		}

}
