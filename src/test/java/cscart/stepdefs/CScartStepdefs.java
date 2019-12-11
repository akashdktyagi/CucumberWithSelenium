package cscart.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cscart.po.PO_Search;
import cscart.po.PO_Login;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Cmn;

public class CScartStepdefs {
	WebDriver driver;
	PO_Search PO_Search;
	PO_Login PO_Login;
	Scenario scn;

	@Before
	public void BeforeMethod(Scenario scn) {
		System.setProperty("webdriver.chrome.driver","E:\\setup java\\chromedriver\\chromedriver.exe");
		this.scn = scn;
	}

	@Given("I open {string} browser")
	public void i_open_browser(String browser) {
		driver = Cmn.InvokeBrowser(browser);
		scn.write("Browser Invoked");
	}

	@Given("I navigate to url as {string}")
	public void i_navigate_to_url_as(String url) {
		Cmn.NavigateToUrl(driver, url);
		scn.write("URL Navigated to : " + url);
	}
//*********************Search feature***************************************
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
	
	//**********************Login feature*******************************************
	
	@When("I click on {string} link at top right corner of the page")
	public void i_click_on_link_at_top_right_corner_of_the_page(String arg) {
		PO_Login = PageFactory.initElements(driver, PO_Login.class); 
		PO_Login.ClickOnAccountMenuLink();
		 scn.write("Clicked on Account Menu Link");

	}
	
	@When("I click on Sign In button")
	public void i_click_on_Sign_In_button() {
		PO_Login.ClickonSignInButton();
		scn.write("Clicked on Sign In Button"); 	
	}

	@Then("Email is already displayed as {string}")
	public void email_is_already_displayed_as(String arg) {
		PO_Login.EmailIsalreadyDisplayed();
		scn.write("Email is already displayed as:"+arg);
	}



}
 