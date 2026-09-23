package TestNgAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class EnableTest {
	@Test(enabled = false)
	public void manu()
	{
		Reporter.log("Manu excecuted", true);
	}
	
	@Test
	public void yuvansh()
	{
		Reporter.log("Yuvansh is my son", true);
	}
	
	@Test(enabled = true)
	public void aarav()
	{
		Reporter.log("Aarav is my younger son", true);
	}
	
	@Test
	public void shubhangi()
	{
		Reporter.log("shubhangi is my beutifull wife", true);
	}

}
