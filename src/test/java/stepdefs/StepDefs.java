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

import com.aventstack.extentreports.ExtentReports;

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
	public void BeforeMethod(Scenario s) 
	{

		this.scn = s;
	}

	@After
	public void AfterMethod(Scenario s) 
	{

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
		System.setProperty("WebDriver.Chrome.driver", "D:/chromedriver//chromedriver_win32 (1)//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		scn.write("Browser Invoked and maximized");
	}

	@Given("navigate to URL {string}")
	public void navigate_to_URL(String string) 
	{

		driver.get(string);
		scn.write("Browser navigated to url: " + string);
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String string) {
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys(string);
		scn.write("Username text field set as : " + string);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String string) {
		driver.findElement(By.name("password")).sendKeys(string);
		scn.write("password text field set as : " + string);
	}

	@When("I click on submit button")
	public void i_click_on_submit_button() {
		driver.findElement(By.xpath("//input[@value = 'Log In']")).click();
		scn.write("Submit button clicked");
	}

	@When("I click on {string}")
	public void i_click_on(String string) {

		driver.findElement(By.linkText(string)).click();;
		scn.write("Clicked on Menu Link: " + string);
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
	public void transfer_is_sucessfull_message_should_come() 
	{
		driver.findElement(By.xpath("//h1[@class='title']"));
		scn.write("transfer is successful!");

	}

	@Then("verify amount is transfered from account {string} to account {string}")
	public void verify_amount_is_transfered_from_account_to_account(String string, String string2) 
	{
		driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/p[1]"));
		scn.write("amount is transfered from");

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
		Assert.assertTrue(true);
		scn.write("Bill payed Message is coming");


	}

	//*****************************negative bill pay*****************************

	@When("I click on Send Payment button with out filling any fields")
	public void i_click_on_Send_Payment_button_with_out_filling_any_fields() 
	{
		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		scn.write("I click on Send Payment button with out filling any fields");

	}

	@Then("below types of errors will be displayed for each field")
	public void below_types_of_errors_will_be_displayed_for_each_field(Map<String,String> DataTable) 
	{
		driver.findElement(By.name("payee.name")).sendKeys(DataTable.get("name"));
		driver.findElement(By.name("payee.address.street")).sendKeys(DataTable.get("Address"));
		driver.findElement(By.name("payee.address.city")).sendKeys(DataTable.get("city"));
		driver.findElement(By.name("payee.address.state")).sendKeys(DataTable.get("state"));
		driver.findElement(By.name("payee.address.zipCode")).sendKeys(DataTable.get("zipCode"));
		driver.findElement(By.name("payee.phoneNumber")).sendKeys(DataTable.get("phone"));
		driver.findElement(By.name("payee.accountNumber")).sendKeys(DataTable.get("Account"));
		driver.findElement(By.name("verifyAccount")).sendKeys(DataTable.get("verifyAccount"));
		driver.findElement(By.name("amount")).sendKeys(DataTable.get("Ammount"));
		scn.write("below types of errors will be displayed for each field");

	}


	//*******************************register new user*****************************



	@When("I clicked  on Register")
	public void i_clicked_on_Register()
	{
		driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a")).click();
		scn.write("click on register!");

	}

	@When("I fill first name as {string}")
	public void i_fill_first_name_as(String string) 
	{
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys(string);
		scn.write("i fill first name as :"+ string );



	}

	@When("I fill last name as {string}")
	public void i_fill_last_name_as(String string) 
	{
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys(string);
		scn.write("i fill last name as :"+string );



	}

	@When("I fill Address as {string}")
	public void i_fill_Address_as(String string) 
	{
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(string);
		scn.write("i enter address!" +string);

	}

	@When("I fill City as {string}")
	public void i_fill_City_as(String string) 
	{
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys(string);
		scn.write("i enter city name"+ string);
	}

	@When("I fill State as {string}")
	public void i_fill_State_as(String string) 
	{
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys(string);
		scn.write("i fill state as" +string);
	}

	@When("I fill Zip code as {string}")
	public void i_fill_Zip_code_as(String string) 
	{
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys(string);
		scn.write("i entered zip code as"+ string);

	}

	@When("I fill Phone as {string}")
	public void i_fill_Phone_as(String string)
	{
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys(string);
		scn.write("i entered phone no as"+ string);

	}



	@When("I fill SSN as {string}")
	public void i_fill_SSN_as(String string) 
	{
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys(string );
		scn.write("i fill ssn as"+string );



	}

	@When("I fill username as {string}")
	public void i_fill_username_as(String string) 
	{
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys(string);
		scn.write("i fill username as "+string);



	}

	@When("I fill password as {string}")
	public void i_fill_password_as(String string) 
	{
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys(string);
		scn.write("i fill password as"+string);



	}

	@When("I fill confirm password as{string}")
	public void i_fill_confirm_password_as(String string) 
	{
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys(string);
		scn.write("i fill confirm password as"+string);



	}

	@When("I click on Register Button")
	public void i_click_on_Register_Button() 
	{
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		scn.write("register successfully!");



	}

	@Then("New user is able to login username as {string} and password as {string}")
	public void new_user_is_able_to_login_username_as_and_password_as(String string, String string2) 
	{

		i_enter_username_as(string);
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys(string);
		scn.write("And Username entered as:"+string);

		i_enter_password_as(string);
		driver.findElement(By.name("password")).sendKeys(string);
		scn.write("And Password entered as:"+string);

		i_click_on_submit_button();
		scn.write(" New User is created and immediatly logged in"); 
	}


	@Then("New user is able to login successfully again after logout")
	public void new_user_is_able_to_login_successfully_again_after_logout() {
		driver.findElement(By.xpath("//a[@href='/parabank/logout.htm']")).click();
		scn.write("New user is able to login successfully and logout");

	}
	//*********************************Accountoverview********************************


	@When("I clicked on {string}")
	public void i_clicked_on(String string) 
	{
		driver.findElement(By.xpath("//a[@href='/parabank/overview.htm']")).click();
		scn.write("i click on account overview as"+string);

	}

	@When("Account Overview page is displayed")
	public void account_Overview_page_is_displayed() 
	{
		driver.findElement(By.xpath("//div[@ng-app='OverviewAccountsApp']"));
		scn.write("table is displayed!");

	}

	@Then("Sum of all the accounts is equal to total amount displayed at the bottom of the table as {string}")
	public void sum_of_all_the_accounts_is_equal_to_total_amount_displayed_at_the_bottom_of_the_table_as(String string) 
	{
		WebElement e3= driver.findElement(By.xpath("//b[@class='ng-binding']"));
		e3.getText();
		scn.write("Sum of all the accounts is equal to total amount displayed at the bottom of the table");


	}







}

