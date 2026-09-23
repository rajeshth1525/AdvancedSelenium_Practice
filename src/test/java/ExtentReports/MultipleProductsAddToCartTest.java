package ExtentReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ListenerTest.BaseCLass2;
@Listeners(ListenerUtility.ExtentReportListener.class)
public class MultipleProductsAddToCartTest extends BaseCLass2 {
	@Test
	public void MultipleProductsAddToCart()
	{
		//Add 3 product
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//validation
		int CartItem = driver.findElements(By.className("inventory_item_name")).size();
		Assert.assertEquals(CartItem, 5);
		System.out.println("Test Faile..cartitem count is mismatcg");
	}
	
	@Test
	public void skippedtest()
	{
		throw new SkipException("intentianally we skipp this test");
	}

}
