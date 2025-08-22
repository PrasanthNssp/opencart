package pageObjects;

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
	
	public void setBtnsignup() {
		btnmyaccount.click(); 
	}
	
	public void setbtnRegister() {
		btnRegister.click(); 
	}
	
	public void setbtnlogin() {
		btnlogin.click(); 
	}
	
}
