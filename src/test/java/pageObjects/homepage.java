package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homepage extends Basepage{
	
	public homepage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath ="//span[text()='My Account']")
	WebElement btnmyaccount;

	@FindBy(xpath ="//a[text()='Register']")
	WebElement btnRegister;
	
	@FindBy(xpath ="//a[text()='Login']")
	WebElement btnlogin;
	
	@FindBy(xpath ="//span[text()='Shopping Cart']")
	WebElement btnshoppingcart;
	
	@FindBy(xpath ="//span[@id='cart-total']")
	WebElement btncarttotal;
	
	@FindBy(xpath ="//a[text()='MacBook']/parent::h4/following::p[2]")
	WebElement txtproductprice;
	
	@FindBy(xpath ="//ul[@class='nav navbar-nav']/child::li[1]")
	WebElement btnnavbar;
	
	public void setBtnsignup() {
		btnmyaccount.click(); 
	}
	
	public void setbtnRegister() {
		btnRegister.click(); 
	}
	
	public void setbtnlogin() {
		btnlogin.click(); 
	}
	
	public void addcard(String product)
	{
		String xpath ="//a[text()='"+product+"']/../../../div[3]/button[1]";
		driver.findElement(By.xpath(xpath)).click();
		
	}
	public void clickOnShoppingCart()
	{
		btnshoppingcart.click();
	}
	
	public String gettxtFcart() {
		 return btncarttotal.getText();
	}
	
	public String getproductprice() {
		 return txtproductprice.getText();
	}
	
	public void setbtnnavbar() {
		  btnnavbar.click();;
	}
	
	public void setbtnnavbar(int i)
	{
		String xpath ="//ul[@class='nav navbar-nav']/child::li["+i+"]";
		System.out.print(xpath);
		driver.findElement(By.xpath(xpath)).click();
		
	}
}
