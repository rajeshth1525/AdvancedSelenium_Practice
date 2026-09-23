package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	WebElement addToCart;
	
	@FindBy(className = "shopping_cart_link")
	WebElement CartIcon;
	
	@FindBy(className = "inventory_item_name")
	WebElement ProductName;
	
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void getaddToCart()
	{
		addToCart.click();
	}
	public void getCartIcon()
	{
		CartIcon.click();
	}
	
	public String getProductName()
	{
		return ProductName.getText();
		
	}

}
