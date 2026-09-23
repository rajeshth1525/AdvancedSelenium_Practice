package Parameters_CrossBrowserTesting;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ParaMetereBaseTest.BaseClass;

public class MultipleProductsAddToCartTest extends BaseClass{
	@Test
	public void MultipleProductsAddToCart()
	{
		sutil.actionClick(driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")));
		sutil.actionClick(driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")));
		sutil.actionClick(driver.findElement(By.id("add-to-cart-sauce-labs-onesie")));
		sutil.actionClick(driver.findElement(By.className("shopping_cart_link")));
		
		int cartcount = driver.findElements(By.className("inventory_item_name")).size();
		if(cartcount==3)
		{
			System.out.println("validation pass");
		}
		else
		{
			System.out.println("validation failed");
		}
	}

}
