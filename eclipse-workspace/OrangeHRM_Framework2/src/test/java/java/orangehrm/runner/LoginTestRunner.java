package orangehrm.runner;

//import org.junit.runner.RunWith;
//
////import org.junit.runner.RunWith;
////import io.cucumber.testng.AbstractTestNGCucumberTests;
////import io.cucumber.testng.CucumberOptions;
////
////@CucumberOptions(tags = "", features = "src/test/resources/Feature/Login.feature", glue = "com.qa.orangehrm.testcases",plugin = { "pretty", "html:target/cucumber-reportss" },
////monochrome = true)
//// 
//// 
////public class LoginTestRunner extends AbstractTestNGCucumberTests{
//// 
////}
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
////import org.junit.runner.RunWith;
////import io.cucumber.junit.Cucumber;
////import io.cucumber.junit.CucumberOptions;
//@RunWith(Cucumber.class)
//@CucumberOptions(features="src/test/resources/Feature/Login.feature",glue= {"com.qa.orangehrm.testcases"})
//public class LoginTestRunner {
//
//}
//
//
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/resources/Feature/LoginSteps.feature",glue={"orangehrm.runner"},
plugin= {"pretty","html:target/htmlreports.html",
        "json:target/JSON_Reports/json_report.json", 
        "junit:target/JUNIT_Reports/junit_report.xml"},
         monochrome= true)

public class LoginTestRunner extends AbstractTestNGCucumberTests {
}


