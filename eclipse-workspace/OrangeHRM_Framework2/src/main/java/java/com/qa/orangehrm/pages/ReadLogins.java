package com.qa.orangehrm.pages;
//import java.io.FileInputStream;
//import java.io.IOException;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadLogins{
	public static void main(String[] args) throws IOException 
	{
		//File file=new File(System.getProperty("user.dir") + "\\TestData\\" + "Regression_TestData" + ".xlsx");
		//FileInputStream inputstream=new FileInputStream(file);
		
		FileInputStream inputstream= new FileInputStream("C:\\Users\\Admin\\Desktop\\Capgemini\\Selenium\\splin\\Test.xlsx");
		 
		
		
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		XSSFRow row=sheet.getRow(2);
		XSSFCell cell=row.getCell(0); // Get 1st username 
		
		String username=cell.getStringCellValue();
		System.out.println("UserName is : " + username);
		
		cell=row.getCell(1);
		
		String password=cell.getStringCellValue();
		System.out.println("Password  is : " + password );
		
		// driver.findElemnt(by.xpath("ajsdkjas")).sendKeys(username));
		
		
	}

}