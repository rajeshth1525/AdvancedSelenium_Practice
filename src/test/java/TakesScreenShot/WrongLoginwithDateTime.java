package TakesScreenShot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

public class WrongLoginwithDateTime {
	public static void main(String[] args) {
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
		try 
		{
			driver.findElement(By.id("user-name")).sendKeys("WrongUN");
			driver.findElement(By.id("password")).sendKeys("WrongPW");
			driver.findElement(By.id("login-button")).click();
			WebElement errormsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
			System.out.println("login failed with"+errormsg);
			
			Date d= new Date();
			SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd_HHmmss");
			String newDate = sdf.format(d);
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest= new File("./ScreenShot/wrongLogin"+newDate+".png");
			FileHandler.copy(src, dest);
			System.out.println("Screnshot captured at"+dest.getAbsolutePath());
				
		} 
		catch (IOException io) 
		{
			System.out.println("failed to screenshot with msg:"+io.getMessage());
			
		}
		finally 
		{
			driver.quit();
			System.out.println("Browser close safely");
			
		}
	}

}
