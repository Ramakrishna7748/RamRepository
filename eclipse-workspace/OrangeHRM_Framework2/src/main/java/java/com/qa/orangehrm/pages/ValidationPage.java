package com.qa.orangehrm.pages;

import static org.testng.Assert.assertEquals;


import com.qa.orangehrm.pages.LogInPage;

import io.cucumber.java.en.When;

import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.base.TestBase;

public class ValidationPage extends LogInPage{
	
	// Initializing the page objects:
	
		public ValidationPage() {
			PageFactory.initElements(driver, this);
		}
		@When("Validation of Title page")
		public void assertLogInPageTitle() {

			driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

			assertEquals(driver.getTitle(), "OrangeHRM");
			System.out.println("The Title of Validatio Page is:"+driver.getTitle());
		}
		
		 
	
		
		//Numeric
		//@When("Validate the DateDropBox")
		public static boolean isValidnum(String DateDropBox) {
			if (DateDropBox.length()>=5 && DateDropBox.length()<=22) {
				return true;
			} else {
				return false;
			}
		}
		
		//addTimesheet
		//("^Validation of AddTimesheet$")
		public static boolean isValiddate(String Addtimesheetbox) {
			if (Addtimesheetbox.length()>=4 && Addtimesheetbox.length()<=10) {
				return true;
			} else {
				return false;
			}
		}
		
		//projectname
		//("^Validation of ProjectNameBox$")
		public static boolean isValiddateproject(String projectnamebox) {
			if (projectnamebox.length()>=15 && projectnamebox.length()<=37) {
				return true;
			} else {
				return false;
			}
		}
		
		
		//activitybox
		//("^Validation of ProjectActivityBox$")
		public static boolean isValiddateactivity(String projectactivitybox) {
			if (projectactivitybox.length()>=8 && projectactivitybox.length()<=26) {
				return true;
			} else {
				return false;
			}
		}
		
		//Employee name box
		//@When("^Employee name box is valid"$)
		public static boolean isValidemployeenamebox(String Employeename) {
			if (Employeename.length()>=5 && Employeename.length()<=20) {
				return true;
			} else {
				return false;
			}
		}
		
		//comment box
		// ("^comment Box is Valid$")
		public static boolean isValidcommentbox(String commentbox) {
			if (commentbox.length()>=2 && commentbox.length()<=100) {
				return true;
			} else {
				return false;
			}
		}
		
	
		
	

}
