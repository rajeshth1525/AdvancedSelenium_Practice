package PomDriver;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Pom.loginPage;
import PomBaseTest.BaseClass;

public class LoginPageTest extends BaseClass{
	@Test
	public void LoginDemo()
	{
		loginPage lpg= new loginPage(driver);
		lpg.login("standard_user", "secret_sauce");
		Reporter.log("Login successfull", true);
		
		
	}

}
