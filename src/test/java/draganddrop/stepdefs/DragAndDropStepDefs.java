package draganddrop.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import draganddrop.po.PO_DragAndDrop;

public class DragAndDropStepDefs 
{
	WebDriver driver;
	Scenario scn;
	PO_DragAndDrop PO_DragAndDrop ;
	
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

@Given("Browser is invoked")
public void browser_is_invoked() {
	driver = new ChromeDriver();
	scn.write("Browser is invoked");
}

@Given("Navigate to url as {string}")
public void navigate_to_url_as(String string) {
	driver.get(string);
	scn.write("Navigate to url as {string}");
}

@When("I click on Droppable")
public void i_click_on_Droppable() {
	PO_DragAndDrop = PageFactory.initElements(driver, PO_DragAndDrop.class);
	PO_DragAndDrop.i_click_on_Droppable();
	scn.write("I click on Droppable");
 }

@When("I want to perform drag and drop operation")
public void i_want_to_perform_drag_and_drop_operation() {
	PO_DragAndDrop.i_want_to_perform_drag_and_drop_operation();
	scn.write("I want to perform drag and drop operation");
}
}
