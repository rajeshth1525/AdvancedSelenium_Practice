package TakesScreenShot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

public class BasicTryCatch {
	public static void main(String[] args) {
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
		
		try {
			driver.findElement(By.id("WrongElement"));
			System.out.println("Test Case Pass Screenshot Not Needed");
			
		} 
		catch (Exception e) 
		{
			System.out.println("Screenshot Captured SuccessFully");
			
			try 
			{
				TakesScreenshot ts= (TakesScreenshot)driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest=new File("./ScreenShot/wrongElement.png");
				FileHandler.copy(src, dest);
				System.out.println("ScreenShot save at:"+dest.getAbsolutePath());
				
			} catch (IOException io) {
				System.out.println("Failed to save Screenshot:"+io.getMessage());
			}
		}
		
		finally 
		{
			driver.quit();
			System.out.println("Browser Close Safely");
			
		}
	}

}
