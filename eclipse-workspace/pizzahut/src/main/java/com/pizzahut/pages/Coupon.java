package com.pizzahut.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pizzahut.BaseClass.TestBase;


public class Coupon extends TestBase  {
	//object repository
	
	
	@FindBy(xpath="(//button[@class='sc-AxheI bqJhFB'])[1]")
	WebElement CustomizeDealPizza599;
//	@FindBy(xpath="//*[@id="DealWizardScrollContainer"]/div[3]/div/div[1]/div/div/div[2]")
//	WebElement ChoosePizza1;
	//*[@id="DealWizardScrollContainer"]/div[3]/div/div[1]/div/div/div[2]/h4/span
	@FindBy(xpath="(//span[text()='Choose a pizza'])[1]")
	WebElement ChoosePizza1;
	@FindBy(xpath="(//span[text()='Add'])[3]")
	WebElement MargheritaPizza1;
	
	@FindBy(xpath="/html/body/div[1]/div/div[1]/div/div[2]/div[3]/div/div[2]/div/div/div[2]")
	WebElement ChoosePizza2;
	@FindBy(xpath="(//span[text()='Add'])[3]")
	WebElement MargheritaPizza2;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div[3]/div/button")
	WebElement AddDealToBasket;
	@FindBy(xpath="(//a[contains(@class,'typography-4')])[2]")
	WebElement pizzaTab;
	@FindBy(xpath="(//button[@class='button button--md button--green flex-1 font-semibold'])[2]")
	WebElement TandooriPaneer520;
	@FindBy(xpath="(//button[@class='button button--md button--green flex-1 font-semibold'])[1]")
	WebElement Margherita279;
	
	@FindBy(xpath="//span[text()='Apply Voucher code or Gift Card']")
	WebElement ClickApplyCoupon;
	@FindBy(css = "input[name='voucherId']")
	WebElement applycouponcode;
	
	@FindBy(xpath="//span[text()='Redeem']")
	WebElement Reedembutton;
	@FindBy(xpath="//button[@class='button button--green mb-10']")
	WebElement okbutton;

	@FindBy(xpath="//*[@id=\"basket\"]/div[1]/div/div/div[1]")
	WebElement voucherappliedtxt;
	
	public Coupon()
	{
		
		
		PageFactory.initElements(driver, this);
	}

	
	public void m11()
	{
		System.out.println("Enter inside m11 coupon");
		try {
    		String actual = "Voucher applied! Rs. 125 Off on bill value above Rs.500.";
    		System.out.println("Inside try block");
    		
    		pizzaTab.click();
    		TandooriPaneer520.click();
    		ClickApplyCoupon.click();
    		applycouponcode.sendKeys("HUT125");
    		Reedembutton.click();
    		okbutton.click();
    		System.out.println("Inside try block down");

		
		
		//Final validation coupon code 500


        if (voucherappliedtxt.getText().equals(actual)) {
            System.out.println("User is successfully able to apply the voucher for purchasing the pizza greater than Rs.500");
        } else {
            System.out.println("User is not able to apply the coupon");
        }
		
		
		
		
	}catch (Exception e) {
		System.out.println(e);
		System.out.println("Error in positive testcase cartvalue>500");
		
	
	//	verificationError = e.getMessage();
    }
    
	}
	public void m22()
	{
		System.out.println("Enter inside m11 coupon");
		try {
    		String actual = "Voucher applied! Rs. 125 Off on bill value above Rs.500.";
    		System.out.println("Inside try block");
    		
    		//driver.findElement(By.xpath("(//a[contains(@class,'typography-4')])[2]")).click();
  	      
    		pizzaTab.click();
    		Margherita279.click();
    		ClickApplyCoupon.click();
    		applycouponcode.sendKeys("HUT125");
    		Reedembutton.click();
    		okbutton.click();
    		System.out.println("Inside try block down");

		
		
		//Final validation coupon code 500


        if (voucherappliedtxt.getText().equals(actual)) {
            System.out.println("User is successfully able to apply the voucher for purchasing the pizza greater than Rs.500");
        } else {
            System.out.println("User is not able to apply the coupon");
        }
		
		
		
		
	}catch (Exception e) {
		System.out.println(e);
		System.out.println("Error in positive testcase cartvalue>500");
		
	
	//	verificationError = e.getMessage();
    }
    
	}
	public void m33()
	{
		System.out.println("Enter inside m11 coupon");
		try {
    		String actual = "Voucher applied! Rs. 125 Off on bill value above Rs.500.";
    		System.out.println("Inside try block");
    		
    		//driver.findElement(By.xpath("(//a[contains(@class,'typography-4')])[2]")).click();
  	      	
    		CustomizeDealPizza599.click();
    		Thread.sleep(3000);
    		ChoosePizza1.click();
    		Thread.sleep(3000);
    		MargheritaPizza1.click();
    		ChoosePizza1.click();
    		MargheritaPizza2.click();
    		AddDealToBasket.click();
    		ClickApplyCoupon.click();
    		applycouponcode.sendKeys("HUT125");
    		Reedembutton.click();
    		okbutton.click();
    	
		System.out.println("m33 works");
		
		//Final validation coupon code 500


        if (voucherappliedtxt.getText().equals(actual)) {
            System.out.println("User is successfully able to apply the voucher for purchasing the pizza greater than Rs.500");
        } else {
            System.out.println("User is not able to apply the coupon");
        }
		
		
		
		
	}catch (Exception e) {
		System.out.println(e);
		System.out.println("Error in positive testcase cartvalue>500");
		
	}
	//	verificationError = e.getMessage();
    }
    
	
		public void m44()
		{
			System.out.println("Enter inside m11 coupon");
			try {
	    		String actual = "Voucher applied! Rs. 125 Off on bill value above Rs.500.";
	    		System.out.println("Inside try block");
	    		
	    		//driver.findElement(By.xpath("(//a[contains(@class,'typography-4')])[2]")).click();
	  	      
	    		pizzaTab.click();
	    		Margherita279.click();
	    		Margherita279.click();
	    		ClickApplyCoupon.click();
	    		applycouponcode.sendKeys("HUT125");
	    		Reedembutton.click();
	    		okbutton.click();
	    		System.out.println("Inside try block down");

			
			
			//Final validation coupon code 500


	        if (voucherappliedtxt.getText().equals(actual)) {
	            System.out.println("User is successfully able to apply the voucher for purchasing the pizza greater than Rs.500");
	        } else {
	            System.out.println("User is not able to apply the coupon");
	        }
			
			
			
			
		}catch (Exception e) {
			System.out.println(e);
			System.out.println("Error in positive testcase cartvalue>500");
			
		
		//	verificationError = e.getMessage();
	    }
			
		}
	
	
}

