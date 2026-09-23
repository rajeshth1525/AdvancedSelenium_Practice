package JsonUtilityImplementation;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import GenericUtility.SeleniumUtility;

public class LockedUserLogin {
	public static void main(String[] args) throws Throwable {
		FileReader reader= new FileReader("./src\\test\\resources\\CommonData.json");
		JSONParser parser= new JSONParser();
		Object javaobj = parser.parse(reader);
		JSONObject jsonobj=(JSONObject)javaobj;
		String BROWSER = jsonobj.get("browser").toString();
		String URL = jsonobj.get("url").toString();
		String LOCKEDUSER = jsonobj.get("lockedUser").toString();
		String PASSWORD = jsonobj.get("password").toString();
		
		SeleniumUtility sutil= new SeleniumUtility();
		WebDriver driver = sutil.launcheBrowser(BROWSER);
		driver.get(URL);
		
		sutil.enterText(driver.findElement(By.id("user-name")), LOCKEDUSER);
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
		sutil.closeBrowser();
		
		
		
		
	}

}
