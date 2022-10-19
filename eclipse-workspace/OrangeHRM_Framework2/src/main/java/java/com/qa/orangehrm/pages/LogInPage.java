package com.qa.orangehrm.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.orangehrm.base.TestBase;

public class LogInPage extends TestBase  {
	
	//object repository
	
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
	@FindBy(xpath="//a[@id=\"welcome\"]")
	WebElement welcomepaul;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	

	
	// initialization page object
	public LogInPage() {
		PageFactory.initElements(driver, this);//to avoid no such element Exception
		
	}
	public void assertLogInpageTitle() {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		//title=LoginPage.getLoginPageTitle();
		//System.out.println("Page title is:"+title);
		//Assert.assert(title.contains(expectedTitleName));
		String expectedTitle="OrangeHR";
		String actualTitle=driver.getTitle();
		System.out.println("Actual Title is:"+actualTitle);
		Assert.assertEquals(actualTitle,expectedTitle,"Title is matched");
		//System.out.println("Title  checks");
		//assertEquals(driver.getTitle(), "OrangeHRM");
	}
	//Tc-1
	public SignInPage clickonbutton() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		welcomepaul.click();
	
		logout.click();
		
		System.out.println("clickonbutton works");
		
		
		return new SignInPage();
	}
	
	//Tc-2
	public SignInPage clickonbutton1(){
		username.sendKeys("Ram");
		password.sendKeys("admin123");
		loginbtn.click();

		welcomepaul.click();
		
		logout.click();
		System.out.println("Button1 works");
		return new SignInPage();
	}
	
	//Tc-3
	public SignInPage clickonbutton2() {
		username.sendKeys("Admin");
		password.sendKeys("Ram123");
		loginbtn.click();
		return new SignInPage();
	}
	
//	//Tc-4
	public SignInPage clickonbutton3() {
		username.sendKeys("Asha");
		password.sendKeys("Asha123");
		loginbtn.click();
		return new SignInPage();
	}
	
	//Tc-5
	public SignInPage clickonbutton4() {
		username.sendKeys("A");
		password.sendKeys("admin123");
		loginbtn.click();
		return new SignInPage();
	}
	
	//Tc-6
	public SignInPage clickonbutton5() {
		username.sendKeys("Admin");
		password.sendKeys("a");
		loginbtn.click();
		return new SignInPage();
	}
	
	//Tc-7
	public SignInPage clickonbutton6() {
		username.sendKeys("");
		password.sendKeys("");
		loginbtn.click();
		return new SignInPage();
	}
	
	
	//forgotpassword
	
	
	public ForgotPassword clickonforgotpassword() {
		forgotpassword.click();
		return new ForgotPassword();
	}
	
	//Tc-1
	public ForgotPassword clickonforgottextbox() {
		forgotpassword.click();
		forgotpassbox.sendKeys("Admin");
		resetbtn.click();
		return new ForgotPassword();
	}
	
	//Tc-2
	public ForgotPassword clickonforgottextbox1() {
		forgotpassword.click();
		forgotpassbox.sendKeys("Amrut");
		resetbtn.click();
		return new ForgotPassword();
	}
	
	//Tc-3
	public ForgotPassword clickonforgottextbox2() {
		forgotpassword.click();
		forgotpassbox.sendKeys("abcdefghijklmnop");
		resetbtn.click();
		return new ForgotPassword();
	}
	
	//Tc-4
	public ForgotPassword clickonforgottextbox3() {
		forgotpassword.click();
		forgotpassbox.sendKeys("0000000000");
		resetbtn.click();
		return new ForgotPassword();
	}
	
	//Tc-5  Empty keys passing invalid data
	public ForgotPassword clickonforgottextbox4() {
		forgotpassword.click();
		forgotpassbox.sendKeys("");
		resetbtn.click();
		return new ForgotPassword();
	}
	public SignInPage logoutbtn1() throws InterruptedException  {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		welcomepaul.click();
		Thread.sleep(3000);
		logout.click();
		return new SignInPage();
		}
}	