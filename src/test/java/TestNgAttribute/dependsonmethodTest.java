package TestNgAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class dependsonmethodTest {
	@Test()
	public void createAccount()
	{
		Reporter.log("Account Created", true);
	}
	
	@Test(dependsOnMethods = "createAccount")
	public void editaccount()
	{
		Reporter.log("Accont edited", true);
	}
	
	@Test(dependsOnMethods = "editaccount")
	public void deleteAccount()
	{
		Reporter.log("Account deleted", true);
	}

}
