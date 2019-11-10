package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefs {
	
	WebDriver driver;
	Scenario scn;
	
	@Before
	public void BeforeMethod(Scenario s) {
		this.scn = s;
	}
	
	@After
	public void AfterMethod(Scenario s) {
		driver.quit();
		scn.write("Driver is closed");

	}
	

	@Given("Browser is  invoked")
	public void browser_is_invoked() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		scn.write("Browser Invoked and maximized");
	}

	@Given("navigate to URL {string}")
	public void navigate_to_URL(String arg) {
		driver.get(arg);
		scn.write("Browser navigated to url: " + arg);
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String arg) {
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys(arg);
		scn.write("Username text field set as : " + arg);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String arg) {
		driver.findElement(By.name("password")).sendKeys(arg);
		scn.write("password text field set as : " + arg);
	}

	@When("I click on submit button")
	public void i_click_on_submit_button() {
		driver.findElement(By.xpath("//input[@value = 'Log In']")).click();
		scn.write("Submit button clicked");
	}

	@Then("I page title should come {string}")
	public void i_page_title_should_come(String string) {
		String actual = driver.getTitle();
		String expected  = string;
		Assert.assertEquals(expected, actual);
		scn.write("User successfully logged in");
	}



	
}
