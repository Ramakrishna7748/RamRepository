package com.qa.orangehrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.TestBase;
import com.qa.orangehrm.pages.AddTime;
import com.qa.orangehrm.pages.CheckBox;
import com.qa.orangehrm.pages.DateDropBox;
import com.qa.orangehrm.pages.EditBtn;
import com.qa.orangehrm.pages.EmployeeTimeMenu;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.MyTimeMenu;
import com.qa.orangehrm.pages.TimeMenu;
import com.qa.orangehrm.pages.ViewBtn;
import com.qa.orangehrm.util.Testutil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeTestCases extends TestBase {
	
	HomePage homepage;
	
	public HomeTestCases() {
		super();
	}
	
	//initialization
	@BeforeMethod
	@Given("^A$")
	public void setUp() {
		initialization();
		homepage= new HomePage();
	}
	

	@Test 
	@When("B")
	public void addtimesheetboxTest() {
		homepage.clickonaddtimsheet();
		AddTime.assertAddTime();
	}

	
	@Test
	@And("C")
	public void okbtnTest() {
		homepage.clickonokbtn();
		AddTime.assertAddTime();
	}
	

	
	//Edit Button
	
	@Test
	@And("D")
	public void checkboxTest() {
		homepage.clickoncheckbox();
		CheckBox.assertCheckBox();
	}
	

	@Test
	@And("E")
	public void projectnameboxTest() {
		homepage.clickonprojectname();
		EditBtn.assertEditBtn();
	}
	
	@Test
	@And("F")
	public void activityboxTest() {
		homepage.clickonactivitybox();
		EditBtn.assertEditBtn();
	}
	
	
	@Test
	@And("G")
	public void savebtnTest() {
		homepage.clickonsavebtn();
		EditBtn.assertEditBtn();
	}
	
	@Test
	@And("H")
	public void addrowbtTest() {
		homepage.clickonaddrowbtn();
		EditBtn.assertEditBtn();
	}

	
	//EmployeeTimesheet
	

	@Test
	@And("I")
	public void employeenameTest() {
		homepage.clickonemployeenamebox();
		EmployeeTimeMenu.assertEmployeeTimeMenu();
	}
	

	
	@Test
	@And("J")
	public void commentboxTest() {
		homepage.clickoncommentbox();
		ViewBtn.assertViewBtn();
	}
	
	@Test
	@And("K")
	public void approvebtnTest() {
		homepage.clickonapprovebtn();
		ViewBtn.assertViewBtn();
	}
	@Then("Z")
	@AfterMethod
	public void cleanUp() {
		Testutil.takeScreenshotAtEndOfTest("HomePage");
		
		driver.close();
		driver.quit();
	}



}
