package com.qa.orangehrm.pages;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.qa.orangehrm.base.TestBase;

import dev.failsafe.internal.util.Assert;

//import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.pages.DataDriven;
import com.qa.orangehrm.pages.ExcelUtils;
import com.qa.orangehrm.pages.LogInPage1;
import com.qa.orangehrm.pages.ExcelsUtils_1;
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

public class LogInPage1  {
	

		private static XSSFSheet sheet;

		public static void main(String[] args) throws IOException {
			File file=new File(System.getProperty("user.dir")+"\\TestData\\"+"TestData"+".xlsx");
			FileInputStream inputStream=new FileInputStream(file);
			
			XSSFWorkbook wb=new XSSFWorkbook(inputStream);
			XSSFSheet sheet=wb.getSheet("LoginDetails");
			
			
//			XSSFRow row=sheet.getRow(2);
//			XSSFCell cell=row.getCell(0);
//			
//			String username=cell.getStringCellValue();
//			System.out.println("user Name is :  "+ username);
//			
//			cell=row.getCell(1);
//			String password=cell.getStringCellValue();
//			System.out.println("password is : "+ password);
			
//			WebDriverManager.chromedriver().setup();
	      
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
	
	
//	@FindBy(id="txtUsername")
//	WebElement username;
//	@FindBy(id="txtPassword")
//	WebElement password;
//	@FindBy(className="button")
//	WebElement loginbtn;
//	@FindBy(xpath="//*[@id=\"forgotPasswordLink\"]/a")
//	WebElement forgotpassword;
//	@FindBy(xpath="//*[@id=\"securityAuthentication_userName\"]")
//	WebElement forgotpassbox;
//	@FindBy(xpath="//*[@id=\"btnSearchValues\"]")
//	WebElement resetbtn;
//	@FindBy(xpath="//*[@id=\"btnCancel\"]")
//	WebElement cancelbtn;

	private WebDriver driver;
	private By userid = By.id("txtUsername");
	private By forgotPwdLink = By.xpath("//*[@id=\"forgotPasswordLink\"]/a");
	private By signInButton = By.id("btnLogin");
	private By password1 = By.id("txtPassword");
	@FindBy(id="txtUsername")
	WebElement username;
	@FindBy(id="txtPassword")
	WebElement password;
	@FindBy(className="button")
	WebElement loginbtn;
	@FindBy(xpath="//*[@id=\"forgotPasswordLink\"]/a")
	WebElement forgotpassword;
	@FindBy(xpath="//*[@id=\"securityAuthentication_userName\"]")
	WebElement forgotpassbox;
	@FindBy(xpath="//*[@id=\"btnSearchValues\"]")
	WebElement resetbtn;
	@FindBy(xpath="//*[@id=\"btnCancel\"]")
	WebElement cancelbtn;
	@FindBy(xpath="//div[@id='logInPanelHeading']")
	WebElement LoginTitle;
	
	
	// 1. By Locators: OR
//	private By emailId = By.id("email");
//	private By password = By.id("passwd");
//	private By signInButton = By.id("SubmitLogin");
//	private By forgotPwdLink = By.linkText("Forgot your password?111");

	// initialization page object
	public LogInPage1() {
		PageFactory.initElements(driver, this);//to avoid no such element Exception
	}


	// 3. page actions: features(behavior) of the page the form of methods:

	public SignInPage getLoginPageTitle() {
		return null;
//		String  expectedText="LOGIN Panel";
//    	String actualText = driver.findElement (By.xpath("//div[@id='logInPanelHeading']")).getText();
//		//assertEquals(actualText,expectedText);
//    	System.out.println("title page");
//		return new SignInPage();
		//return driver.getTitle();
	}
//	//
	//public void final getLoginPageTitle() {
		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	
		//assertEquals(driver.getTitle(), "OrangeHRM");
		//System.out.println("Title  works");
		



	public void enterUserName() {
		driver.findElement(userid).sendKeys("Admin");
	}

	public void enterPassword() {
		driver.findElement(password1).sendKeys("admin@123");
	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}


}

