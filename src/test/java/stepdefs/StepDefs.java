package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


	//Hooks
	@Before
	public void BeforeMethod(Scenario s) {
		this.scn = s;
	}
	
	@After
	public void AfterMethod(Scenario s) {
		driver.quit();
		scn.write("Driver is closed");

	}
	
	@Given("Login in to Parabank url as {string} username as {string} passowrd as {string}")
	public void login_in_to_parabank(String url, String u, String p) {
		browser_is_invoked();
		navigate_to_URL(url);
		i_enter_username_as(u);
		i_enter_password_as(p);
		i_click_on_submit_button();
		
		
	}

	@Given("Browser is  invoked")
	public void browser_is_invoked() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
	
	@When("I click on {string}")
	public void i_click_on(String arg) {

		driver.findElement(By.linkText(arg)).click();;
		scn.write("Clicked on Menu Link: " + arg);
	}


	@Then("Page title should come {string}")
	public void i_page_title_should_come(String string) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleIs(string));
		
		
		String actual = driver.getTitle();
		String expected  = string;
		Assert.assertEquals(expected, actual);
		scn.write("User successfully logged in. Page Title coming as: " + string);
	}



	
}
