package slider.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.Scenario;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import slider.po.PO_Slider;

public class Slider {
	
	WebDriver driver;
	Scenario scn;
	PO_Slider PO_Slider;
	
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
	
	@Given("Browser is invoked")
	public void browser_is_invoked() 
	{
		driver=new ChromeDriver();
		scn.write("Browser is invoked");
	}

	@Given("Navigate to url as {string}")
	public void navigate_to_url_as(String string) 
	{
		driver.get(string);
		scn.write("Navigate to url as ");
	}

	@When("I click on {string} link")
	public void i_click_on_link(String string) 
	{
	   PO_Slider = PageFactory.initElements(driver,PO_Slider.class);
	   PO_Slider. i_click_on_link();
	   scn.write("I click on  link");
	}

	@When("I want to perform ranges of slider as {string} to {string} operation")
	public void i_want_to_perform_ranges_of_slider_as_to_operation(String string, String string2) 
	{
	  PO_Slider.i_want_to_perform_ranges_of_slider_as_to_operation();
	  scn.write("I want to perform ranges of slider as  to operation");
	}



}
