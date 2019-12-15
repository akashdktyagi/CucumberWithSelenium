package draganddrop.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PO_DragAndDrop {
	//Define The WebDriver
			WebDriver driver;
			
			//Paramatrized Constructor
			public PO_DragAndDrop(WebDriver d)
			{
				this.driver = d;
			}
			
			
			//Locators 
			@FindBy(how = How.XPATH,using = "//a[text()='Droppable']")
			private WebElement Droppable;
			
			@FindBy(how = How.XPATH,using = "//div[@id='draggable']")
			private WebElement drag_operation;
			
			@FindBy(how = How.XPATH,using ="//div[@id='droppable']")
			private WebElement drop_operation;
			
			//method
			public void i_click_on_Droppable() 
			{
				Droppable.click();
			}

			public void i_want_to_perform_drag_and_drop_operation() 
			{
				WebElement frame = driver.findElement(By.className("demo-frame"));
				driver.switchTo().frame(frame);
				
				Actions a =new Actions(driver);
				//a.dragAndDrop(drag_operation, drop_operation).perform();
				a.moveToElement(drag_operation).clickAndHold().moveToElement(drop_operation).release().build().perform();
			}
			
			
			

}
