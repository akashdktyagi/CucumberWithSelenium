package cscart.po;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PO_Search {

	//Define The WebDriver
	WebDriver driver;
	
	//Paramatrized Constructor
	public PO_Search(WebDriver d)
	{
		this.driver = d;
	}
	
	//Locators
	@FindBy(how = How.ID, using = "search_input")
	private static WebElement txtbx_search;

	@FindBy(how = How.XPATH,using = "//button[@title='Search']")
	private static WebElement btn_search;
	
	@FindBy(how = How.XPATH,using = "//span[text()='Search results' and @class='ty-mainbox-title__left']")
	private static WebElement txt_search_results_title;
	
	//Methods
		public static void EnterTextInSearchBox(String text) {
			txtbx_search.sendKeys(text);
		}
		
		public static void ClickonSearchButton() {
			btn_search.click();
		}
		
		public static void ValidateSearchResultIsDisplayed() {
			boolean actual = txt_search_results_title.isDisplayed();
			boolean expected = true;
			Assert.assertEquals(expected, actual);
		}

}
