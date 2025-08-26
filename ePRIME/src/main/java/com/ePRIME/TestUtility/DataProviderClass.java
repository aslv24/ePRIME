package com.ePRIME.TestUtility;

import org.testng.annotations.DataProvider;

import com.ePRIME.Reader.PropertyReader;

public class DataProviderClass {

	
	@DataProvider(name="qaData")
	public String[][] getData()
	{
		ExcelUtility excel=new ExcelUtility(PropertyReader.getProperty("excelPath"), PropertyReader.getProperty("excelSheetName"));
		
		int rowCount = excel.getRowCount();
		
		int cellCount = excel.getCellCount();
		
		return excel.getValues(rowCount, cellCount);
	}
}
