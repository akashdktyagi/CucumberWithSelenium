package slider.po;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PO_Slider {

	WebDriver driver;
	public PO_Slider(WebDriver d) 
	{
		this.driver=d;
	}
	
	@FindBy(how=How.XPATH,using="//a[text()='Slider']")
	private WebElement link;
	
	@FindBy(how=How.ID,using="slider")
	private WebElement slider;
	
	
	
	public void i_click_on_link() 
	{
		link.click();
	}

	public void i_want_to_perform_ranges_of_slider_as_to_operation()
	{
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		
		Actions a= new Actions(driver);
		a.clickAndHold(slider);
        a.moveByOffset(300, 0).build().perform();
			
	}

}
