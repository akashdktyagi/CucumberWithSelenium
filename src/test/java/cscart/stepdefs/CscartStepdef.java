package cscart.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cscart.po.PO_Login;
import cscart.po.PO_Search;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cscart.utils.Common;

public class CscartStepdef {
	WebDriver driver;
	PO_Search PO_Search;
	PO_Login PO_Login ;
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
		driver.close();
		scn.write("Driver is closed");
	}

	@Given("I open {string} browser")
	public void i_open_browser(String browser) {
		driver = Common.InvokeBrowser(browser);
		scn.write("Browser Invoked");
	}

	@Given("I navigate to url as {string}")
	public void i_navigate_to_url_as(String url) {
		Common.NavigateToUrl(driver, url);
		scn.write("URL Navigated to : " + url);
	}

	@When("I enter text in search text box as {string}")
	public void i_enter_text_in_search_text_box_as(String text) {
		PO_Search = PageFactory.initElements(driver, PO_Search.class);
		PO_Search.EnterTextInSearchBox(text);
		scn.write("Search box text entered as :" + text);
	}

	@When("I click on Search button")
	public void i_click_on_Search_button() {
		PO_Search.ClickonSearchButton();
		scn.write("Clicked on Search Button");
	}

	@Then("Search results are displayed")
	public void search_results_are_displayed() {
		PO_Search.ValidateSearchResultIsDisplayed();
		scn.write("Search Results are displayed successfully");
	}

	//******************************************cs cart login********************************************************

	@When("I click on {string} Menu link at top right corner of the page")
	public void i_click_on_Menu_link_at_top_right_corner_of_the_page(String arg) 
	{
		PO_Login  = PageFactory.initElements(driver, PO_Login.class);
		PO_Login.IClickOnAccountMenuLinkAtTopRightCornerOfThePage(arg );
        scn.write("i click on account menu link at top right corner of the page"+ arg);
	}


	@When("I click on {string} button")
	public void i_click_on_button(String string) 
	{
		PO_Login.ClickonSignInButton();
		scn.write("i click on sign in button!" + string);
	}

	@Then("Email is already displayed as {string}")
	public void email_is_already_displayed_as(String string) 
	{
		PO_Login.Emailisalreadydisplayedas();
		scn.write("Email is already displayed as"+ string );

	}


	//*************************************************Login into the application***********************************




	@When("I click on Sign In button on the pop up")
	public void i_click_on_Sign_In_button_on_the_pop_up() 
	{
		PO_Login  = PageFactory.initElements(driver, PO_Login.class);
		PO_Login.IClickOnSignInButtonOnThePopUp();
        
		
		scn.write("I click on sign in button");
	}
	
	
	
	
	
	
	@Then("User is signed in and {string} button is displayed after clicking on {string} button")
	public void user_is_signed_in_and_button_is_displayed_after_clicking_on_button(String string, String string2) 
	{
        
        PO_Login.UserIsSignedInAndButtonIsDisplayedAfterClickingOnButton();
		scn.write("User is signed in and sign out buton is displayed after clicking on my account button");
    }


	
	//******************************Check error message**********************************



	@When("I remove previous email")
	public void i_remove_previous_email() 
	{
		PO_Login.IRemovePreviousEmail();
		scn.write("i remove privious email");
	}

	@When("I enter email address as {string}")
	public void i_enter_email_address_as(String text) 
	{
		PO_Login = PageFactory.initElements(driver, PO_Login.class);
		PO_Login.IenterEmailAddressAs(text);
		scn.write("Search box text entered as :" + text);
	}

	@Then("Application should throw error as {string}")
	public void application_should_throw_error_as(String string) 
	{
		PO_Login.ApplicationShouldThrowErrorAs(string);
		scn.write("Application throw error");
	}
} 
