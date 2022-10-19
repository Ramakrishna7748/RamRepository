package orangehrm.runner;

	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;

	//@RunWith(Cucumber.class)

	@CucumberOptions(features="src/test/resources/Feature/LoginScenerioOutline.feature",glue={"orangehrm.runner"},
	plugin= {"pretty","html:target/htmlreports.html",
	        "json:target/JSON_Reports/json_report.json", 
	        "junit:target/JUNIT_Reports/junit_report.xml"},
	         monochrome= true)

	public class LoginOutlineRunner extends AbstractTestNGCucumberTests {
	}
	
	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	import org.junit.runner.RunWith;
	@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/resources/Feature/.feature",glue= {"orangehrm.runner"})
	public class HomePageRunner {

	}
