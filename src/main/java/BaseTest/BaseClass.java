package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import GenericUtility.PropertiesUtilty;
import GenericUtility.SeleniumUtility;

public class BaseClass {
	public WebDriver driver=null;
	public PropertiesUtilty putil= new PropertiesUtilty();
	public SeleniumUtility sutil= new SeleniumUtility();
	
	@BeforeSuite
	public void beforesuite()
	{
		Reporter.log("DB Open", true);
	}
	
	@BeforeTest
	public void beforetest()
	{
		Reporter.log("Precondition Start", true);
	}
	
	@BeforeClass
	public void beforeclass() throws Throwable
	{
		String BROWSER = putil.ToReadDataFromPropertieFile("browser");
		String URL = putil.ToReadDataFromPropertieFile("url");
		driver=sutil.launcheBrowser(BROWSER);
		driver.get(URL);
		Reporter.log("Browser Launched + Url done", true);
	}
	
	@BeforeMethod
	public void beforemethod() throws Throwable
	{
		String USERNAME = putil.ToReadDataFromPropertieFile("username");
		String PASSWORD = putil.ToReadDataFromPropertieFile("password");
		
		sutil.enterText(driver.findElement(By.id("user-name")), USERNAME);
		sutil.enterText(driver.findElement(By.id("password")), PASSWORD);
		sutil.actionClick(driver.findElement(By.id("login-button")));
		Reporter.log("Login Successfully", true);
		
	}
	
	@AfterMethod
	public void aftermethod()
	{
		sutil.actionClick(sutil.waitForElementClickable(By.id("react-burger-menu-btn"), 10));
		sutil.actionClick(sutil.waiteForELementVisible(By.id("logout_sidebar_link"), 10));
		Reporter.log("Logout Successfully", true);
	}
	
	@AfterClass
	public void afterclass()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		Reporter.log("Browser Close", true);
	}
	
	@AfterTest
	public void aftertest()
	{
		Reporter.log("PostCondition DOne", true);
	}
	
	@AfterSuite
	public void aftersuite()
	{
		Reporter.log("DB Close", true);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
