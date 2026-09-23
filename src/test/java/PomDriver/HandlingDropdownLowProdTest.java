package PomDriver;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Pom.DropDownPage;
import Pom.loginPage;
import PomBaseTest.BaseClass;

public class HandlingDropdownLowProdTest extends BaseClass {
	@Test
	public void HandlingDropdownLowProdDemo()
	{
		//login
		loginPage lpg= new loginPage(driver);
		lpg.login("standard_user", "secret_sauce");
		Reporter.log("Login successfull", true);
		
		//handling Dropdown
		DropDownPage dd= new DropDownPage(driver);
		dd.lowTohighProd();
		dd.getlowestProduct();
		dd.getcartIcon();
		dd.getProductName();
		Reporter.log("Lowest Prod Added SuccessFully", true);
		
		
		
		
	}


}
