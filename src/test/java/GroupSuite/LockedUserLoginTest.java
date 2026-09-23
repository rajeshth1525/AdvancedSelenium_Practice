package GroupSuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import SuiteBaseTest.BaseClass;

public class LockedUserLoginTest extends BaseClass {
	@Override
	public void beforeMethod()
	{
		
	}
	@Test(groups = {"smoke"})
	public void LockedUserLogin()
	{
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login successufull");
		
		String errormsg = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		Assert.assertTrue(errormsg.contains("Sorry, this"),"unexpected behaviour");
		Reporter.log("Validation pass: getting msg as expected", true);
	}

}
