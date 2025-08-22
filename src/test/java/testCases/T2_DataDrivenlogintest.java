package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homepage;
import pageObjects.loginpage;
import pageObjects.myaccountdashpage;
import testBase.BaseClass;
import utilities.DataProviders;

public class T2_DataDrivenlogintest extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verifyloginDDtest(String username ,String password, String exp)
	{
		
		logger.info("....Started T2_DDloginaccout....");
		
		try 
		{
		//Home Page	
		homepage hp=new homepage(driver);
		hp.setBtnsignup();
		hp.setbtnlogin();
		
		//Login page
		loginpage lp=new loginpage(driver);
		lp.setemail(username);
		lp.setpassword(password);
		lp.loginbtn();
		
		
		//my account page
		myaccountdashpage mypage=new myaccountdashpage(driver);
		Boolean page=mypage.ismyaccountpageexites();
		
		//Date is valid -login success - test pass
		//              -login fail -test fail
		
		//Date is Invalid -login fail - test pass
		//              -login success -test fail
		if(exp.equalsIgnoreCase("valid"))
		{
			if(page==true)
			{
			mypage.entermyaccount();	
			mypage.enterlogout();
			Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}

		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(page==true)
			{
				mypage.entermyaccount();
				mypage.enterlogout();
			    Assert.assertTrue(false);
			
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("....Completed T2_DDloginaccout....");
	}
	
	
	
	
	
	
	
}
