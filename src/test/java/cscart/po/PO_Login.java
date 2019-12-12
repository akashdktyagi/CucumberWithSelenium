package cscart.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class PO_Login {
	WebDriver driver;
	//Parameterized constructor
	public PO_Login(WebDriver d){
		this.driver=d;
	}
	//Locators
	@FindBy(how=How.LINK_TEXT,using="My Account")
	private WebElement txtbtn_myacnt;
	
	@FindBy(how=How.XPATH,using="//a[text()='Sign in' and @title='Sign in' ]")
	private WebElement btn_signin;
	
	@FindBy(how=How.XPATH,using="//input[@value='customer@example.com']")
	private WebElement Email_Already_Displayed;

	//Methods
	public void EnterclickonAccountMenu(){
		txtbtn_myacnt.click();
	}
	public void ClickOnSignInButton(){
		btn_signin.click();
	}
	public void EmailIsAlreadyDisplayed_as(){
		boolean actual=Email_Already_Displayed.isDisplayed();
		boolean expected=true;
		Assert.assertEquals(expected, actual);
	}
}
