package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import pageobjects.PO_Login;

public class TestContext {
	
	private WebDriver driver;
	private PO_Login oPO_Login;
	private Scenario oScn;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public PO_Login getoPO_Login() {
		return oPO_Login;
	}
	public void setoPO_Login(PO_Login oPO_Login) {
		this.oPO_Login = oPO_Login;
	}
	public Scenario getoScn() {
		return oScn;
	}
	public void setoScn(Scenario oScn) {
		this.oScn = oScn;
	}
	
	//********************Browser Methods**********************
	public WebDriver GetBrowser(String BrowserName) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		oScn.write("Browser Invoked and maximized");
		InitiaizePageObjects();
		return driver;
	}
	
	public void NavigateToBrowser(String arg) {
		driver.get(arg);
		oScn.write("Browser navigated to url: " + arg);
	}
	
	public void BrowserClosed() {
		driver.quit();
		oScn.write("Browser Closed");
	}
	
	public void InitiaizePageObjects() {
		oPO_Login = PageFactory.initElements(driver, PO_Login.class);
	}

}
