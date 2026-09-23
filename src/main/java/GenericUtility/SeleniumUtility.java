package GenericUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {
	public WebDriver driver;
	
	public WebDriver launcheBrowser(String BROWSER)
	{
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
			
		}
		else
		{
			System.out.println("Invalid Browser name in Properties File");
			return null;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
		
	}
	
	public void closeBrowser()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
	public void SelectVisibleText(WebElement element,String text)
	{
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void SelectByindex(WebElement element ,int index )
	{
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	
	public void SelectByValue(WebElement element,String value)
	{
		Select s= new Select(element );
		s.selectByValue(value);
	}
	
	public void actionClick(WebElement element)
	{
		Actions a= new Actions(driver);
		a.moveToElement(element).click().perform();
	}
	
	public void mouseHoverAction(WebElement element)
	{
		Actions a= new Actions(driver);
		a.moveToElement(element).click().perform();
	}
	public WebElement waiteForELementVisible(By locator ,int timeout)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement waitForElementClickable(By locator,int timeout)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void enterText(WebElement element ,String text)
	{
		element.clear();
		element.sendKeys(text);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	
	

	

}
