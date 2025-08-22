package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myaccountdashpage extends Basepage{

	
	public myaccountdashpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath= "//a[@title='My Account']")
	WebElement btnmyaccount;
	
	@FindBy(xpath= "//a[contains(text(),'Logout')]")
	WebElement btnlogout;
	
	@FindBy(xpath= "//h2[text()='My Account']")
	WebElement textmyaccount;
	public void enterlogout()
	{
		btnlogout.click();
	}
	
	public void entermyaccount()
	{
		btnmyaccount.click();
	}
	
	public Boolean ismyaccountpageexites()
	{
		return textmyaccount.isDisplayed();
	}
}
