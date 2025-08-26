package com.ePRIME.TestUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	File file;
	FileInputStream inputStream;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	DataFormatter format;
	int i,j;
	String[][] array;
	
	public ExcelUtility(String excelPath, String sheetName) {
		try {
		file=new File(excelPath);
		inputStream=new FileInputStream(file);
		workbook=new XSSFWorkbook(inputStream);
		sheet=workbook.getSheet(sheetName);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public int getRowCount()
	{
		DriverUtility.maximize();
		return sheet.getLastRowNum()+1;
		
	}
	
	public int getCellCount()
	{
		return sheet.getRow(0).getLastCellNum();
	}
	
	public String getValue(int rowNum,int cellNum)
	{
		row=sheet.getRow(rowNum);
		cell=row.getCell(cellNum);  
		format=new DataFormatter();
		return format.formatCellValue(cell);		
	}
	
	public String[][] getValues(int rowCount,int cellCount)
	{
		array=new String[rowCount][cellCount];
		for(i=0; i<rowCount;i++)
		{
			for(j=0; j<cellCount;j++)
			{
				row=sheet.getRow(i);
				cell=row.getCell(j);
				format=new DataFormatter();
				array[i][j]=format.formatCellValue(cell);
			}
		}
		return array;
	}
}
