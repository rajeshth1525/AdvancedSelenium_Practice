package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
	@FindBy(className = "product_sort_container")
	WebElement sordDropDOwn;
	
	@FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement zToAProduct;
	
	@FindBy(id = "add-to-cart-sauce-labs-onesie")
	WebElement lowestProduct;
	
	@FindBy(className = "shopping_cart_link")
	WebElement cartIcon;
	
	@FindBy(className = "inventory_item_name")
	WebElement productName;
	
	public DropDownPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ZtoAProd()
	{
		Select s= new Select(sordDropDOwn);
		s.selectByValue("za");
				
	}
	
	public void lowTohighProd()
	{
		Select s= new Select(sordDropDOwn);
		s.selectByValue("lohi");
				
	}
	
	public void getZtoAProduct()
	{
		zToAProduct.click();
	}
	
	public void getlowestProduct()
	{
		lowestProduct.click();
	}
	
	public void getcartIcon()
	{
		cartIcon.click();
	}
	
	public String getProductName()
	{
		return productName.getText();
		
	}
	
	

}
