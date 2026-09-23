package GroupSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.ExcellUtility;
import SuiteBaseTest.BaseClass;

public class HandlingDropDownLowProdTest extends BaseClass{
	@Test(groups = {"regression"})
	public void HandlingDropDownLowProd() throws Throwable
	{
		WebElement dropDown = driver.findElement(By.className("product_sort_container"));
		sutil.SelectVisibleText(dropDown, "Price (low to high)");
		
		ExcellUtility eutil= new ExcellUtility();
		String producName = eutil.ToReadTheDatFromExcell("Products", 4, 3);
		
		WebElement AddLowProduct = driver.findElement(By.xpath("//div[text()='"+producName+"']"));
		sutil.actionClick(AddLowProduct);
		
		WebElement addbtn = driver.findElement(By.id("add-to-cart"));
		sutil.actionClick(addbtn);
		
		WebElement carticon = driver.findElement(By.className("shopping_cart_badge"));
		sutil.actionClick(carticon);
		
		String cartitem = driver.findElement(By.className("inventory_item_name")).getText();
		Assert.assertEquals(producName, cartitem,"Product mismatch");
		Reporter.log("Validation Pass :"+producName+" added successfully", true);
	}

}
