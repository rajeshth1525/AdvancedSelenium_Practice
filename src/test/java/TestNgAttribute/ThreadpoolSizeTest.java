package TestNgAttribute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ThreadpoolSizeTest {
	@Test(invocationCount = 4, threadPoolSize = 2 )
	public void ThreadpoolsizeDemo() throws Throwable
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		Reporter.log("Browser Launch by Thread:"+Thread.currentThread().getId(), true);
		Thread.sleep(3000);
		driver.quit();
	}

}
