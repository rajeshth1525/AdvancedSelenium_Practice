package Smoke_Regression_Group_Parellel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import GenericUtility.ExcellUtility;
import SuiteBaseTest.BaseClass;

public class AddProdToCartTest extends BaseClass{
	@Test
	public void AddProdToCart() throws Throwable
	{
		ExcellUtility eutil= new ExcellUtility();
		 String productName = eutil.ToReadTheDatFromExcell("Products", 1, 2);
		 
		 driver.findElement(By.xpath("//div[text()='"+productName+"']")).click();
		 driver.findElement(By.id("add-to-cart")).click();
		 driver.findElement(By.id("shopping_cart_container")).click();
		 
		 String cartitem = driver.findElement(By.className("inventory_item_name")).getText();
		 if(cartitem.equals(productName))
		 {
			 System.out.println("Validation pass :" +productName+ " added succesfully");
		 }
		 
		 else
		 {
			 System.out.println("Validation Fail:Product MissMatch");
		 }
	}

}
