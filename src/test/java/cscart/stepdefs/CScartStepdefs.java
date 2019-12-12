package cscart.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cscart.po.PO_Login;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Cmn;

public class CScartStepdefs {
	WebDriver driver;
	cscart.po.PO_Search PO_Search;
	cscart.po.PO_Login PO_Login;
	Scenario scn;
	@Before
	public void BeforeMethod(Scenario scn){
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		this.scn=scn;
	}
	
	@Given("I open {string} browser")
	public void i_open_browser(String browser) {
		driver=Cmn.InvokeBrowser(browser);
		scn.write("Browser Invoked");
	}

	@Given("I navigate to url as {string}")
	public void i_navigate_to_url_as(String url) {
	   Cmn.NavigateToURL(driver, url);
	   scn.write("URL Navigated to : "+url);
	}
//*****************************8Search Feature*******************************
	@When("I enter text in search text box as {string}")
	public void i_enter_text_in_search_text_box_as(String text) {
		PO_Search=PageFactory.initElements(driver, cscart.po.PO_Search.class);
		PO_Search.EnterTextInSearchBox(text);
		scn.write("Search box text entered as :" + text);
		
	}

	@When("I click on Search button")
	public void i_click_on_Search_button() {
	  PO_Search.ClickOnSearchButton();
	  scn.write("Clicked on search button");
	}

	@Then("Search results are displayed")
	public void search_results_are_displayed() {
		PO_Search.ValidateSearchResultIsDisplayed();
		scn.write("Search Results are displayed successfully");
	}
	
	//***************************Login Feature************************************
	
		@When("I click on {string} menu link at top right corner of the page")
	public void i_click_on_menu_link_at_top_right_corner_of_the_page(String arg) {
			PO_Login=PageFactory.initElements(driver, cscart.po.PO_Login.class);

			PO_Login.EnterclickonAccountMenu();
	    scn.write("Clicked on My Account button");

	}
		@When("I click on Sign In button")
		public void i_click_on_Sign_In_button() {
			 PO_Login.ClickOnSignInButton();
			   scn.write("Clicked on Sign In button");
		}

	


	@Then("Email is already displayed as {string}")
	public void email_is_already_displayed_as(String arg) {
		PO_Login.EmailIsAlreadyDisplayed_as();
		scn.write("Email is already displayed as:"+arg);
	   
	}





}
