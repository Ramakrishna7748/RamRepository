package orangehrm.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature/HomePage.feature",glue= {"orangehrm.runner"})
public class HomePageRunner {

}

//
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(tags = "", features = "src/test/resources/Feature/HomePage.feature", glue = "com.qa.orangehrm.testcases",plugin = { "pretty", "html:target/cucumber-reportss" },
//monochrome = true)
//
//
//public class HomePageRunner extends AbstractTestNGCucumberTests{
//
//}