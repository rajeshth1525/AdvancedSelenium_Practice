package ListenerTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public WebDriver driver= null;
	public static WebDriver sdriver=null;
	
	@BeforeSuite
	public void beforesuite()
	{
		Reporter.log("DB open", true);
	}
	
	@BeforeTest
	public void beforetest()
	{
		Reporter.log("Precondition Start", true);
	}
	
	@BeforeClass
	public void beforeclass()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
		sdriver=driver;
		Reporter.log("Launched Browser and Url done", true);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		Reporter.log("Login step dummy", true);
	}
	
	@AfterMethod
	public void aftermethod()
	{
		Reporter.log("Logout step dummy", true);
	}
	
	@AfterClass
	public void afterclass()
	{
		driver.quit();
		Reporter.log("Browser close Successfully", true);
	}

}
