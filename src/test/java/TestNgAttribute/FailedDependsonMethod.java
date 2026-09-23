package TestNgAttribute;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FailedDependsonMethod {
	@Test
	public void createAccount()
	{
		Assert.fail("Unable to Create Account");
		Reporter.log("Account faile to crete", true);
	}
	
	@Test(dependsOnMethods = "createAccount")
	public void editAccount()
	{
		
		Reporter.log("Account Edited", true);
	}
	
	@Test(dependsOnMethods = "editAccount")
	public void deleteAccoun()
	{
		
		Reporter.log("Account deleted", true);
	}

}
