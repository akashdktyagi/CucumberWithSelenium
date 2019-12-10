package cscart.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class PO_Search {
	//Define WebDriver
	WebDriver driver;
	//Parameterised constructor
	public PO_Search(WebDriver d){
		this.driver=d;
	}
	//Locators
	@FindBy(how=How.ID,using="search_input")
	private WebElement txtbx_search;
	
	@FindBy(how=How.XPATH,using="//button[@title='Search']")
	private WebElement btn_search;
	
	@FindBy(how=How.XPATH,using="//span[@class='ty-mainbox-title__left' and  text()='Search results']")
	private WebElement txt_search_results_title;
	
	//Methods
	public void EnterTextInSearchBox(String text){
		txtbx_search.sendKeys(text);
		
	}
	public void ClickOnSearchButton(){
		btn_search.click();
	}
	public void ValidateSearchResultIsDisplayed(){
		boolean actual=txt_search_results_title.isDisplayed();
		boolean expected=true;
		Assert.assertEquals(expected, actual);
	}
	

}
