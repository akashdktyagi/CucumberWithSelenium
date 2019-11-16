package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.PO_Login;


public class StepDefs {
	
	private WebDriver driver;
	private Scenario scn;
	private TestContext oTestContext;

	public StepDefs(TestContext cntxt) {
		oTestContext = cntxt;
	}

	//Hooks
	@Before
	public void BeforeMethod(Scenario s) {
		oTestContext.setoScn(s);
		this.scn = s;
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
		driver = oTestContext.GetBrowser("chrome");
	}

	@Given("navigate to URL {string}")
	public void navigate_to_URL(String arg) {
		oTestContext.NavigateToBrowser(arg);
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String arg) {
		oTestContext.getoPO_Login().EnterUserName(arg);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String arg) {
		oTestContext.getoPO_Login().EnterPassword(arg);
	}

	@When("I click on submit button")
	public void i_click_on_submit_button() {
		oTestContext.getoPO_Login().ClickSubmitButton();
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
