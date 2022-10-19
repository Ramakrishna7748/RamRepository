package com.qa.orangehrm.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_1 {
	private static WebElement element = null;
	
	 public static WebElement Userid(WebDriver driver)
	    {
	        element = driver.findElement(By.xpath("//*[@id=\"DUMMY1\"]"));
	        return element;
	    }
	 
	 public static WebElement Userid1(WebDriver driver)
	    {
	        element = driver.findElement(By.name("AuthenticationFG.USER_PRINCIPAL"));
	        return element;
	    }
	 
	 
	 public static WebElement Password(WebDriver driver)
	    {
	        element = driver.findElement(By.name("AuthenticationFG.ACCESS_CODE"));
	        return element;
	    }
	 
	 public static WebElement Login1(WebDriver driver)
	    {
	        element=driver.findElement(By.name("Action.VALIDATE_CREDENTIALS"));
	        return element;
	    }

}