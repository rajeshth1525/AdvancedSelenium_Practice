package GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtilty {
	public  String ToReadDataFromPropertieFile(String key) throws Throwable
	{
		FileInputStream fis= new FileInputStream("./src\\test\\resources\\CommonData.properties");
		Properties prop= new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}

}
