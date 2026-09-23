package Assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import GenericUtility.PropertiesUtilty;
import GenericUtility.SeleniumUtility;

public class LockedUserLogin {
	public static void main(String[] args) throws Throwable {
		PropertiesUtilty putil= new PropertiesUtilty();
		String BROWSER = putil.ToReadDataFromPropertieFile("browser");
		String URL = putil.ToReadDataFromPropertieFile("url");
		String LOCKED_USERNAME = putil.ToReadDataFromPropertieFile("lockedusername");
		String PASSWORD = putil.ToReadDataFromPropertieFile("password");
		SeleniumUtility sutil= new SeleniumUtility();
		WebDriver driver = sutil.launcheBrowser(BROWSER);
		driver.get(URL);
		
		sutil.enterText(driver.findElement(By.id("user-name")), LOCKED_USERNAME);
		sutil.enterText(driver.findElement(By.id("password")), PASSWORD);
		sutil.actionClick(driver.findElement(By.id("login-button")));
		
		String errormsg = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		SoftAssert soft= new SoftAssert();
		soft.assertTrue(errormsg.contains("Epic sadface"));
		System.out.println("Expected msg getting");
		sutil.closeBrowser();
	}

}
