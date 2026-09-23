package Assertion;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {
	@Test
	public void HardAssert()
	{
		String expected = "Facebook";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		@Nullable
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
		System.out.println("Step1");
		driver.quit();
	}

}
