package PomDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pom.loginPage;
import PomBaseTest.BaseClass;

public class LockedUserTest extends BaseClass {
	@Test
	public void LockeduseDemo()
	{
		loginPage lpg= new loginPage(driver);
		lpg.login("locked_out_user", "secret_sauce");
		String err = lpg.erroMessage();
		Assert.assertTrue(err.contains("Epic sadface"), "Unexpecetd Behaviour");
		Reporter.log("Getting user has been loacked ", true);
		
	}

}
