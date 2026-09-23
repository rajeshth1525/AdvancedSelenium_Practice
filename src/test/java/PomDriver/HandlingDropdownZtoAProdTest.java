package PomDriver;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Pom.DropDownPage;
import Pom.loginPage;
import PomBaseTest.BaseClass;

public class HandlingDropdownZtoAProdTest extends BaseClass {
	@Test
	public void HandlingDropdownZtoAProd()
	{
		loginPage lpg= new loginPage(driver);
		lpg.login("standard_user", "secret_sauce");
		Reporter.log("Login successfull", true);
		
		DropDownPage dd= new DropDownPage(driver);
		dd.ZtoAProd();
		dd.getZtoAProduct();
		dd.getcartIcon();
		dd.getProductName();
		Reporter.log("Z to A Prod Added SuccessFully", true);
	}
	

}
