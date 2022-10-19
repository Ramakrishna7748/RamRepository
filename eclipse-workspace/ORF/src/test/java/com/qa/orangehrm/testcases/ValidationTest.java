package com.qa.orangehrm.testcases;

import static org.testng.Assert.assertEquals;


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



public class ValidationTest extends TestBase {
	HomePage homepage;
	DateDropBox datedropbox;
	ValidationPage validationpage;
	LogInPage loginpage;
	AddTime addtime;
	
	public ValidationTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		validationpage=new ValidationPage();
		datedropbox=new DateDropBox();
		homepage=new HomePage();
		loginpage=new LogInPage();
		addtime=new AddTime();
	}
	
	@AfterMethod
	public void cleanUp() {
		Testutil.takeScreenshotAtEndOfTest("ValidationPage");
		// close driver
		driver.close();
		driver.quit();
	}
	
	
	@Test
	public void datedropboxTest() {
		homepage.clickondatedropbox();
		assertEquals(false, ValidationPage.isValidnum("2022-06-06 to 2022-06-12"));//22
		assertEquals(false, ValidationPage.isValidnum("2022-06-06 to 2022-06-1222"));//24
		assertEquals(false, ValidationPage.isValidnum("2022"));//4
		assertEquals(true, ValidationPage.isValidnum("2022-06"));//7
		assertEquals(true, ValidationPage.isValidnum("2022-06-06 to 2022-06"));//19
	}
	
	@Test
	public void addtimesheetTest() {
		homepage.clickonaddtimsheet();
		assertEquals(true, ValidationPage.isValidnum("2022-06-02"));//10
		assertEquals(true, ValidationPage.isValidnum("2022-06-0212"));//12
		assertEquals(false, ValidationPage.isValidnum("2022"));//4
		assertEquals(false, ValidationPage.isValidnum("202"));//3
		
	}
	
	@Test
	public void projectnameTest() {
		homepage.clickonprojectname();
		assertEquals(false, ValidationPage.isValidnum("Global Corp and Co - Global Software phase - 2"));//37
		assertEquals(true, ValidationPage.isValidnum("ACME Ltd - ACME Ltd"));//15
		assertEquals(true, ValidationPage.isValidnum("ACME Ltd - ACME Lt"));//14
		assertEquals(false, ValidationPage.isValidnum("Global Corp and Co - Global Software phase - 23"));//38
		assertEquals(true, ValidationPage.isValidnum("Global Corp and Co -"));//16
		
	}
	
	@Test
	public void projectactivityboxTes() {
		homepage.clickonactivitybox();
		assertEquals(true, ValidationPage.isValidnum("Bug fixes"));//8
		assertEquals(true, ValidationPage.isValidnum("Administration"));//14
		assertEquals(true, ValidationPage.isValidnum("Bug fixe"));//7
		assertEquals(false, ValidationPage.isValidnum("Assessing Project And Resourse"));//26
		assertEquals(false, ValidationPage.isValidnum("Assessing Project And Resourses"));//27
		
	}
	
	@Test
	public void employeenameboxTes() {
		homepage.clickonemployeenamebox();
		assertEquals(true, ValidationPage.isValidnum("Orange Test"));//10
		assertEquals(true, ValidationPage.isValidnum("jyothi lakshmisetty"));//20
		assertEquals(true, ValidationPage.isValidnum("jyothi lakshmisetty12"));//22
		assertEquals(true, ValidationPage.isValidnum("Orange "));//6
		assertEquals(true, ValidationPage.isValidnum("Orang"));//5
	}
	
	@Test
	public void commentboxTest() {
		homepage.clickoncommentbox();
		assertEquals(true, ValidationPage.isValidnum("Amrut"));//5
		assertEquals(false, ValidationPage.isValidnum("Am"));//2
		assertEquals(false, ValidationPage.isValidnum("abcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyz"));//104
		assertEquals(false, ValidationPage.isValidnum("abcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuv"));//100
		assertEquals(false, ValidationPage.isValidnum("abcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrstuvwxyzabcdefghijlkmnopqrst"));//98
	}
	

}
