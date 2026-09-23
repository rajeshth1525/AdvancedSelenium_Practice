package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbtn;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement erromsg;
	
	public loginPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	public void login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
	}
	
	public String erroMessage()
	{
		return erromsg.getText();
		
	}

}
