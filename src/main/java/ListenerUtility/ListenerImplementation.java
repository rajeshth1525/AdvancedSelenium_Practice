package ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import ListenerTest.BaseClass;

public class ListenerImplementation implements ITestListener {

	
	@Override
	public void onStart(ITestContext context) 
	{
		Reporter.log("Test Excecution Started", true);
		Reporter.log("Total Tests:"+context.getAllTestMethods().length, true);
		
	}

	@Override
	public void onFinish(ITestContext context)
	{
		Reporter.log("Test Execution finish", true);
		Reporter.log("pass test:"+context.getPassedTests(), true);
		Reporter.log("Failed Test:"+context.getFailedTests(), true);
		Reporter.log("Skipped Test:"+context.getSkippedTests(), false);
		
	}
	@Override
	public void onTestStart(ITestResult result) 
	{
		Reporter.log("====="+result.getMethod().getMethodName()+" Started =====", false);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("====="+result.getMethod().getMethodName()+" success =====", false);
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		Date d= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd_HHmmss");
		String newDate = sdf.format(d);
		TakesScreenshot ts= (TakesScreenshot)BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./ScreenShot/"+result.getMethod().getMethodName()+"_"+newDate+".png");
		
		try
		{
			FileHandler.copy(src, dest);
			Reporter.log("ScreenShot save at:"+dest.getAbsolutePath(), true);
			
		} 
		catch (IOException io)
		{
			Reporter.log("screenshot failed to save:"+io.getMessage(), true);
			
		}
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("====="+result.getMethod().getMethodName()+" skipped =====", true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		Reporter.log("====="+result.getMethod().getMethodName()+" Failed But Within Success Percentage", true);
		 
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		Reporter.log("====="+result.getMethod().getMethodName()+"Test Failed With Timeout", true);
		
	}

	

}
