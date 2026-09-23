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

public class HandlingDropDownLowProd {
	public static void main(String[] args) throws Throwable {
		FileReader reader= new FileReader("./src\\test\\resources\\CommonData.json");
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
		if(cartitem.equals(producName))
		{
			System.out.println("Validation pass:"+producName+ " added lowest product");
		}
		else 
		{
			System.out.println("validation Failed:Product missmatch");
			
		}
		
		WebElement menu = sutil.waitForElementClickable(By.id("react-burger-menu-btn"), 10);
		sutil.actionClick(menu);
		
		WebElement logout = sutil.waiteForELementVisible(By.id("logout_sidebar_link"), 10);
		sutil.actionClick(logout);
		
		sutil.closeBrowser();
	
	}

}
