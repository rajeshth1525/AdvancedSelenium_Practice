package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random r= new Random();
		return r.nextInt(1000);	
	}
	
	public String getSytemDate()
	{
		Date d= new Date();
		return d.toString();
		
	}
	
	public String getFormateDate()
	{
		Date d= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd_HHmmss");
		return sdf.format(d);
		
	}
	
	public String getUniqueStringNumber(String base)
	{
		int randomnum = getRandomNumber();
		return base +"_"+ randomnum;
	}

}
