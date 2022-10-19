package com.qa.orangehrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.TestBase;
import com.qa.orangehrm.pages.ForgotPassword;
import com.qa.orangehrm.pages.LogInPage;
import com.qa.orangehrm.pages.SignInPage;
import com.qa.orangehrm.util.Testutil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.qa.orangehrm.pages.HomePage;

//import junit.framework.Assert;

public class LogInTestCases extends TestBase{
	
	LogInPage loginpage;
	Testutil testutil;
	HomePage homepage1;
	
	
	public LogInTestCases() {
		super();
	}
	//Browser Launch
	@BeforeMethod
	@Given("Launch the browser")
	public void launch_the_browser() {
		initialization();
		loginpage =new LogInPage();
		System.out.println("initialization works");
	}
	//Validation of title page
	@Test
	@When("Validate the title of the page")
	public void validate_the_title_of_the_page() {
		
		loginpage.assertLogInpageTitle();
		SignInPage.assertSignInPage();
		
	}
	
	
	
	//Tc-1
	@Test
	@When("Successful Login")
	public void successful_login() throws InterruptedException  {
		loginpage.clickonbutton();
		Thread.sleep(1000);
		SignInPage.assertSignInPage();
		System.out.println("loginTest1 works");
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
	}
	
	//Tc-2
	@Test
	@When("^UnSuccessful Login1$")
	public void un_successful_login1() throws InterruptedException {
		loginpage.clickonbutton1();
		SignInPage.assertSignInPage();
		Thread.sleep(1000);
		System.out.println("loginTest2 works");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	//Tc-3
	@Test
	@And("^UnSuccessful Login2$")
	public void un_successful_login2() {
		loginpage.clickonbutton2();
		SignInPage.assertSignInPage();
		System.out.println("loginTest2 works");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	//Tc-4
	@Test
	@When("^UnSuccessful Login3$")
	public void un_successful_login3() {
		loginpage.clickonbutton3();
		SignInPage.assertSignInPage();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	//Tc-5
	@Test
	@When("^UnSuccessful Login4$")
	public void un_successful_login4() {
		loginpage.clickonbutton4();
		SignInPage.assertSignInPage();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	//Tc-6
	@Test
	@When("^UnSuccessful Login5$")
	public void un_successful_login5() {
		loginpage.clickonbutton5();
		SignInPage.assertSignInPage();
		System.out.println("loginTest5 works");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	//Tc-7
	@Test
	@When("^UnSuccessful Login6$")
	public void un_successful_login6() {
		loginpage.clickonbutton6();
		SignInPage.assertSignInPage();
		System.out.println("loginTest7 works");
		//Assert.assertTrue(LogInPage.getErrorMessage(driver).getText().contains("Username cannot be empty"));
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
	}
	
	
	
	//Forgot password
	
	@Test
	@When("^Open ForgetPassword Box$")
	public void open_forget_password_box() {
		loginpage.clickonforgotpassword();
		SignInPage.assertSignInPage();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	
	//Tc-1
	@Test
	@When("Check User Password Reset1")	
	public void check_user_password_reset1() {
		loginpage.clickonforgottextbox();
		ForgotPassword.assertForgotPassword();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	//Tc-2
	@Test
	@When("^Check User Password Reset2$")
	public void check_user_password_reset2() {
		loginpage.clickonforgottextbox1();
		ForgotPassword.assertForgotPassword();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	//Tc-3
	@Test
	@When("^Check User Password Reset3$")
	public void check_user_password_reset3() {
		loginpage.clickonforgottextbox2();
		ForgotPassword.assertForgotPassword();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	//Tc-4
	@Test
	@When("^Check User Password Reset4$")
	public void check_user_password_reset4() {
		loginpage.clickonforgottextbox3();
		ForgotPassword.assertForgotPassword();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		System.out.println("reset4");
	}
	
	//Tc-5
	@Test
	@When("^Check User Password Reset5$")
	public void check_user_password_reset5() {
		loginpage.clickonforgottextbox4();
		ForgotPassword.assertForgotPassword();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		System.out.println("Reset5 works");
		
	}
//	@Test
//	@And("user succesfull logout")
//	public void successful_logout() throws InterruptedException {
//		loginpage.logoutbtn1();
//		SignInPage.assertSignInPage();
//		System.out.println("logout works");
//		
//		
//		
//	}
	
//	
//	//@AfterMethod
//	@Then("^Take the ScreenShot$")
//	public void take_the_screen_shot() {
//		testutil.takeScreenshotAtEndOfTest("LogInPage");
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//		System.out.println("Screenshot ");
//		//driver.close();
//		//driver.quit();
//	}

}