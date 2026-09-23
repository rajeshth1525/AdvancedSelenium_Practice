package BaseTestDriver;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import GenericUtility.PropertiesUtilty;

public class LockedUserLoginTest extends BaseClass{
	
	@Override
	
	public void beforemethod()
	{
		//This method will skipped we are manually added Login step
	}
	
	@Test
	public void LockedUserLogin() throws Throwable
	{
		PropertiesUtilty putil= new PropertiesUtilty();
		String LOCKED_USERNAME = putil.ToReadDataFromPropertieFile("lockedusername");
		String PASSWORD = putil.ToReadDataFromPropertieFile("password");
		sutil.enterText(driver.findElement(By.id("user-name")), LOCKED_USERNAME);
		sutil.enterText(driver.findElement(By.id("password")), PASSWORD);
		sutil.actionClick(driver.findElement(By.id("login-button")));
		
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
