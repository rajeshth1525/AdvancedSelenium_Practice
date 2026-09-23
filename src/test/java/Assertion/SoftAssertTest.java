package Assertion;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void DemoSoftAssert()
	{
		String expected="Faceboo";
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		@Nullable
		String actual = driver.getTitle();
		SoftAssert soft= new SoftAssert();
		soft.assertEquals(actual, expected);
		System.out.println("step1");
		System.out.println("step2");
		soft.assertAll();
		
	}

}
