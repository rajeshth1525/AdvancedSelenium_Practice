package DataProvider;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.BaseClass;

public class Program1 extends BaseClass {
	@Test(dataProvider = "loginDetails")
	public void login(String UserName,String PassWord)
	{
		Reporter.log("Login With :"+UserName+"====="+PassWord, true);
	}
	
	@DataProvider
	public Object[][] loginDetails()
	{
		Object[][] obj= new Object[3][2];
		obj[0][0]="Shubhangi";
		obj[0][1]="Shubhangi22";
		obj[1][0]="Yuvansh";
		obj[1][1]="Yuvansh15";
		obj[2][0]="ChotaBabu";
		obj[2][1]="ChotaBabu";
		return obj;
				
	}

}
