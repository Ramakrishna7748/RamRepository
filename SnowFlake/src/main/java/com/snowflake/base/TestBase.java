//package com.snowflake.base;
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Properties;
//import java.util.Set;
//import java.util.Timer;
//import java.util.concurrent.TimeUnit;
//
////import org.openqa.selenium.chrome.ChromeOptions;
////import org.openqa.selenium.firefox.FirefoxDriver;
////import org.openqa.selenium.ie.InternetExplorerDriver;
//
//
//public class TestBase {
//	
//	public static Properties prop;
//	public TestBase () {
//		prop = new Properties();
//		
//		try {
//			FileInputStream ip;
//			ip = new FileInputStream(System.getProperty("user.dir")+
//					"\\src/main/java/com/pizzahut/properties/properties");
//			prop.load(ip);
//			
//			} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//				
//			} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			}
//
//	}
//	
//	// Initialization of browser
//	@Parameters("browser")
//	public static void initialization(String browser) throws AWTException  {
//		 
//		if(browser.equals("chrome")) {
//			
//			
//		
//		WebDriverManager.chromedriver().setup();
//		Map<String, Object> prefs = new HashMap<String, Object>();
//	    
//		//add key and value to map as follow to switch off browser notification
//		//Pass the argument 1 to allow and 2 to block
//		//prefs.put("profile.default_content_setting_values.notifications", 2);
//		    
//		ChromeOptions options=new ChromeOptions();
//		// set ExperimentalOption - prefs 
//		//options.setExperimentalOption("prefs", prefs);
//		//options.addArguments("disable-notifications");
//        //driver=new ChromeDriver(options);
//		 //HtmlUnitDriver driver=new HtmlUnitDriver();
//		//driver=new ChromeDriver();
//		//ChromeOptions options = new ChromeOptions();
//		//options.setHeadless(true);
//		//options.addArguments("--headless");
//		driver = new ChromeDriver(options);
//	
//	
//
//		}
//		else if(browser.equals("edge")) {
//			WebDriverManager.edgedriver().setup();
//			EdgeOptions options=new EdgeOptions();
//	        options.addArguments("disable-geolocation");
//	        //options.addArguments("--headless");
//			driver = new EdgeDriver(options);	
//			
//		}
//       
////		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Capgemini\\Selenium\\SeleniumWebDriver1\\selenium-java-3.141.59\\chromedriver.exe");
////		WebDriver driver=new ChromeDriver();
//////	String browserName = prop.getProperty("browser");
////		String browserPath = System.getProperty("user.dir") + "\\src\\main\\resources\\com\\qa\\orangehrm\\seleniumbrowserdriver\\";
////		
//		
////		if (browserName.equalsIgnoreCase("chrome")) {
////			System.setProperty("webdriver.chrome.driver", browserPath + "chromedriver.exe");
////			driver = new ChromeDriver();		
////		} else if (browserName.equalsIgnoreCase("ie")) {
////			System.setProperty("webdriver.ie.driver", browserPath + "chromedriver.exe");
////			driver = new InternetExplorerDriver();
////			
////		} else if (browserName.equalsIgnoreCase("firefox")) {
////			System.setProperty("webdriver.geko.driver", browserPath + "geckodriver.exe");
////			driver = new FirefoxDriver();	
////			
////		} else {
////			System.out.println("Please define browser name (chrome/ie/firefox) into config.properties file.");
////
////		}
//		
//		
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//
//	
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//		driver.get(prop.getProperty("url"));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//		
////		new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
////		
////		Actions action = new Actions(driver);
////		action.sendKeys(Keys.ESCAPE).build().perform();
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ESCAPE);
//		robot.keyRelease(KeyEvent.VK_ESCAPE);
//		
////		while (true)
////		{
////		    try
////		    {
////		        driver.switchTo().alert().accept();
////		        break;
////		    }
////		    catch (NoSuchFieldError error)
////		    {
////		        Thread.sleep(1000);
////		    }
////		    int count = 0;
////		    do{
////		       if (driver.getWindowHandles().size() > 1) {
////		         // Alert is present
////		         driver.switchTo().alert().accept();
////		         System.out.println("inside alert/alert present");
////		         break;
////		       }
////		    } while(count < 1);
////		    System.out.println("Inside while/alert not present");
////		}
//	
////		WebDriverWait wait = new WebDriverWait(driver, 10);
////		WebElement element = wait.until(ExpectedConditions.alertIsPresent());
////        Alert alert = driver.switchTo().alert();
////        String alertText = alert.getText();
////        System.out.println(alertText);
////	//	driver.switchTo().alert().dismiss();
////        alert.dismiss();
////		System.out.println("HHH");
////		
////		try {
////			WebDriverWait wait=new WebDriverWait(driver,60);
////			if(wait.until(ExpectedConditions.alertIsPresent())==null) {
////				System.out.println("Alert not Displayed");
////			}
////			else {
//		
//				
//				
////			}
////			
////			
////		}
////		String alertMessage = driver.switchTo().alert().getText();
////		System.out.print(alertMessage);
////		//driver.get("https://www.pizzahut.co.in/");
//	}
//	
////		public static void SearchAddress() throws InterruptedException {
//
//	
//	}
//	
//}
