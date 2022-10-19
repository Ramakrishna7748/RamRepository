package com.test.pizzahut;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//

import com.pizzahut.BaseClass.TestBase;
import com.pizzahut.pages.Coupon;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


	@Test
	public class CouponTestCases extends TestBase
	{
		Coupon coupon;
		public CouponTestCases() {
			super();
		}


	@BeforeMethod
	@Given("^User is on Home Page and Enters Address$")
	public void setup() throws InterruptedException  {
		initialization();
		SearchAddress();
		//ChromeOptions options=new ChromeOptions();
		coupon=new Coupon();
		//lp = new Coupon(driver);
	}
	
	
		
	@When("^Validate Coupon for Single Product Cart Value Above 500$")
	@Test(priority=1,groups="positive")
		public void Validate_Coupon_for_Single_Product_Cart_Value_Above_500 ()
		{
			System.out.println("m1 Works");
			coupon.m11();
			
		}
	
	
	@And("^Validate Coupon for Cart Value Below 500$")
	@Test(priority=4,groups="negative")
		public void Validate_Coupon_for_Cart_Value_Below_500()
		{
		
		coupon.m22();
		
		}
	
	@And("^Validate Coupon for already existing deal$")
	@Test(priority=3,groups="negative")
		public void Validate_Coupon_for_already_existing_deal()
		{
		coupon.m33();
		}
	@And("^Validate Coupon for Multiple Products Cart Value above 500$")
	@Test(priority=2,groups="positive")
		public void Validate_Coupon_for_Multiple_Products_Cart_Value_Above_500()
		{
		coupon.m44();
		}
	
	@AfterMethod
	@Then("^Take Screenshots of all the conditions Tested$")
	public void close () {
		Testutil.takeScreenshotAtEndOfTest("Coupon");
		driver.close();
		driver.quit();
	}
	
	}
	
	
	
	
	
	

	
	