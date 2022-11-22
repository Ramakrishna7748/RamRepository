package com.test.pizzahut;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.util.Precision;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	WebDriver driver = null;
	public String verificationError = "";

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReort.html");
		htmlReporter.config().setDocumentTitle("AutomationReport");// Title of the report
		htmlReporter.config().setReportName("Functional Report");// Name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Ram");
		extent.setSystemInfo("Browser", "chrome");

	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	@BeforeMethod
//	    @Parameters("browser")
	public void initialization() throws InterruptedException {
//	    	if(browser.equals("chrome")) {
//	    			
//	    		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-geolocation");
		// driver=new ChromeDriver(options);
		// HtmlUnitDriver driver=new HtmlUnitDriver();
		// driver=new ChromeDriver();
		// ChromeOptions options = new ChromeOptions();
		// options.setHeadless(true);
		// options.addArguments("--headless");
		driver = new ChromeDriver(options);

//	        WebDriverManager.chromedriver().setup();
//	        ChromeOptions options=new ChromeOptions();
//	        options.addArguments("disable-geolocation");
//	        driver=new ChromeDriver(options);
//	        
		driver.manage().window().maximize();
		driver.get("https://www.pizzahut.co.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement sel = driver.findElement(By.xpath("(//input[@type='text'])"));
		sel.sendKeys("jnmc");
//	        Thread.sleep(3000);
		sel.sendKeys(Keys.ENTER);

	}

	// positive testcase cartvalue>500
	@Test
	public void m1() throws InterruptedException {
		try {
			String actual = "Voucher applied! Rs. 125 Off on bill value above Rs.500.";

			// select pizza
			driver.findElement(By.xpath("(//a[contains(@class,'typography-4')])[2]")).click();

			//
			driver.findElement(By.xpath("(//button[@class='button button--md button--green flex-1 font-semibold'])[2]"))
					.click();

			// It will select the pizza of Rs.529 and add it to the cart
			// driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div[1]/a[2]/div[3]/div/button/span[1]/span")).click();

			// It will click on apply coupon link
			driver.findElement(By.xpath("//span[text()='Apply Voucher code or Gift Card']")).click();

			// Applying the coupon code
			driver.findElement(By.cssSelector("input[name='voucherId']")).sendKeys("HUT125");

			// click on Reedem button
			driver.findElement(By.xpath("//span[text()='Redeem']")).click();

			// Additional box of discount activated message
			driver.findElement(By.xpath("//button[@class='button button--green mb-10']")).click();

			// Final validation coupon code 500

			if (driver.findElement(By.xpath("//*[@id=\"basket\"]/div[1]/div/div/div[1]")).getText().equals(actual)) {
				System.out.println(
						"User is successfully able to apply the voucher for purchasing the pizza greater than Rs.500");
			} else {
				System.out.println("User is not able to apply the coupon");
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error in positive testcase cartvalue>500");

			verificationError = e.getMessage();
		}
	}

	// Negative testcase cartvalue<500
	@Test()

	public void m2() throws InterruptedException {
		try {
			String actual = "Voucher applied! Rs. 125 Off on bill value above Rs.500.";

			// select pizza
			driver.findElement(By.xpath("(//a[contains(@class,'typography-4')])[2]")).click();

			// add pizza to cart
			driver.findElement(By.xpath("(//button[@class='button button--md button--green flex-1 font-semibold'])[1]"))
					.click();

			// It will click on apply coupon link
			driver.findElement(By.xpath("//span[text()='Apply Voucher code or Gift Card']")).click();

			// Applying the coupon code
			driver.findElement(By.cssSelector("input[name='voucherId']")).sendKeys("HUT125");

			// click on Reedem button
			driver.findElement(By.xpath("//span[text()='Redeem']")).click();

			// Additional box of discount activated message
			driver.findElement(By.xpath("//button[@class='button button--green mb-10']")).click();

			// Final validation coupon code cartvalue > 500

			if (driver.findElement(By.xpath("//*[@id=\"basket\"]/div[1]/div/div/div[1]")).getText().equals(actual)) {
				System.out.println(
						"User is successfully able to apply the voucher for purchasing the pizza equals to Rs.500");
			} else {
				System.out.println("User is not able to apply the coupon since cartvalue less than 500");
			}

		} catch (Exception e) {
			verificationError = e.getMessage();
		}
	}

	// Negative Discount-Pickup a Product which is already in a deal & Trying to get
	// Discount
	@Test()

	public void m3() throws InterruptedException {
		try {
			String actual = "Voucher applied! Rs. 125 Off on bill value above Rs.500.";

			// click on customise pizza
			driver.findElement(By.xpath("(//button[@class='sc-AxheI bqJhFB'])[1]")).click();
			Thread.sleep(5000);
			// choose a pizza 1st
			driver.findElement(By.xpath("//*[@id=\"DealWizardScrollContainer\"]/div[3]/div/div[1]/div/div/div[2]"))
					.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//span[text()='Add'])[5]")).click();
			Thread.sleep(5000);
			// choose a pizza 2nd
			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[3]/div/div[2]/div/div/div[2]"))
					.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//span[text()='Add'])[4]")).click();
			Thread.sleep(1000);
			// click on add deal to basket
			driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/button")).click();
			Thread.sleep(3000);
			// click on apply voucher code
			driver.findElement(By.xpath("//*[@id=\"basket\"]/div[1]/button/div/span[2]")).click();
			// apply voucher code HUT125
			driver.findElement(By.name("voucherId")).sendKeys("HUT125");
			// Click on redeem
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(5000);
			// click on ok
			driver.findElement(By.xpath("//button[@class='button button--green mb-10']")).click();
			Thread.sleep(3000);
			// validation of voucher code

			if (driver.findElement(By.xpath("//*[@id=\"basket\"]/div[1]/div/div/div[1]")).getText().equals(actual)) {
				System.out.println(
						"User is successfully able to apply the voucher for purchasing the pizza equals to Rs.500");
			} else {
				System.out.println("User is not able to apply the coupon since the product is already in Deal");
			}

		} catch (Exception e) {
			verificationError = e.getMessage();
		}
	}

	// if the Cart value is below 500 we can add more quantity to make offer
	// available
	// we can also choose as many pizzas items to match the min cart value to avail
	// the offer
	@Test()

	public void m4() throws InterruptedException {
		try {
			String actual = "Voucher applied! Rs. 125 Off on bill value above Rs.500.";

			// select pizza
			driver.findElement(By.xpath("(//a[contains(@class,'typography-4')])[2]")).click();

			// add pizza to cart
			driver.findElement(By.xpath("(//button[@class='button button--md button--green flex-1 font-semibold'])[1]"))
					.click();
			// add pizza2 to cart
			driver.findElement(By.xpath("(//button[@class='button button--md button--green flex-1 font-semibold'])[1]"))
					.click();

			// It will click on apply coupon link
			driver.findElement(By.xpath("//span[text()='Apply Voucher code or Gift Card']")).click();

			// Applying the coupon code
			driver.findElement(By.cssSelector("input[name='voucherId']")).sendKeys("HUT125");

			// click on Reedem button
			driver.findElement(By.xpath("//span[text()='Redeem']")).click();

			// Additional box of discount activated message
			driver.findElement(By.xpath("//button[@class='button button--green mb-10']")).click();

			// Final validation coupon code cartvalue >= 500

			if (driver.findElement(By.xpath("//*[@id=\"basket\"]/div[1]/div/div/div[1]")).getText().equals(actual)) {
				System.out.println(
						"User is successfully able to apply the voucher for purchasing the pizza >= to Rs.500");
			} else {
				System.out.println(
						"User is not able to apply the coupon since cartvalue less than 500 add more items to Avail this offer");

			}

		} catch (Exception e) {
			verificationError = e.getMessage();
		}
	}

	@AfterMethod
	public void AfterMethod() {
		// driver.close();
	}
}
