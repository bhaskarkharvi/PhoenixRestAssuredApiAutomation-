package com.dataproviders;

import org.testng.annotations.DataProvider;

import com.api.utils.CSVReaderUtil;

public class DataProviderUtils {
	
	@DataProvider(name="LoginAPIDataProvider")
	public void loginAPIDataProvider() {
		CSVReaderUtil.loadCSV("testData/loginCreds.csv");
		

}
}
