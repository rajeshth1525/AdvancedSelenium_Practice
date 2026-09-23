package PomDriver;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Pom.InventoryPage;
import Pom.loginPage;
import PomBaseTest.BaseClass;

public class AddProdToCartTest extends BaseClass {
	@Test
	public void AddProdToCartDemo()
	{
		//login
		loginPage lpg= new loginPage(driver);
		lpg.login("standard_user", "secret_sauce");
		Reporter.log("Login successFull", true);
		//addProduct
		InventoryPage inv=new InventoryPage(driver);
		inv.getaddToCart();
		inv.getCartIcon();
		inv.getProductName();
		Reporter.log("Product Added Successfully", true);
		
	}

}
