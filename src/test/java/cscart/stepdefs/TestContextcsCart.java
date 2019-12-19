package cscart.stepdefs;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import cscart.po.PO_Login;
import cscart.po.PO_Search;
import cucumber.api.Scenario;

public class TestContextcsCart {
	WebDriver driver;
	PO_Search PO_Search;
	PO_Login PO_Login;
	Scenario scn;
	public HashMap<String, String> hm = new HashMap<String,String>();
}
