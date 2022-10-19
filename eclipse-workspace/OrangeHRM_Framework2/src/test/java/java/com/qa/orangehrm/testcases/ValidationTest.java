  package com.qa.orangehrm.testcases;

import static org.testng.Assert.assertEquals;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.TestBase;
import com.qa.orangehrm.pages.AddTime;
import com.qa.orangehrm.pages.DateDropBox;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LogInPage;
import com.qa.orangehrm.pages.ValidationPage;
import com.qa.orangehrm.util.Testutil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ValidationTest extends TestBase {
	ValidationPage validationpage;
	HomePage homepage;
	DateDropBox datedropbox;
	
	LogInPage loginpage;
	AddTime addtime;
	
	public ValidationTest() {
		super();
	}
	
	@BeforeMethod
	@Given("^Launch the Browser and url$")
	public void setUp() {
		initialization();
		
//		WebDriver driver;
//		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Capgemini\\Selenium\\SeleniumWebDriver1\\selenium-java-3.141.59\\chromedriver.exe");
//		  driver = new ChromeDriver();
//		 driver.get("https://opensource-demo.orangehrmlive.com/");
//		
		
		validationpage=new ValidationPage();
		datedropbox=new DateDropBox();
		homepage=new HomePage();
		loginpage=new LogInPage();
		addtime=new AddTime();
	}
	
	
	@Test
	@When("^Validate weather DateDropBox isvalid$")
	public void datedropboxTest() throws InterruptedException {
		homepage.clickondatedropbox();
		assertEquals(false, ValidationPage.isValidnum("2022-06-06 to 2022-06-12"));
		assertEquals(false, ValidationPage.isValidnum("2022-06-06 to 2022-06-1222"));
		assertEquals(false, ValidationPage.isValidnum("2022"));//4
		assertEquals(true, ValidationPage.isValidnum("2022-06"));//7
		assertEquals(true, ValidationPage.isValidnum("2022-06-06 to 2022-06"));
		System.out.println("Date works");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@Test
	@And("^Validate the AddTimesheetDates$")
	public void addtimesheet() {
		homepage.clickonaddtimsheet();
		assertEquals(true, ValidationPage.isValidnum("2022-06-02"));
		assertEquals(true, ValidationPage.isValidnum("2022-06-0212"));
		assertEquals(false, ValidationPage.isValidnum("2022"));
		assertEquals(false, ValidationPage.isValidnum("202"));
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		System.out.println("TimeSheet Works");
	}
	
	@Test
	@And("^Validate the ProjectNameBox$")
	public void projectnameTest() {
		homepage.clickonprojectname();
		assertEquals(false, ValidationPage.isValidnum("Global Corp and Co - Global Software phase - 2"));
		assertEquals(true, ValidationPage.isValidnum("ACME Ltd - ACME Ltd"));//15
		assertEquals(true, ValidationPage.isValidnum("ACME Ltd - ACME Lt"));//14
		assertEquals(false, ValidationPage.isValidnum("Global Corp and Co - Global Software phase - 23"));
		assertEquals(true, ValidationPage.isValidnum("Global Corp and Co -"));//16
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@Test
	@And("^Validate the Project ActivityBox$")
	public void projectactivityboxTes() {
		homepage.clickonactivitybox();
		assertEquals(true, ValidationPage.isValidnum("Bug fixes"));
		assertEquals(true, ValidationPage.isValidnum("Administration"));
		assertEquals(true, ValidationPage.isValidnum("Bug fixe"));
		assertEquals(false, ValidationPage.isValidnum("Assessing Project And Resourse"));
		assertEquals(false, ValidationPage.isValidnum("Assessing Project And Resourses"));
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@Test
	@And("^Validate the Employee name box is valid$")
	public void employeenameboxTes() {
		homepage.clickonemployeenamebox();
		assertEquals(true, ValidationPage.isValidnum("Orange Test"));
		assertEquals(true, ValidationPage.isValidnum("jyothi lakshmisetty"));
		assertEquals(true, ValidationPage.isValidnum("jyothi lakshmisetty12"));
		assertEquals(true, ValidationPage.isValidnum("Orange "));
		assertEquals(true, ValidationPage.isValidnum("Orang"));
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@Test
	@And ("^Validate the CommentBox$")
	public void commentboxTest() {
		homepage.clickoncommentbox();
		assertEquals(true, ValidationPage.isValidnum("Amrut"));
		assertEquals(false, ValidationPage.isValidnum("Am"));
		assertEquals(false, ValidationPage.isValidnum("abcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyz"));//104
		assertEquals(false, ValidationPage.isValidnum("abcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuv"));//100
		assertEquals(false, ValidationPage.isValidnum("abcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrst"));//98
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	@AfterMethod
	@Then("^Take Screenshot of ValidationPage$")
	public void cleanUp() {
		Testutil.takeScreenshotAtEndOfTest("ValidationPage");
		// close driver
		driver.close();
		driver.quit();
	}

}
