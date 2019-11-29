

package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		//driver = new ChromeDriver();
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

	//*********************************************
	//*******************Transfer Funds************
	//*********************************************
	@When("I select account {string} in from account field")
	public void i_select_account_in_from_account_field(String arg) {

		WebElement element = driver.findElement(By.id("fromAccountId"));
		Select select  = new Select(element);
		select.selectByVisibleText(arg);
		scn.write("From account field selected with value as : " + arg);
	}

	@When("I select account {string} in to account field")
	public void i_select_account_in_to_account_field(String arg) {
		WebElement element = driver.findElement(By.id("toAccountId"));
		Select select  = new Select(element);
		select.selectByVisibleText(arg);
		scn.write("To account field selected with value as : " + arg);

	}

	@When("I enter amount as {string} in amount field")
	public void i_enter_amount_as_in_amount_field(String string) {
		driver.findElement(By.id("amount")).sendKeys(string);;
		scn.write("Entered amount as :" + string);

	}

	@When("I click on transfer funds button")
	public void i_click_on_transfer_funds_button() {
		driver.findElement(By.xpath("//input[@value='Transfer']")).click();
		scn.write("Tranfer funds button clicked");
	}

	@Then("Transfer is sucessfull message should come")
	public void transfer_is_sucessfull_message_should_come() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("verify amount is transfered from account {string} to account {string}")
	public void verify_amount_is_transfered_from_account_to_account(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I entered loan amount as {string}")
	public void i_entered_loan_amount_as(String string) {
	    driver.findElement(By.id("amount")).sendKeys(string);
	    scn.write("entered amount as" +string);
	}

	@When("I entered down Payment as {string}")
	public void i_entered_down_Payment_as(String string) {
	driver.findElement(By.id("downPayment")).sendKeys(string);
	scn.write("entered downpayment as" +string);
	
	
	}
	
	
	

	@When("I click on {string} button")
	public void i_click_on_button(String string) {
	   driver.findElement(By.xpath("//input[@value=\"Apply Now\"]")).click();
	   scn.write("Apply now button is clicked");
	}


@When("I entered first name as {string}")
public void i_entered_first_name_as(String string) {
    driver.findElement(By.name("firstName")).sendKeys(string);
    scn.write("entered first name" + string);
}

@When("I entered Last Name  {string}")
public void i_entered_Last_Name(String string) {
	driver.findElement(By.name("lastName")).sendKeys(string);
    scn.write("entered last name" + string);
  
}

@When("I entered Address	{string}")
public void i_entered_Address(String string) {
	driver.findElement(By.name("address.street")).sendKeys(string);
    scn.write("entered Address" + string);
}

@When("I entered City {string}")
public void i_entered_City(String string) {
	driver.findElement(By.name("address.city")).sendKeys(string);
    scn.write("entered city" + string);   
}

@When("I entered State	{string}")
public void i_entered_State(String string) {
	driver.findElement(By.name("address.state")).sendKeys(string);
    scn.write("entered State" + string);
}

@When("I entered Zip Code	{string}")
public void i_entered_Zip_Code(String string) {
	driver.findElement(By.name("address.zipCode")).sendKeys(string);
    scn.write("entered zipcode" + string);
}

@When("I entered SSN  {string}")
public void i_entered_SSN(String string) {
	driver.findElement(By.name("ssn")).sendKeys(string);
    scn.write("entered ssn" + string);
}

@When("I click {string}")
public void i_click(String string) {
	driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
    scn.write("forgetLoginInfo button clicked");
}

@Then("error msg should be appeared as {string}")
public void error_msg_should_be_appeared_as(String string) {
	String actualtext = driver.findElement(By.className("error")).getText();
	String expectedtext = "The customer informationssss provided could not be found.";
	if(actualtext.equals(expectedtext))
	{
		scn.write("pass:The customer information provided could not be found.");
	}
	else
	{
		scn.write("fail");
	}
}
@When("I entered First name as {string}")
public void i_entered_First_name_as(String string) {
    driver.findElement(By.name("customer.firstName")).sendKeys(string);
    scn.write("entered first name" +string);
}


@When("I entered Last Name as {string}")
public void i_entered_Last_Name_as(String string) {
	driver.findElement(By.name("customer.lastName")).sendKeys(string);
    scn.write("entered last name"+string);
}

@When("I entered Address as {string}")
public void i_entered_Address_as(String string) {
	driver.findElement(By.name("customer.address.street")).sendKeys(string);
    scn.write("entered address"+string);
}

@When("I entered City as {string}")
public void i_entered_City_as(String string) {
	driver.findElement(By.name("customer.address.city")).sendKeys(string);
    scn.write("entered city "+string);
}

@When("I entered State as	{string}")
public void i_entered_State_as(String string) {
	driver.findElement(By.name("customer.address.state")).sendKeys(string);
    scn.write("entered state " +string);
}

@When("I entered Zip Code as {string}")
public void i_entered_Zip_Code_as(String string) {
	driver.findElement(By.name("customer.address.zipCode")).sendKeys(string);
    scn.write("entered zip code"+string);
}

@When("I entered Phone# as {string}")
public void i_entered_Phone_as(String string) {
	driver.findElement(By.name("customer.phoneNumber")).sendKeys(string);
    scn.write("entered phone" +string);
}

@When("I entered SSN as {string}")
public void i_entered_SSN_as(String string) {
	driver.findElement(By.name("customer.ssn")).sendKeys(string);
    scn.write("entered ssn " +string);
}

@When("I entered Username as {string}")
public void i_entered_Username_as(String string) {
	driver.findElement(By.name("customer.username")).sendKeys(string);
    scn.write("entered username" + string);
}

@When("I entered Password as {string}")
public void i_entered_Password_as(String string) {
	driver.findElement(By.name("customer.password")).sendKeys(string);
    scn.write("entered password " + string);
}

@When("I entered Confirm as {string}")
public void i_entered_Confirm_as(String string) {
	driver.findElement(By.name("repeatedPassword")).sendKeys(string);
    scn.write("entered confirm password"+ string);
}
@When("I click  button {string}")
public void i_click_button(String string) {
    driver.findElement(By.xpath("//input[@value='Register']")).click();
    scn.write("Register button clicked");
}
@Then("confirmation msg appeared as {string}")
public void confirmation_msg_appeared_as(String string) {
	String actualtext = driver.findElement(By.xpath("//div[@id=\"rightPanel\"]")).getText();
	scn.write(actualtext);
	String expectedtext = string;
	if(actualtext.contains(expectedtext))
	{
		scn.write("pass:Your account was created successfully. You are now logged in.");
	}
	else
	{
		scn.write("fail");
	}
    
}

}
	


	
