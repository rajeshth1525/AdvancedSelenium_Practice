package JsonUtilityImplementation;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GenericUtility.ExcellUtility;
import GenericUtility.SeleniumUtility;

public class HandlingDropdownZtoA {
	public static void main(String[] args) throws Throwable {
		FileReader reader=new FileReader("./src\\test\\resources\\CommonData.json");
		JSONParser parser= new JSONParser();
		Object javaobj = parser.parse(reader);
		JSONObject jsonobj= (JSONObject)javaobj;
		
		String BROWSER = jsonobj.get("browser").toString();
		String URL = jsonobj.get("url").toString();
		String USERNAME = jsonobj.get("username").toString();
		String PASSWORD = jsonobj.get("password").toString();
		
		SeleniumUtility sutil= new SeleniumUtility();
		WebDriver driver = sutil.launcheBrowser(BROWSER);
		driver.get(URL);
		
		sutil.enterText(driver.findElement(By.id("user-name")), USERNAME);
		sutil.enterText(driver.findElement(By.id("password")), PASSWORD);
		sutil.actionClick(driver.findElement(By.id("login-button")));
		
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
			System.out.println("validation pass:"+productName+ " ZtoA product added Succesfully");
		}
		else 
		{
			System.out.println("Validation Failed: Product Missmatch");
		}
		
		WebElement menu = sutil.waitForElementClickable(By.id("react-burger-menu-btn"), 10);
		sutil.actionClick(menu);
		
		WebElement logout = sutil.waiteForELementVisible(By.id("logout_sidebar_link"), 10);
		sutil.actionClick(logout);
		sutil.closeBrowser();
	}

}
