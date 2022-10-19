package com.qa.orangehrm.pages;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.base.TestBase;

public class ValidationPage extends TestBase{
	
	// Initializing the page objects:
		public ValidationPage() {
			PageFactory.initElements(driver, this);
		}
		
		public void assertLogInPageTitle() {

			driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

			assertEquals(driver.getTitle(), "OrangeHRM");
		}
		
		 //username
	
		
		//Numeric
		public static boolean isValidnum(String DateDropBox) {
			if (DateDropBox.length()>=5 && DateDropBox.length()<=22) {
				return true;
			} else {
				return false;
			}
		}
		
		//addTimesheet
		public static boolean isValiddate(String Addtimesheetbox) {
			if (Addtimesheetbox.length()>=4 && Addtimesheetbox.length()<=10) {
				return true;
			} else {
				return false;
			}
		}
		
		//projectname
		public static boolean isValiddateproject(String projectnamebox) {
			if (projectnamebox.length()>=15 && projectnamebox.length()<=37) {
				return true;
			} else {
				return false;
			}
		}
		
		//activitybox
		public static boolean isValiddateactivity(String projectactivitybox) {
			if (projectactivitybox.length()>=8 && projectactivitybox.length()<=26) {
				return true;
			} else {
				return false;
			}
		}
		
		//Employee name box
		public static boolean isValidemployeenamebox(String Employeename) {
			if (Employeename.length()>=5 && Employeename.length()<=20) {
				return true;
			} else {
				return false;
			}
		}
		
		//comment box
		
		public static boolean isValidcommentbox(String commentbox) {
			if (commentbox.length()>=2 && commentbox.length()<=100) {
				return true;
			} else {
				return false;
			}
		}
		
	
		
	

}
