package runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="classpath:features",
		glue="stepdefs",
		plugin = {
				"pretty",
				"html:target/CucumberReport",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@wip",
		monochrome =true,
		strict=true,
		dryRun = false
		
		)
public class RunTest
{

}
