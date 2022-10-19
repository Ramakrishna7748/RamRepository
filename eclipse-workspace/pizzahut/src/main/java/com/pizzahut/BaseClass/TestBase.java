package com.pizzahut.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	public TestBase () {
		prop = new Properties();
		
		try {
			FileInputStream ip;
			ip = new FileInputStream(System.getProperty("user.dir")+
					"\\src/main/java/com/pizzahut/properties");
			prop.load(ip);
			
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

	}
	
	// Initialization of browser
	public static void initialization () {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
       
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Capgemini\\Selenium\\SeleniumWebDriver1\\selenium-java-3.141.59\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
////	String browserName = prop.getProperty("browser");
//		String browserPath = System.getProperty("user.dir") + "\\src\\main\\resources\\com\\qa\\orangehrm\\seleniumbrowserdriver\\";
//		
		
//		if (browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", browserPath + "chromedriver.exe");
//			driver = new ChromeDriver();		
//		} else if (browserName.equalsIgnoreCase("ie")) {
//			System.setProperty("webdriver.ie.driver", browserPath + "chromedriver.exe");
//			driver = new InternetExplorerDriver();
//			
//		} else if (browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.geko.driver", browserPath + "geckodriver.exe");
//			driver = new FirefoxDriver();	
//			
//		} else {
//			System.out.println("Please define browser name (chrome/ie/firefox) into config.properties file.");
//
//		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.get(prop.getProperty("url"));
		driver.get("https://www.pizzahut.co.in/");
	}
		
		public static void SearchAddress() throws InterruptedException {
        WebElement sel = driver.findElement(By.xpath("(//input[@type='text'])"));
//      Thread.sleep(3000);
//      sel.sendKeys("jnmc");
//      Thread.sleep(4000);
//      sel.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//      Thread.sleep(3000);
        Thread.sleep(3000);
        sel.sendKeys("jnmc");
        Thread.sleep(3000);
        sel.sendKeys(Keys.ENTER);
	
	}
	
}
