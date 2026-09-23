package GroupSuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import SuiteBaseTest.BaseClass;

public class MultipleProductsAddToCartTest extends BaseClass{
	@Test(groups = {"regression"})
	public void MultipleProductsAddToCart()
	{
		sutil.actionClick(driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")));
		sutil.actionClick(driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")));
		sutil.actionClick(driver.findElement(By.id("add-to-cart-sauce-labs-onesie")));
		sutil.actionClick(driver.findElement(By.className("shopping_cart_link")));
		
		int cartcount = driver.findElements(By.className("inventory_item_name")).size();
		Assert.assertEquals(cartcount, 3,"count Misssmatch");
		Reporter.log("Validation pass:", true);
		
	}

}
