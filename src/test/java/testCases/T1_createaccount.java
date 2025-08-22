package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import pageObjects.homepage;
import pageObjects.myaccountdashpage;
import pageObjects.registerpage;
import testBase.BaseClass;

public class T1_createaccount extends BaseClass{


	@Test(groups={"Regression","Master"})
	public void verifycreateaccount() 
	{
		logger.info("..started T1_createaccount .....");
		try
		{
		homepage hp=new homepage(driver);
		hp.setBtnsignup();
		hp.setbtnRegister();
		
		registerpage rg=new registerpage(driver);
		rg.setTxtfirstname(randomstring());
		rg.setTxtlastname(randomstring());
		rg.setTxtemail(randomstring()+"@gmail.com");
		rg.setTxttelephone("9585888622");
		rg.setTxtpassword("Test@123");
		rg.setTxtconfirmpassword("Test@123");
		rg.setBtnNoradio();
		rg.setCheckbox();
		rg.setBtnsubmit();
		
		myaccountdashpage mp=new myaccountdashpage(driver);
		mp.entermyaccount();
		mp.enterlogout();
		
		logger.info("....completed the T1_createaccount....");
		}
		catch(Exception e)
		{
			Assertion s=new Assertion();
			s.fail();
		}
	}
	
	public String randomstring()
	{
		String genratedString=RandomStringUtils.randomAlphabetic(5);
		return genratedString;
	}
	
}
