package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homepage;
import pageObjects.loginpage;
import pageObjects.myaccountdashpage;
import testBase.BaseClass;

public class T2_loginaccout extends BaseClass{

	
	@Test(groups={"Sanity","Master"})
	public void verifylogin()
	{
		try
		{
		logger.info("....Started T2_loginaccout....");
		homepage hp=new homepage(driver);
		hp.setBtnsignup();
		hp.setbtnlogin();
		
		loginpage lp=new loginpage(driver);
		lp.setemail(p.getProperty("username"));
		lp.setpassword(p.getProperty("password"));
		lp.loginbtn();
		
		//my account page
		myaccountdashpage mypage=new myaccountdashpage(driver);
		Boolean page=mypage.ismyaccountpageexites();
		if(page.valueOf(true))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("....Completed T2_loginaccout....");
	}
	
	
	
	
	
}
