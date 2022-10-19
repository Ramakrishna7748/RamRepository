package com.qa.orangehrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.TestBase;
import com.qa.orangehrm.pages.ForgotPassword;
import com.qa.orangehrm.pages.LogInPage;
import com.qa.orangehrm.pages.SignInPage;
import com.qa.orangehrm.util.Testutil;

public class LogInTestCases extends TestBase{
	
	LogInPage loginpage;
	
	public LogInTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage =new LogInPage();
	}
	
	@AfterMethod
	public void cleanUp() {
		Testutil.takeScreenshotAtEndOfTest("LogInPage");
		driver.close();
		driver.quit();
	}
	
	//Tc-1
	@Test
	public void logInTest() {
		loginpage.clickonbutton();
		SignInPage.assertSignInPage();
	}
	
	//Tc-2
	@Test
	public void logInTest2() {
		loginpage.clickonbutton1();
		SignInPage.assertSignInPage();
	}
	
	//Tc-3
	@Test
	public void logInTest3() {
		loginpage.clickonbutton2();
		SignInPage.assertSignInPage();
	}
	//Tc-4
	@Test
	public void logInTest4() {
		loginpage.clickonbutton3();
		SignInPage.assertSignInPage();
	}
	
	//Tc-5
	@Test
	public void logInTest5() {
		loginpage.clickonbutton4();
		SignInPage.assertSignInPage();
	}
	
	//Tc-6
	@Test
	public void logInTest6() {
		loginpage.clickonbutton5();
		SignInPage.assertSignInPage();
	}
	
	//Tc-7
	@Test
	public void logInTest7() {
		loginpage.clickonbutton6();
		SignInPage.assertSignInPage();
	}
	
	
	
	//Forgot password
	
	@Test
	public void forgotPassword() {
		loginpage.clickonforgotpassword();
		SignInPage.assertSignInPage();
	}
	
	
	//Tc-1
	@Test
	public void forgottextbox1() {
		loginpage.clickonforgottextbox();
		ForgotPassword.assertForgotPassword();
	}
	
	//Tc-2
	@Test
	public void forgottextbox2() {
		loginpage.clickonforgottextbox1();
		ForgotPassword.assertForgotPassword();
	}
	
	//Tc-3
	@Test
	public void forgottextbox3() {
		loginpage.clickonforgottextbox2();
		ForgotPassword.assertForgotPassword();
	}
	
	//Tc-4
	@Test
	public void forgottextbox4() {
		loginpage.clickonforgottextbox3();
		ForgotPassword.assertForgotPassword();
	}
	
	//Tc-5
	@Test
	public void forgottextbox5() {
		loginpage.clickonforgottextbox4();
		ForgotPassword.assertForgotPassword();
	}

}
