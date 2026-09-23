package GroupSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.ExcellUtility;
import SuiteBaseTest.BaseClass;

public class HandlingDropdownZtoATest extends BaseClass{
	@Test(groups = {"regression"})
	public void HandlingDropdownZtoA() throws Throwable
	{
		WebElement dropDown = driver.findElement(By.className("product_sort_container"));
		sutil.SelectByindex(dropDown, 1);
		
		ExcellUtility eutil= new ExcellUtility();
		String productName = eutil.ToReadTheDatFromExcell("Products", 7, 3);
		
		WebElement ZtoAProduct = driver.findElement(By.xpath("//div[text()='"+productName+"']"));
		sutil.actionClick(ZtoAProduct);
		WebElement addbtn = driver.findElement(By.id("add-to-cart"));
		sutil.actionClick(addbtn);
		WebElement carticon = driver.findElement(By.className("shopping_cart_link"));
		sutil.actionClick(carticon);
		String cartitem = driver.findElement(By.className("inventory_item_name")).getText();
		Assert.assertEquals(productName, cartitem,"Product Mismatch");
		Reporter.log("Validation pass:"+productName+" added successufully", true);
		
	}

}
