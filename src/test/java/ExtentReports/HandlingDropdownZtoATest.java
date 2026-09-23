package ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ListenerTest.BaseCLass2;
@Listeners(ListenerUtility.ExtentReportListener.class)
public class HandlingDropdownZtoATest extends BaseCLass2{
	@Test
	public void HandlingDropdownZtoA()
	{
		WebElement DropDown = driver.findElement(By.className("product_sort_container"));
		Select s= new Select(DropDown);
		s.selectByVisibleText("Name (Z to A)");
		
		//Add First Product after Z to A Selection
		driver.findElement(By.className("inventory_item_name")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		
		String Cartitem = driver.findElement(By.className("inventory_item_name")).getText();
		if(Cartitem.equals("Test.allTheThings() T-Shirt (Red)"))
		{
			System.out.println("Pass:First Z To A product Added Successfully");
		}
		else {
			System.out.println("Faile:Diffrent product added");
		}
	}
	
	@Test
	public void skippedtest()
	{
		throw new SkipException("This test is skipp intentianally");
	}

}
