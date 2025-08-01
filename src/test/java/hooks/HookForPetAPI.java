package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HookForPetAPI {
	@Before
	public  void runBeforeTest() {
		System.out.println("TestExecution of scenario Starts");
	}
	
	@After
	public  void runAfterTest() {
		System.out.println("TestExecution of scenario ends");
	}

}
