import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//features="classpath:",
		//glue="stepdefs",
		plugin = {"pretty",
				"html:target/CucumberReport",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "",
		dryRun = false
		
		)
public class RunTest {

}
