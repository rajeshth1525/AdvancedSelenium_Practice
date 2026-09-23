package SuiteBaseTest;

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
	public WebDriver driver= null;
	public PropertiesUtilty putil= new PropertiesUtilty();
	public SeleniumUtility sutil= new SeleniumUtility();
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void beforeSuite()
	{
		Reporter.log("DB Open", true);
	}
	
	@BeforeTest(groups = {"smoke","regression"})
	public void beforeTest()
	{
		Reporter.log("Precondition Start", true);
	}
	
	@BeforeClass(groups = {"smoke","regression"})
	public void beforeClass() throws Throwable
	{
		String BROWSER = putil.ToReadDataFromPropertieFile("browser");
		String URL = putil.ToReadDataFromPropertieFile("url");
		driver=sutil.launcheBrowser(BROWSER);
		driver.get(URL);
		Reporter.log("Browser Launched and Url done", true);
		
	}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void beforeMethod() throws Throwable
	{
		String USERNAME = putil.ToReadDataFromPropertieFile("username");
		String PASSWORD = putil.ToReadDataFromPropertieFile("password");
		sutil.enterText(driver.findElement(By.id("user-name")), USERNAME);
		sutil.enterText(driver.findElement(By.id("password")), PASSWORD);
		sutil.actionClick(driver.findElement(By.id("login-button")));
		Reporter.log("Login successfully", true);
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void afterMethod()
	{
		sutil.actionClick(sutil.waiteForELementVisible(By.id("react-burger-menu-btn"), 10));
		sutil.actionClick(sutil.waitForElementClickable(By.id("logout_sidebar_link"), 10));
		Reporter.log("Logout successfully", true);
	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void afterClass()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		Reporter.log("Logout SuccessFully", true);
	}
	
	@AfterTest(groups = {"smoke","regression"})
	public void afterTest()
	{
		Reporter.log("PostCondition DOne", true);
	}
	
	@AfterSuite(groups = {"smoke","regression"})
	public void afterSuite()
	{
		Reporter.log("DB Close", true);
	}

}
