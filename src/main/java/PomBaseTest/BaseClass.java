package PomBaseTest;

import java.time.Duration;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver= null;
	public static WebDriver sdriver=null;
	@BeforeClass
	
	public void launchBrowser()
	{
		driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		sdriver=driver;
		driver.get("https://www.saucedemo.com/");
		Reporter.log("Browser Laounched successfully", true);
	}
	
	@AfterMethod
	public void logoutApp()
	{
		try
		{
			WebDriverWait waite= new WebDriverWait(driver, Duration.ofSeconds(20));
			waite.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn"))).click();
			
			@NonNull
			WebElement logout = waite.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
			logout.click();
			Reporter.log("Logout successfull", true);
			
			
		}
		catch (Exception e)
		{
			Reporter.log("Logout Skipped:"+e.getMessage(), true);
		}
	}
	
	@AfterClass
	
	public void closeBrowser()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		Reporter.log("Browser close successfully", true);
	}

}
