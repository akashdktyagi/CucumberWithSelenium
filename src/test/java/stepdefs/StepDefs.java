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
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import junit.framework.*;

public class StepDefs {
	
	WebDriver driver;
	Scenario scn;
	//Open New Account Number variable
		String NEW_ACCOUNT_NUMBER;
		String ORIGINAL_ACC_AMMOUNT;

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
	//*******Feature: Parabank Login feature********//
	
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

	    //*********************************************
		//*******************Feature: Applying for loan************
		//*********************************************
	@Then("I click on {string} button")
	public void i_click_on_button(String string) {
		driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[7]/a")).click();
		scn.write("Request for Loan");
	    
	}

	@Then("I enter Loan Amount as {string}")
	public void i_enter_Loan_Amount_as(String string) {
		driver.findElement(By.id("amount")).sendKeys(string);
		scn.write("I enter Loan amount ");
	    
	    
	}

	@Then("I enter Downpayment as {string}")
	public void i_enter_Downpayment_as(String string) {
		driver.findElement(By.id("downPayment")).sendKeys(string);
		scn.write("I enter Downpayment");
	    
	}

	@Then("I enter From account  as {string}")
	public void i_enter_From_account_as(String string) {
		driver.findElement(By.id("fromAccountId")).sendKeys(string);
		scn.write("I enter From account  as {string}");
	    
	}

	@Then("I click on Apply Now Button")
	public void i_click_on_Apply_Now_Button() {
		driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[7]/a")).click();
		scn.write("I click on Apply Now Button");
	    
	    
	}
	
	@Then("Loan Request Processed page should Display")
	public void loan_Request_Processed_page_should_Display() {
		driver.findElement(By.name("Loan Request Processed"));
		scn.write("Loan Request Processed page should Display");
	    
	}

	@Then("Loan Status is denied {string}")
	public void loan_Status_is_denied(String string) {
		driver.findElement(By.id("loanStatus")).sendKeys(string);
		scn.write("Loan Status is denied {string}");
	}
	
///*****checking useranme credintials*******//
	
//**************OPENNEWACCOUNTFEATURE*******************//

	@Given("Fetch Balance of Account {string}")
	public void fetch_balance_of_account(String acc_number) {
		
		WebElement e = driver.findElement(By.xpath("//a[text()='"+acc_number+"']/parent::td/following-sibling::td[1]"));
		ORIGINAL_ACC_AMMOUNT= e.getText();
		scn.write("Original Account number is : " + acc_number + " and ammount before transaction is : " + ORIGINAL_ACC_AMMOUNT );
	}
	
	@When("I select account type as {string}")
	public void i_select_account_type_as(String string) {
		WebElement e = driver.findElement(By.id("type"));
		Select list = new Select(e);
		list.selectByVisibleText(string);
		scn.write("Type selected as : " + string);
	}

	@When("I select the account number as {string}")
	public void i_select_the_account_number_as(String string) {
		WebElement e = driver.findElement(By.id("fromAccountId"));
		Select list = new Select(e);
		list.selectByVisibleText(string);
		scn.write("Account Number selected as : " + string);
	}

	@When("I click on Open New Account Button")
	public void i_click_on_Open_New_Account_Button() {
		driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
		scn.write("Open New Account Button is Clicked");
	}
	
	@Then("Account Opened  message should come")
	public void account_Opened_message_should_come() {

		WebElement e = driver.findElement(By.xpath("//div[@ng-if='showResult' and @class='ng-scope']"));
		String actual_text = e.getText();
		if (actual_text.contains("Account Opened!")) {
			scn.write("AccountOpened Message is coming");
			Assert.assertTrue(true);
		}else {
			scn.write("AccountOpened Message is not coming");
			Assert.assertTrue(false);
		}
		
		if (actual_text.contains("Congratulations, your account is now open.")) {
			scn.write("Congratulations, your account is now open. Message is coming");
			Assert.assertTrue(true);
		}else {
			scn.write("Congratulations, your account is now open. Message is not coming");
			Assert.assertTrue(false);
		}
		
	}

	@Then("New Account Number is created")
	public void new_Account_Number_is_created() {
		WebElement e = driver.findElement(By.id("newAccountId"));
		NEW_ACCOUNT_NUMBER = e.getText();
		scn.write("New Account number created. Account no.: " + NEW_ACCOUNT_NUMBER);
	}

