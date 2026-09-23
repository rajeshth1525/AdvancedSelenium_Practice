package Assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import GenericUtility.ExcellUtility;
import GenericUtility.PropertiesUtilty;
import GenericUtility.SeleniumUtility;

public class HandlingDropDownLowProd {
	public static void main(String[] args) throws Throwable {
		PropertiesUtilty putil =new PropertiesUtilty();
		String BROWSER = putil.ToReadDataFromPropertieFile("browser");
		String URL = putil.ToReadDataFromPropertieFile("url");
		String USERNAME = putil.ToReadDataFromPropertieFile("username");
		String PASSWORD = putil.ToReadDataFromPropertieFile("password");
		
		SeleniumUtility sutil= new SeleniumUtility();
		WebDriver driver = sutil.launcheBrowser(BROWSER);
		driver.get(URL);
		
		WebElement userfield = driver.findElement(By.id("user-name"));
		sutil.enterText(userfield, USERNAME);
		WebElement passfield = driver.findElement(By.id("password"));
		sutil.enterText(passfield, PASSWORD);
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		sutil.actionClick(loginbtn);
		
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
		Assert.assertEquals(cartitem, producName,"Product Missmatch");
		System.out.println("Validation Pass: "+producName+" added successfully");
		
		WebElement menu = sutil.waitForElementClickable(By.id("react-burger-menu-btn"), 10);
		sutil.actionClick(menu);
		
		WebElement logout = sutil.waiteForELementVisible(By.id("logout_sidebar_link"), 10);
		sutil.actionClick(logout);
		sutil.closeBrowser();
	}

}
