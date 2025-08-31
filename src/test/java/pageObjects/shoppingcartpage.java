package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shoppingcartpage extends Basepage{

	public shoppingcartpage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath ="//a[text()='iPhone']")
	WebElement txtiphone;
	
	@FindBy(xpath ="//a[text()='iPhone']/../../td[3]")
	WebElement txtquantity;
	
	@FindBy(xpath ="//td[text()='product 11']/parent::tr/child::td[6]")
	WebElement txtprice;
	
	@FindBy(xpath ="//strong[text()='Total:']/../../td[2]")
	WebElement txttotalprice;
	
	@FindBy(xpath ="//a[text()='iPhone']/../../td[3]/../td[5]/button")
	WebElement btnremove;
	
	@FindBy(xpath ="//p[text()='Your shopping cart is empty!']")
	WebElement txtemptyprompt;
	
	public void isproductdisplayed()
	{
		txtiphone.isDisplayed();
	}
	
	public void isquantitydisplayed()
	{
		txtquantity.isDisplayed();
	}
	public void ispricedisplayed()
	{
		txtprice.isDisplayed();
	}
	public String istotalpricedisplayed()
	{
		return txttotalprice.getText();
	}
	
	public void toRemoveTheProduct()
	{
		btnremove.click();
	}
	
	public String isemptypromptdisplayed()
	{
		return txtemptyprompt.getText();
	}
}
