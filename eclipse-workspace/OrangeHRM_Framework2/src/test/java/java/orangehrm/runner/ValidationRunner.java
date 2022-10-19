package orangehrm.runner;



	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;

	//@RunWith(Cucumber.class)

	@CucumberOptions(features={"src/test/resources/Feature/Login.feature","src/test/resources/Feature/Validation.feature"}, glue={"orangehrm.runner"},
	plugin= {"pretty","html:target/htmlreports.html",
	        "json:target/JSON_Reports/json_report.json", 
	        "junit:target/JUNIT_Reports/junit_report.xml"},
	         monochrome= true)

	public class ValidationRunner extends AbstractTestNGCucumberTests {
	}

