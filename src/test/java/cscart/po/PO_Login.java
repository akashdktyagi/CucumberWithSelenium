package cscart.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class PO_Login {

	WebDriver driver;
	
	public PO_Login(WebDriver d)
	{
		this.driver = d;
	}
	
	@FindBy(how = How.LINK_TEXT,using = "My Account")
	private WebElement account_menu_link;
	
	@FindBy(how=How.XPATH,using="//a[@href='http://demo.cs-cart.com/stores/eac5c45cb9584d7b/login/?return_url=index.php' and text()='Sign in'] ")
	private WebElement btn_sign_in;
	
	@FindBy(how=How.XPATH,using="//input[@id='login_popup4' and @value='customer@example.com'] ")
	private WebElement email_already_displayed;
	
	public void ClickOnAccountMenuLink() {
		account_menu_link.click();
	}

	public void ClickonSignInButton() {
		btn_sign_in.click();
	}

	public void EmailIsalreadyDisplayed() {
		boolean actual = email_already_displayed.isDisplayed();
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}

}
