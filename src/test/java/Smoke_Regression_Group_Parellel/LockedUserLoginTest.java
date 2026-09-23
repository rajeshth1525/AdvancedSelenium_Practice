package Smoke_Regression_Group_Parellel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import SuiteBaseTest.BaseClass;

public class LockedUserLoginTest extends BaseClass {
	@Override
	public void beforeMethod()
	{
		
	}
	@Test
	public void LockedUserLogin()
	{
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login successufull");
		
		String errormsg = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		if(errormsg.contains(" Sorry, this"))
		{
			System.out.println("Validation Pass: getting Expected error");
		}
		else
		{
			System.out.println("Validation Failed : unexpected behaviour");
			
		}
	}

}
