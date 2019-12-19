package misc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

public class Stepdefs {
	WebDriver driver;
	Scenario scn;

	@Before
	public void BeforeMethod(Scenario s) {
		System.setProperty("webdriver.chrome.driver","E:\\setup java\\chromedriver.exe");
		this.scn=s;
	}
		
	@Given("I Open Chrome Browser")
	public void i_Open_Chrome_Browser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		scn.write("I Opened Chrome Browser");
	}

	@Given("I navigate to URL as {string}")
	public void i_navigate_to_URL_as(String string) {
		driver.get(string);
		scn.write("Navigated to URL as: "+string);
	}

	@Given("I Click on {string} Link")
	public void i_Click_on_Link(String string) {
		driver.findElement(By.linkText(string)).click();
		scn.write("I clicked on link: "+string);
}

	@When("I drag Source Section and drop it on Target Section")
	public void i_drag_Source_Section_and_drop_it_on_Target_Section() {
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(source, target).build().perform();
		scn.write("I dragged Source Section and dropped it on Target Section");
}

	@When("I Slide slider from point {int} to point {int}")
	public void i_Slide_slider_from_point_to_point(Integer int1, Integer int2) {
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		WebElement element_slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		Actions action = new Actions(driver);
		action.clickAndHold(element_slider).moveByOffset(int2, 0).build().perform();
		scn.write("I slided Slider");
	}
	

	@When("I hover on {string} link")
	public void i_hover_on_link(String string) {
	WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	driver.switchTo().frame(frame);
	
	Actions act = new Actions (driver);
	act.moveToElement(driver.findElement(By.linkText(string))).build().perform();
	scn.write("I hover on link: "+string);
	}


	
	@Then("Hover text appears with text as {string}")
	public void hover_text_appears_with_text_as(String arg) {
	
		String helpText= driver.findElement(By.className("ui-tooltip-content")).getText();

		String actual = helpText;
		String expected  = arg;
		Assert.assertEquals(expected, actual);
		scn.write("Hover text appears with text as: " + arg);
		}
}