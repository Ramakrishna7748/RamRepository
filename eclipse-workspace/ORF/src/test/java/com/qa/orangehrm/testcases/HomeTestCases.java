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

public class HomeTestCases extends TestBase {
	
	HomePage homepage;
	
	public HomeTestCases() {
		super();
	}
	
	//initialization
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage= new HomePage();
	}
	
	@AfterMethod
	public void cleanUp() {
		Testutil.takeScreenshotAtEndOfTest("HomePage");
		
		driver.close();
		driver.quit();
	}
	
	@Test
	public void validatehomepage() {
		homepage.assertHomePageTitle();
	}
	
	@Test
	public void timemenuTest() {
		homepage.clickontimemenu();
		TimeMenu.assertTimeMenu();
	}
	
	@Test
	public void mytimesheetTest() {
		homepage.clickonmytimemenu();
		MyTimeMenu.assertMyTimeMenu();
	}
	
	@Test
	public void datedropboxTest() {
		homepage.clickondatedropbox();
		DateDropBox.assertDateDropBox();
	}
	
	@Test 
	public void addtimesheetboxTest() {
		homepage.clickonaddtimsheet();
		AddTime.assertAddTime();
	}
	
	
	@Test
	public void pickupdateTest() {
		homepage.clickonpickupdate();
		AddTime.assertAddTime();
	}
	
	@Test
	public void okbtnTest() {
		homepage.clickonokbtn();
		AddTime.assertAddTime();
	}
	
	
	@Test
	public void closebtnTest() {
		homepage.clickonclose();
		AddTime.assertAddTime();
	}
	
	//Edit Button
	
	@Test
	public void checkboxTest() {
		homepage.clickoncheckbox();
		CheckBox.assertCheckBox();
	}
	
	@Test
	public void editbtnTest() {
		homepage.clickoneditbtn();
		EditBtn.assertEditBtn();
	}
	
	@Test
	public void projectnameboxTest() {
		homepage.clickonprojectname();
		EditBtn.assertEditBtn();
	}
	
	@Test
	public void activityboxTest() {
		homepage.clickonactivitybox();
		EditBtn.assertEditBtn();
	}
	
	
	@Test
	public void savebtnTest() {
		homepage.clickonsavebtn();
		EditBtn.assertEditBtn();
	}
	
	@Test
	public void addrowbtTest() {
		homepage.clickonaddrowbtn();
		EditBtn.assertEditBtn();
	}
	
	@Test
	public void addrow1Test() {
		homepage.clickonaddrow1();
		EditBtn.assertEditBtn();
	}
	
	@Test
	public void removebtnTest() {
		homepage.clickonremovebtn();
		EditBtn.assertEditBtn();
	}
	
	@Test 
	public void cancelbuttonTest() {
		homepage.clickoncancelbutton();
		EditBtn.assertEditBtn();
	}
	
	
	
	//EmployeeTimesheet
	
	@Test 
	public void employeetimemenuTest() {
		homepage.clickonemployeetimemenu();
		EmployeeTimeMenu.assertEmployeeTimeMenu();
	}
	
	@Test
	public void employeenameTest() {
		homepage.clickonemployeenamebox();
		EmployeeTimeMenu.assertEmployeeTimeMenu();
	}
	
	@Test 
	public void viewbtnTest() {
		homepage.clickonviewbtn();
		ViewBtn.assertViewBtn();
	}
	
	@Test
	public void timesheetpendactTest() {
		homepage.clickontimesheetaction();
		ViewBtn.assertViewBtn();
	}
	
	@Test
	public void commentboxTest() {
		homepage.clickoncommentbox();
		ViewBtn.assertViewBtn();
	}
	
	@Test
	public void approvebtnTest() {
		homepage.clickonapprovebtn();
		ViewBtn.assertViewBtn();
	}
	
	@Test
	public void rejectbtnTest() {
		homepage.clickonrejectbtn();
		ViewBtn.assertViewBtn();
	}


}
