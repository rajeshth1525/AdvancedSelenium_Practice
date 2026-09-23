package Smoke_Regression_Group_Parellel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import GenericUtility.ExcellUtility;
import SuiteBaseTest.BaseClass;

public class HandlingDropdownZtoATest extends BaseClass{
	@Test
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
		
		if (cartitem.equals(productName))
		{
			System.out.println("validation pass:"+productName+ "ZtoA product added Succesfully");
		}
		else 
		{
			System.out.println("Validation Failed: Product Missmatch");
		}
		
	}

}
