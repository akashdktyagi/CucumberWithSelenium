package DragDropstepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class DragDropStepDefs
{
	WebDriver driver;
	Scenario scn;

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

	@Given("I Open Chrome Browser")
	public void i_Open_Chrome_Browser() 
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Given("I navigate to URL as {string}")
	public void i_navigate_to_URL_as(String string) 
	{
		driver.get(string);
	}

	@Given("I Click on {string} Link")
	public void i_Click_on_Link(String string)
	{
		driver.findElement(By.linkText(string)).click();
	}

	@When("I drag Source Section and drop it on Target Section")
	public void i_drag_Source_Section_and_drop_it_on_Target_Section() 
	{

		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);

		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		action.dragAndDrop(source, target).build().perform();
		scn.write("I dragged Source Section and dropped it on Target Section");
	}

	@Then("Drag and Drop operation is successfull")
	public void drag_and_Drop_operation_is_successfull() 
	{
		driver.findElement(By.xpath("//div[@id='droppable']")).isDisplayed();
	}

	//**************************************slide operation *******************************


	@When("I Slide slider from point {int} to point {int}")
	public void i_Slide_slider_from_point_to_point(Integer int1, Integer int2) 
	{
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);

		WebElement element_slider = driver.findElement(By.id("slider"));
		Actions act = new Actions(driver);
		act.clickAndHold(element_slider);
		act.moveByOffset(300, 0).build().perform();

		act.clickAndHold(element_slider).moveByOffset(int2, 0).build().perform();
		scn.write("I operate Slider operation");
	}

	//*************************************Tool Tip *******************************************


	@When("I hover on {string} link")
	public void i_hover_on_link(String string) 
	{
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);

		Actions act = new Actions (driver);
		act.moveToElement(driver.findElement(By.linkText(string))).build().perform();
		scn.write("I hover on link: "+string);
		
		
		
	}

	@Then("Hover text appears with text as {string}")
	public void hover_text_appears_with_text_as(String string) 
	{
		String helpText= driver.findElement(By.className("ui-tooltip-content")).getText();

		String actual = helpText;
		String expected  = string;
		Assert.assertEquals(expected, actual);
		scn.write("Hover text appears with text as: " + string);
		

	}






}
