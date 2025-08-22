package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registerpage extends Basepage{

	public registerpage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath ="//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath ="//input[@id ='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath ="//input[@id ='input-telephone']")
	WebElement txttelephone;
	
	@FindBy(xpath ="//input[@name='password']")
	WebElement txtpassword;
	
	@FindBy(xpath ="//input[@id ='input-confirm']")
	WebElement txtconfirmpassword;
	
	@FindBy(xpath ="//label[text()='No']")
	WebElement btnNoradio;
	
	@FindBy(xpath ="//label[text()='Yes']")
	WebElement btnYesradio;
	
	@FindBy(xpath ="//input[@type='checkbox']")
	WebElement Checkbox;
	
	@FindBy(xpath ="//input[@type='submit']")
	WebElement btnsubmit;
	
	

	public void setTxtfirstname(String firstname) {
		txtfirstname.sendKeys(firstname);
	}


	public void setTxtlastname(String lastname) {
		txtlastname.sendKeys(lastname);
	}

	public void setTxtemail(String email) {
		txtemail.sendKeys(email);
	}

	public void setTxttelephone(String telephone) {
		txttelephone.sendKeys(telephone);
	}

	public void setTxtpassword(String password) {
		txtpassword.sendKeys(password);
	}

	public void setTxtconfirmpassword(String confirmpassword) {
		txtconfirmpassword.sendKeys(confirmpassword);
	}

	public void setBtnNoradio() {
		btnNoradio.click();
	}

	public void setCheckbox() {
		Checkbox.click();
	}

	public void setBtnsubmit() {
		btnsubmit.click();
	}


	
}