	@Then("New Account is displayed under account Overview table")
	public void new_Account_is_displayed_under_account_Overview_table() {
		//Click on Account Overview Link
		i_click_on("Accounts Overview");
		WebElement e = driver.findElement(By.xpath("//table[@id='accountTable']//a[text()='"+NEW_ACCOUNT_NUMBER+"']"));
		Assert.assertEquals(true, e.isDisplayed());
		scn.write("New Account Number link is displayed");

	}

	@Then("New Account should have ammount as {string}")
	public void new_Account_should_have_ammount_as(String string) {
		String xpath = "//table[@id='accountTable']//a[text()='"+NEW_ACCOUNT_NUMBER+"']/parent::td/following-sibling::td[1]";
		WebElement e = driver.findElement(By.xpath(xpath));
		String actual = e.getText();
		String expected = string;
		Assert.assertEquals(expected, actual);
		scn.write("New Account displays amount as : " + string);
	}

	

	@Then("Original Account ammount should get deducted by {string} from account {string}")
	public void original_Account_ammount_should_get_deducted_by(String exp_amount, String acc) {
		WebElement e = driver.findElement(By.xpath("//a[text()='"+acc+"']/parent::td/following-sibling::td[1]"));
		String deducted_ammount = e.getText().replace("$", "");
		ORIGINAL_ACC_AMMOUNT = ORIGINAL_ACC_AMMOUNT.replace("$", "");
		Float temp = Float.parseFloat(ORIGINAL_ACC_AMMOUNT);
		Float temp1 = Float.parseFloat(deducted_ammount);
		Float result = temp-temp1;
		Assert.assertEquals("",Float.parseFloat(exp_amount), result);
		scn.write("Original balance: " + ORIGINAL_ACC_AMMOUNT + " after transaction amount: " + deducted_ammount + " amount deducted appearing coorectly as: " + exp_amount);
	
	}
	
	//**********************************Bill Payment***************************************************//
	
	@Given("I click on Bill Pay")
	public void i_click_on_Bill_Pay() {
	driver.findElement(By.xpath("//a[@href='/parabank/billpay.htm']")).click();
	scn.write("I click on Bill Pay");
	}

	@Given("I Fill Payee Name as {string}")
	public void i_Fill_Payee_Name_as(String string) {
		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys(string);
		scn.write("I Fill Payee Name");
	}

	@Given("I fill Address as {string}")
	public void i_fill_Address_as(String string) {
		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys(string);
		scn.write("I fill Address as");
	}

	@Given("I fill City as {string}")
	public void i_fill_City_as(String string) {
		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys(string);
		scn.write("I fill City as");
	}

	@Given("I fill State as {string}")
	public void i_fill_State_as(String string) {
		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys(string);
		scn.write("I fill State as");
	}

	@Given("I fill Zip Code as {string}")
	public void i_fill_Zip_Code_as(String string) {
		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys(string);
		scn.write("I fill Zip Code as");
	}

	@Given("I fill Phone as {string}")
	public void i_fill_Phone_as(String string) {
		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys(string);
		scn.write("I fill Phone as");
	}

	@When("I fill Account as {string}")
	public void i_fill_Account_as(String string) {
		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys(string);
		scn.write("I fill Account as");
	}

	@When("I fill Verify Account as {string}")
	public void i_fill_Verify_Account_as(String string) {
		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys(string); 
		scn.write("I fill Verify Account as");
	}

	@When("I fill Amount as {string}")
	public void i_fill_Amount_as(String string) {
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys(string);
	}

	@When("I fill From account as {string}")
	public void i_fill_From_account_as(String string) {
		driver.findElement(By.xpath("//select[@name='fromAccountId']")).sendKeys(string);
		scn.write("I fill From account as ");
	}

	@When("I click On Send Payment button")
	public void i_click_On_Send_Payment_button() {
	   driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
	   scn.write("I click On Send Payment button");
	}

	@Then("successful bill payment message should come")
	public void successful_bill_payment_message_should_come() {
	 WebElement e = driver.findElement(By.xpath("//h1[@class='title']"));
	 String expected ="Bill Payment Complete";  
	 String actual= e.getText();
	 if(actual.equals(expected))
	 {
		 scn.write("successful bill payment message should come");
	 }
	 else
	 {
		 scn.write("successful bill payment message should come");
	 }
		
		
	}

}


	