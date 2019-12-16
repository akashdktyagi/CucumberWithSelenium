package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="classpath:features/Misc",
		glue="misc",
		plugin = {"pretty",
				"html:target/CucumberReport",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@wip",
		dryRun = false
		
		)
public class RunnerMisc {

}
