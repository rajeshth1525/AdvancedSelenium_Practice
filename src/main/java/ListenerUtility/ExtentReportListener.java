package ListenerUtility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ListenerTest.BaseCLass2;

public class ExtentReportListener implements ITestListener{
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onStart(ITestContext context)
	{
		Date d= new Date();
		String newdate = d.toString().replace(" ", "_").replace(":", "_");
		
		spark= new ExtentSparkReporter("./ExtentReports/"+context.getName()+"_"+newdate+".png");
		spark.config().setDocumentTitle("Automation Testing");
		spark.config().setReportName("Soucedemo");
		spark.config().setTheme(Theme.DARK);
		
		report= new ExtentReports();
		report.attachReporter(spark);
		
		report.setSystemInfo("OS", "window11");
		report.setSystemInfo("BROWSER", "Edge");
        report.setSystemInfo("OWNER", "rajesh");
		report.setSystemInfo("DIRECTOR", "shubhangi");
		report.setSystemInfo("TESTER","aarav" );
		report.setSystemInfo("DEVLOPER", "yuvansh");
			
		
	}

	

	@Override
	public void onTestStart(ITestResult result) 
	{
		String tcName = result.getMethod().getMethodName();
		test=report.createTest(tcName);
		test.log(Status.INFO, "Test Started"+tcName);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, "Test Pass:"+result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String tcName = result.getMethod().getMethodName();
		Date d= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd_HHmmss");
		String newdate = sdf.format(d);
		
		try 
		{
			TakesScreenshot ts= (TakesScreenshot)BaseCLass2.sdriver;
			String src = ts.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String( src,tcName+"_"+newdate);
			
			
		} 
		catch (Exception e) 
		{
			test.log(Status.WARNING, "screenshot not captured"+e.getMessage());
			
		}
		test.log(Status.FAIL, "===="+tcName+" Failure ====");
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String tcName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "===="+tcName+" skipped ====");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
			
	}
	
	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
		
		
	}

	
	

}
