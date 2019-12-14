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

public class CsCartStepDefs {
	WebDriver driver;
	PO_Search PO_Search;
	PO_Login PO_Login;
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
	
	
	@When("I click on {string} Menu link at top right corner of the page")
	public void i_click_on_Menu_link_at_top_right_corner_of_the_page(String arg) {
		PO_Login = PageFactory.initElements(driver, PO_Login.class);
		   PO_Login.ClickAccountMenu();
		   scn.write("I click on Account Menu link at top right corner of the page"+arg);

	}

	@When("I click on {string} button")
	public void i_click_on_button(String string) {
		PO_Login.ClickSignIn();
	    scn.write("I click on Sign In button"+string);
	}

	@Then("Email is already displayed as {string}")
	public void email_is_already_displayed_as(String string) {
		PO_Login.ValidateSearchResultDisplayed();
		  scn.write("Email is already displayed " + string);
	}
}
