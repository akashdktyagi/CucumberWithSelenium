package cscart.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Common 
{
	

		public static WebDriver InvokeBrowser(String browserType)
		{
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
			
		}
		public static void NavigateToUrl(WebDriver driver, String url)
		{
			driver.get(url);
		}

	}


