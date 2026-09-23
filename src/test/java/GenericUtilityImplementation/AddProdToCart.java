package GenericUtilityImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GenericUtility.ExcellUtility;
import GenericUtility.PropertiesUtilty;
import GenericUtility.SeleniumUtility;

public class AddProdToCart {
	public static void main(String[] args) throws Throwable {
		 PropertiesUtilty putil=new PropertiesUtilty();
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
		 
		
	     WebElement menu = sutil.waitForElementClickable(By.id("react-burger-menu-btn"), 20);
	     menu.click();
	     WebElement logout = sutil.waiteForELementVisible(By.id("logout_sidebar_link"), 10);
	     logout.click();
		 
		 
		 sutil.closeBrowser();
		 
		
	}

}
