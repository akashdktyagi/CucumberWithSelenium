package stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	protected Scenario SCN;
	//Hooks
	@Before
	public void BeforeMethod(Scenario s) {
		SCN = s;

	}
	

}
