package stepdefs;

import java.util.Map;
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
		System.setProperty("webdriver.chrome.driver","E:\\setup java\\chromedriver\\chromedriver.exe");
		this.scn=s;
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

		driver.findElement(By.linkText(arg)).click();
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
	
	@When("I enter amount as {string} in amount field")
	public void i_enter_amount_as_in_amount_field(String string) {
		driver.findElement(By.id("amount")).sendKeys(string);
		scn.write("Entered amount as :" + string);

	}
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

	@When("I click on transfer funds button")
	public void i_click_on_transfer_funds_button() {
		driver.findElement(By.xpath("//input[@value='Transfer']")).click();
		scn.write("Tranfer funds button clicked");
	}

	
/*@Then("Transfer is sucessfull message should come {string}")
public void transfer_is_sucessfull_message_should_come(String string) {
	String expected =string;
	String actual = driver.findElement(By.xpath("//h1[@class='title']")).getText();
	Assert.assertEquals(expected, actual);
	scn.write("Transfer is sucessfull message coming as" + string);

   }*/

	@Then("Verify  Amount {string} is transfered from account {string} to account {string}")
	public void verify_Amount_is_transfered_from_account_to_account(String string, String string2, String string3) {
	String expected =string;
	String actual = driver.findElement(By.xpath("//span[@class='ng-binding']")).getText();
	Assert.assertEquals(expected, actual);
	scn.write("Transfer is sucessfull message coming as" + string);

			
}

//***************************************************************************
//***********************Apply for loan***************************************
	//************************************************************************
	@When("I enter Loan Amount as {string}")
	public void i_enter_Loan_Amount_as(String string) {
		driver.findElement(By.id("amount")).sendKeys(string);
		scn.write("Entered Loan amount as :" + string);

  
	}

	@When("I enter DownPayment Amount as {string}")
	public void i_enter_DownPayment_Amount_as(String string) {
		driver.findElement(By.id("downPayment")).sendKeys(string);
		scn.write("Entered DownPayment amount as :" + string);

	}

	@When("I select Account as {string}")
	public void i_select_Account_as(String arg) {
		WebElement element = driver.findElement(By.id("fromAccountId"));
		Select select  = new Select(element);
		select.selectByVisibleText(arg);
		scn.write("I selected account as : " + arg);

	}

@When("I click on Apply Now button")
public void i_click_on_Apply_Now_button() {
	driver.findElement(By.xpath("//input[@value='Apply Now']")).click();
	scn.write(" Apply Now button clicked");
    }

@Then("Loan status is {string}")
public void loan_status_is(String arg) {
	String expected =arg;
	String actual = driver.findElement(By.xpath("//td[@id='loanStatus']")).getText();
	Assert.assertEquals(expected, actual);
	scn.write("Loan status message coming as: " + arg);
}

@Then("message should come as {string}")
public void message_should_come_as(String String) {
	String expected =String;
	String actual = driver.findElement(By.xpath("//p[@class='error ng-scope']")).getText();
	Assert.assertEquals(actual, expected);
	scn.write("And message coming as: " + String); 
}
//*************************************************************************************************
//******************************************Bill Pay****************************************************

@When("I fill Bill payment form with data as")
public void i_fill_Bill_payment_form_with_data_as( Map<String,String> data) {
    
	driver.findElement(By.name("payee.name")).sendKeys(data.get("name"));
	driver.findElement(By.name("payee.address.street")).sendKeys(data.get("Address"));
	driver.findElement(By.name("payee.address.city")).sendKeys(data.get("city"));
	driver.findElement(By.name("payee.address.state")).sendKeys(data.get("state"));
	driver.findElement(By.name("payee.address.zipCode")).sendKeys(data.get("zipCode"));
	driver.findElement(By.name("payee.phoneNumber")).sendKeys(data.get("phone"));
	driver.findElement(By.name("payee.accountNumber")).sendKeys(data.get("Account"));
	driver.findElement(By.name("verifyAccount")).sendKeys(data.get("verifyAccount"));
	driver.findElement(By.name("amount")).sendKeys(data.get("Ammount"));
	WebElement element = driver.findElement(By.name("fromAccountId"));
	Select select  = new Select(element);
	select.selectByVisibleText("12900");
	scn.write("Data sent from Feature file: " + data.toString());
}

@When("I click on SEND PAYMENT button")
public void i_click_on_SEND_PAYMENT_button() {
	driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
	scn.write(" Send Payment button clicked");
    }
@Then("Message should come as {string}")
public void message_should_comeas(String arg) {
	String expected =arg;
	String actual = driver.findElement(By.xpath("//*[@id='rightPanel']/div/div[2]/p[1]")).getText();
	Assert.assertEquals(actual, expected);
	scn.write("And message coming as: " + arg);  
}



}

 
	

