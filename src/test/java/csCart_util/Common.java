package csCart_util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common 
{



	public static WebDriver InvokedBrowser(String Browsertype)
	{
		System.setProperty("webdriver.chrome.driver","C://Users//DELL//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static void NavigateToUrl(WebDriver driver, String url)
	{
		driver.get(url);
	}

}
