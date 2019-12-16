package cscart.stepdefs;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;

import cscart.po.PO_Search;
import cucumber.api.Scenario;

public class TestContextCsCart {

	public WebDriver driver;
	public PO_Search PO_Search;
	public Scenario scn;
	public HashMap<String, String> hm = new HashMap<String,String>();
}
