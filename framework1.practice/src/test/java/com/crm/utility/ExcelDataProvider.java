package com.crm.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		File src = new File("./TestData/TestData.xlsx");
		
		try {
		
		FileInputStream fis = new FileInputStream (src);
		
		wb = new XSSFWorkbook(fis);
		}catch(Exception e) {
			System.out.println("unable to read the file" +e.getMessage());
		}
	}

	public String getStringData(int sheetIndex, int row,int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName, int row,int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}


	public String getNumericData(String sheetname, int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
}
}