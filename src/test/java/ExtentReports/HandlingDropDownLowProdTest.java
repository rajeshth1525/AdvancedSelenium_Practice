package ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ListenerTest.BaseCLass2;
@Listeners(ListenerUtility.ExtentReportListener.class)

public class HandlingDropDownLowProdTest extends BaseCLass2{
	@Test
	public void HandlingDropDownLowProd()
	{
		//dropdown handle
		WebElement DropDown = driver.findElement(By.className("product_sort_container"));
		Select s =new Select(DropDown);
		s.selectByIndex(2);
		
		//Add First product After Low price Selection
		driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		
		//Validation
		String cartitem = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).getText();
		if(cartitem.contains("Sauce Labs Onesie"))
		{
			System.out.println("Pass:First Low product Added SUccessfully");
		}
		else {
			System.out.println("Faile:Diffrent product added");
		}
	}
	
	@Test
	public void skippeTest()
	{
		throw new SkipException("intentionally we are skipp this test");
	}
	
	

}
