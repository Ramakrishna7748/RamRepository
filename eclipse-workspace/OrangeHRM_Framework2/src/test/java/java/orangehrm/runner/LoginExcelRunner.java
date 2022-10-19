package orangehrm.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature/LoginExcel.feature",glue= {"orangehrm.runner"})
public class LoginExcelRunner {

}