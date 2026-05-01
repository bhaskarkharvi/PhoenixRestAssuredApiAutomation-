package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.api.request.model.loginUserDetails;

public class ExcelReaderUtil {
	
private ExcelReaderUtil() {}
	public static Iterator<loginUserDetails> loadExcelData(String string, String string2, Class<loginUserDetails> clazz) {
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("testData/PhoenixTestData.xlsx");
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet mySheet = myWorkBook.getSheet("LoginTestData");
		XSSFRow myRow;
		XSSFCell myCell;
		// Read the excel file -->Store in ArrayList<loginUserDetails>
		// Need to know indexesfor username and password in our sheet

		XSSFRow rowHeader = mySheet.getRow(0);
		int userNameIndex = -1;// Assume its not there ,so -1
		int passwordIndex = -1;// Assume its not there ,so -1

		for (Cell cell : rowHeader) {
			if (cell.getStringCellValue().trim().equalsIgnoreCase("password")) {
				passwordIndex = cell.getColumnIndex();
			}
			if (cell.getStringCellValue().trim().equalsIgnoreCase("username")) {
				userNameIndex = cell.getColumnIndex();
			}//System.out.println(userNameIndex + passwordIndex);
		}
		System.out.println(userNameIndex + passwordIndex);
		
		int lastRowIndex = mySheet.getLastRowNum();
		XSSFRow rowData;
		loginUserDetails userCredential;
		List<loginUserDetails> userList= new ArrayList<loginUserDetails>();
		for (int rowIndex = 1; rowIndex <= lastRowIndex; rowIndex++) {
			rowData = mySheet.getRow(rowIndex);
			userCredential = new loginUserDetails(rowData.getCell(userNameIndex).toString(),
					rowData.getCell(passwordIndex).toString());
			userList.add(userCredential);
		}
		return userList.iterator();
	}
}
