package TestNgAttribute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCountTest1 {
	@Test(invocationCount = 4)
	public void invocationDemo()
	{
		WebDriver driver= new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.quit();
		Reporter.log("Browser launched", true);
	}

}
