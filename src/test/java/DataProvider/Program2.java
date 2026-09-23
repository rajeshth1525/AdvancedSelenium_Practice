package DataProvider;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Program2 {
	@Test(dataProvider = "StudentDetails")
	public void studentinfo(String Name, int Roll_No ,String Grade)
	{
		Reporter.log("Student :"+Name+" ,|Roll No "+Roll_No+" ,|Grade"+Grade, false);
		
	}
	
	@DataProvider
	public Object[][] StudentDetails()
	{
		Object[][] obj= new Object[3][3];
		obj[0][0]="Rajesh";
		obj[0][1]=101;
		obj[0][2]="A";
		obj[1][0]="Shubhangi";
		obj[1][1]=102;
		obj[1][2]="D";
		obj[2][0]="Yuvansh";
		obj[2][1]=103;
		obj[2][2]="A+";
		return obj;
	}

}
