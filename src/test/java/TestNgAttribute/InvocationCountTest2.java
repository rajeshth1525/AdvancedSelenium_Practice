package TestNgAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCountTest2 {
	@Test(invocationCount = 2)
	public void invocationdemo()
	{
		Reporter.log("Login done", true);
		
	}
	
	
	
	@Test(invocationCount = 3)
	public void invocationdemo2()
	{
		Reporter.log("logout done", true);
	}
	

}
