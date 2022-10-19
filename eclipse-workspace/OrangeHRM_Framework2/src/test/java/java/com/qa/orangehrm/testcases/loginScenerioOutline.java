package com.qa.orangehrm.testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginScenerioOutline{
	WebDriver driver=null;
	
	@Given("User Navigate to Login Page")
	public void m1() {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Capgemini\\Selenium\\SeleniumWebDriver1\\selenium-java-3.141.59\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("https://opensource-demo.orangehrmlive.com/");
			System.out.println("User is on Home Page");
	}
	
	@When("^User is on Home Page$")
	public void m2()
	{
		System.out.println("User is on Home Page");
	}
	
	@When(("^User enters \"(.*)\" and \"(.*)\"$"))
	public void m3(String username,String password) throws InterruptedException
	{
//		Thread.sleep(3000);
//		driver.findElement(By.id("divUsername")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(username);
//		driver.findElement(By.id("divPassword")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	}
	
	@Then("User On Landing Page Successfully")
	public void m4()
	{
		System.out.println("User On Landing Page Successfully");
	}
}