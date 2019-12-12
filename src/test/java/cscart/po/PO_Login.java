package cscart.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class PO_Login 
{
	WebDriver driver;

	//Paramatrized Constructor
	public PO_Login(WebDriver d) {
		this.driver = d;
	}
	
	
	//Locators
	@FindBy(how = How.LINK_TEXT, using = "My Account")
	private WebElement txtbx_login;
	
	@FindBy(how =How.XPATH, using ="//a[@data-ca-target-id='login_block4']")
	private WebElement btn_login;
	
	@FindBy(how =How.XPATH,using="//button[@class='ty-btn__login ty-btn__secondary ty-btn']")
	private WebElement txt_login_results_title;
	
	@FindBy(how=How.XPATH,using= "//button[@class='ty-btn__login ty-btn__secondary ty-btn']")
	private WebElement Txt_Login_btn;
	
	@FindBy(how=How.XPATH, using = "//div[@class='ty-dropdown-box__title cm-combination logged']")
	private WebElement Txt_Sign_out_btn;
	
	@FindBy(how=How.XPATH,using= "//input[@value='customer@example.com']") 
	private WebElement Remove_previous_email;

	@FindBy(how=How.XPATH,using= "//input[@value='customer@example.com']") 
	private WebElement Enter_email_Address;
	

	@FindBy(how=How.XPATH,using= "//span[@class='ty-login-form__wrong-credentials-text ty-error-text']") 
	private WebElement Message_show;
	

	
	public void IClickOnAccountMenuLinkAtTopRightCornerOfThePage(String arg)
	{
		txtbx_login.click();
	}

	public void ClickonSignInButton() 
	{
		btn_login.click();
	}
	public void Emailisalreadydisplayedas() 
	{
		boolean actual = txt_login_results_title.isDisplayed();
		boolean expected = true;
		Assert.assertEquals(expected, actual);
    }


	public void IClickOnSignInButtonOnThePopUp() 
	{
		Txt_Login_btn.click();
	}


	
	public void IRemovePreviousEmail() 
	{
		Remove_previous_email.clear();
	}


	public void IenterEmailAddressAs(String text) 
	{
		Enter_email_Address.sendKeys(text);
	}


	public void ApplicationShouldThrowErrorAs(String string) 
	{
		Message_show.toString();
	}

	
	public void UserIsSignedInAndButtonIsDisplayedAfterClickingOnButton() 
	{
		 boolean actual = Txt_Sign_out_btn.isDisplayed();
			boolean expected = true;
			Assert.assertEquals(expected, actual);
			
	}
	

	
	

	

}
