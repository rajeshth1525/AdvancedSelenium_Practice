package TestNgAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityTest {
	@Test(priority = 0)
	public void amazon()
	{
		Reporter.log("Amazon Excecuted", true);
	}
	
	@Test(priority = 1)
	public void cricbuzz()
	{
		Reporter.log("cricbuzz Excecuted", true);
	}
	@Test(priority = 2)
	public void zepto()
	{
		Reporter.log("zepto excecuted", true);
		
	}
	
	@Test(priority = 2)
	public void zomato()
	{
		Reporter.log("zomato excecuted", true);
	}
	@Test(priority = -1)
	public void flipcart()
	{
		Reporter.log("flipcart excecuted", true);
	}
	
	@Test(priority = -2)
	public void bigbasket()
	{
		Reporter.log("bigbasket excecuted", true);
	}
	
	@Test(priority = 4)
	public void Relience()
	{
		Reporter.log("Relience Excecuted", true);
	}

}
