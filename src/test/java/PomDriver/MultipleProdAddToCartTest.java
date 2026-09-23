package PomDriver;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Pom.MultipleProd;
import Pom.loginPage;
import PomBaseTest.BaseClass;

public class MultipleProdAddToCartTest extends BaseClass {
	@Test
	public void MultipleProdAddToCartDemo()
	{
		//loging
		loginPage lpg= new loginPage(driver);
		lpg.login("standard_user", "secret_sauce");
		Reporter.log("Login Successfully", true);
		
		//add multi prod
		MultipleProd multi= new MultipleProd(driver);
		multi.AddMultiProd();
		multi.getcartIcon();
		int count = multi.getCartCount();
		Reporter.log("Cart count is:"+count, true);
	}

}
