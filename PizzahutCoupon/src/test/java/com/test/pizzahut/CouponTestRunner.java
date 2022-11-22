package com.test.pizzahut;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src\\test\\resources\\Features\\Coupon.feature", glue = "com.test.pizzahut",plugin = { "pretty", "html:target/cucumber-reportss" },
monochrome = true)
 
 
public class CouponTestRunner extends AbstractTestNGCucumberTests{
 
}

//
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//
//@RunWith(Cucumber.class)
//@CucumberOptions(features="src\\test\\resources\\Features\\Coupon.feature",glue= {"com.test.pizzahut"})
//public class CouponTestRunner {
//
//}

