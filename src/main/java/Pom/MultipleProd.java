package Pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleProd {
	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	WebElement product1;
	
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement product2;
	
	@FindBy(id = "add-to-cart-sauce-labs-onesie")
	WebElement product3;
	
	@FindBy(className = "shopping_cart_link")
	WebElement cartIcon;
	
	@FindBy(className = "inventory_item_name")
	List<WebElement> CartCount;
	
	
	public MultipleProd(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void AddMultiProd()
	{
		product1.click();
		product2.click();
		product3.click();
	}
	public void getcartIcon()
	{
		cartIcon.click();
	}
	
	public int getCartCount()
	{
		return CartCount.size();
		
	}
	
	

}
