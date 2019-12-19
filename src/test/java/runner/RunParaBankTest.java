package runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="classpath:features/parabank",
		glue="parabank.stepdefs",
		plugin = {"pretty",
				"html:target/cucumber",
				"json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "",
		dryRun = false
		
		)
public class RunParaBankTest {

}
