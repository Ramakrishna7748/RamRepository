package com.qa.orangehrm.pages;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelLogin {

	private static XSSFSheet sheet;

	public static void main(String[] args) throws IOException {
		File file=new File(System.getProperty("user.dir")+"\\TestData\\"+"TestData"+".xlsx");
		FileInputStream inputStream=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		
		
//		XSSFRow row=sheet.getRow(2);
//		XSSFCell cell=row.getCell(0);
//		
//		String username=cell.getStringCellValue();
//		System.out.println("user Name is :  "+ username);
//		
//		cell=row.getCell(1);
//		String password=cell.getStringCellValue();
//		System.out.println("password is : "+ password);
		
//		WebDriverManager.chromedriver().setup();
      
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Capgemini\\Selenium\\SeleniumWebDriver1\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		
		XSSFRow row=null;
		XSSFCell cell=null;
		String username=null;
		String password=null;
	
		for(int i=1; i<=sheet.getLastRowNum();i++)
		{
				row=sheet.getRow(i);
				for(int j=0;j<row.getLastCellNum();j++)
				{
					cell=row.getCell(j);
					if(j==0)
					{
						username=cell.getStringCellValue();
					}
				
					if(j==1)
					{
						password=cell.getStringCellValue();
					}
				}
			System.out.println("User Name: "+username+"------> "+"Password : "+ password);
			
			driver.findElement(By.id("txtUsername")).sendKeys(username);
			driver.findElement(By.name("txtPassword")).sendKeys(password);
			driver.findElement(By.xpath("//input[@class='button']")).click();
		}
		
	}
}