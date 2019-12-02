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
		this.scn = s;
	}

	@After
	public void AfterMethod(Scenario s) {
		driver.quit();
		scn.write("Driver is closed");

	}

	@Given("Login in to Parabank url as {string} username as {string} passowrd as {string}")
	public void login_in_to_parabank(String url, String u, String p) 
	{

		browser_is_invoked();
		navigate_to_URL(url);
		i_enter_username_as(u);
		i_enter_password_as(p);
		i_click_on_submit_button();


	}

	@Given("Browser is  invoked")
	public void browser_is_invoked() 
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver//chromedriver_win32 (1)//chromedriver.exe");
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


	//***************************************************************
	//************************Bill Payment***************************
	//***************************************************************


	//String elemToFind ="e";


	@Given("I click on Bill Pay")
	public void i_click_on_Bill_Pay() 
	{
		driver.findElement(By.xpath("//a[@href='/parabank/billpay.htm']")).click();
		scn.write("Submit button clicked");

	}

	@Given("I fill name as {string}")
	public void i_fill_name_as(String string) 
	{
		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys(string);
		scn.write("name text field set as : " + string);

	}

	@Given("I fill address as {string}")
	public void i_fill_address_as(String string) 
	{
		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys(string);
		scn.write("address text field set as : " + string);
	}

	@Given("I fill city as {string}")
	public void i_fill_city_as(String string) 
	{
		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys(string);
		scn.write("city text field set as : " + string);


	}

	@Given("I fill state as {string}")
	public void i_fill_state_as(String string) 
	{
		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys(string);
		scn.write("state text field set as : " + string);
	}

	@Given("I fill zip code as {string}")
	public void i_fill_zip_code_as(String string) 
	{
		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys(string);
		scn.write("zipCode text field set as:"+ string);

	}

	@Given("I fill phone as {string}")
	public void i_fill_phone_as(String string) 
	{
		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys(string);
		scn.write("phone number field set as:"+string);

	}

	@When("I fill account no. {string}")
	public void i_fill_account_no(String string) 
	{
		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys(string);
		scn.write("account number field set as :"+string);

	}

	@When("I vetify account no. {string}")
	public void i_vetify_account_no(String string) 
	{
		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys(string);
		scn.write("verify account field set as :"+ string );

	}

	@When("I entere ammount {string}")
	public void i_entere_ammount(String string) 
	{
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys(string);
		scn.write("enter amount is :"+string);

	}

	@When("form account no. {string}")
	public void form_account_no(String string) 
	{
		driver.findElement(By.xpath("//select[@name='fromAccountId']")).sendKeys(string);
		scn.write("enter form account number:"+string);

	}

	@When("I click on Send Payment")
	public void i_click_on_Send_Payment() 
	{
		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		scn.write("click on send payment :");

	}

	@Then("result should come Bill payment successful")
	public void result_should_come_Bill_payment_successful()
	{
		WebElement e = driver.findElement(By.xpath("//h1[@class='title']"));
		String actual_text = e.getText();
			scn.write("Bill payed Message is coming");
		

	}





}
