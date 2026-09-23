package GroupSuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.ExcellUtility;
import SuiteBaseTest.BaseClass;

public class AddProdToCartTest extends BaseClass{
	@Test(groups = {"smoke"})
	public void AddProdToCart() throws Throwable
	{
		ExcellUtility eutil= new ExcellUtility();
		 String productName = eutil.ToReadTheDatFromExcell("Products", 1, 2);
		 
		 driver.findElement(By.xpath("//div[text()='"+productName+"']")).click();
		 driver.findElement(By.id("add-to-cart")).click();
		 driver.findElement(By.id("shopping_cart_container")).click();
		 
		 String cartitem = driver.findElement(By.className("inventory_item_name")).getText();
		 Assert.assertEquals(productName, cartitem,"Product mismatch");
		 System.out.println("Validation pass :"+productName+" added successfully");
		
	}

}
