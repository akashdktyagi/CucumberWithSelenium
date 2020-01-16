package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs{
	
@Before
public void BeforeMethod()
{
	
}
@After
public void afterMethod()
{
	driver.quit();
}
	WebDriver driver;
	@Given("Open Chrome browser")
	public void open_Chrome_browser() {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
	
	}

	@Given("Navigate to URL {string}")
	public void navigate_to_URL(String str1) {
		driver.get(str1);
	
	
	}

	@When("Click on {string} link")
	public void click_on_link(String str2) {
		
		driver.findElement(By.linkText(str2)).click();
		
	}

	@When("I Drag source section and drop it on Target Section")
	public void i_Drag_source_section_and_drop_it_on_Target_Section() {

		//Read about Builder Pattern
		//Read about method Chaining
		
		//Switch to Frame
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame1);
		
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(source, target).build().perform();

	}

	@Then("Drag and Drop operation is successfull")
	public void drag_and_Drop_operation_is_successfull() {
		System.out.println("Operation done sucessfully");
	}
}

//*******************************************************************************************
	