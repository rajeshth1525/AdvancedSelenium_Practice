package GenericUtilityImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GenericUtility.PropertiesUtilty;
import GenericUtility.SeleniumUtility;

public class MultipleProductsAddToCart {
	public static void main(String[] args) throws Throwable {
		PropertiesUtilty putil= new PropertiesUtilty();
		String BROWSER = putil.ToReadDataFromPropertieFile("browser");
		String URL = putil.ToReadDataFromPropertieFile("url");
		String USERNAME = putil.ToReadDataFromPropertieFile("username");
		String PASSWORD = putil.ToReadDataFromPropertieFile("password");
		SeleniumUtility sutil= new SeleniumUtility();
		WebDriver driver = sutil.launcheBrowser(BROWSER);
		driver.get(URL);
		
		sutil.enterText(driver.findElement(By.id("user-name")), USERNAME);
		sutil.enterText(driver.findElement(By.id("password")), PASSWORD);
		sutil.actionClick(driver.findElement(By.id("login-button")));
		
		sutil.actionClick(driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")));
		sutil.actionClick(driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")));
		sutil.actionClick(driver.findElement(By.id("add-to-cart-sauce-labs-onesie")));
		sutil.actionClick(driver.findElement(By.className("shopping_cart_link")));
		
		int cartcount = driver.findElements(By.className("inventory_item_name")).size();
		if(cartcount==3)
		{
			System.out.println("validation pass");
		}
		else
		{
			System.out.println("validation failed");
		}
		
		WebElement menu = sutil.waitForElementClickable(By.id("react-burger-menu-btn"), 10);
		sutil.actionClick(menu);
		sutil.actionClick(sutil.waitForElementClickable(By.id("logout_sidebar_link"), 10));
		sutil.closeBrowser();
		
		
		
	}

}
