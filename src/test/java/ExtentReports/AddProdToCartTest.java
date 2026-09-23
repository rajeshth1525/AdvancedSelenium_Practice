package ExtentReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ListenerTest.BaseCLass2;

@Listeners(ListenerUtility.ExtentReportListener.class)
public class AddProdToCartTest extends BaseCLass2 {
	@Test
	public void AddProdToCart()
	{
		driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Validation
		
		String CartItem = driver.findElement(By.className("inventory_item_name")).getText();
		//Intentionally fail this for taking Screenshot
		Assert.assertEquals(CartItem, "Wrong Product ");
	}
	
	@Test
	public void skippedtest()
	{
		throw new SkipException("This test is skipped intentianalyy");
	}

}
