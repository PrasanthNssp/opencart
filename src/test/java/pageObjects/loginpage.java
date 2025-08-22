package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class loginpage extends Basepage{
	
	public loginpage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath ="//input[@id='input-password']")
     WebElement txtpassword;
	
	@FindBy(xpath ="//input[@value='Login']")
	WebElement btnlogin;
	
	public void setemail(String usename)
	{
		txtemail.sendKeys(usename);
	}
	
	public void setpassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	
	public void loginbtn()
	{
		btnlogin.click();
	}
}
