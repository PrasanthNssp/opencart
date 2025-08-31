package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homepage;
import testBase.BaseClass;

public class T4_Navbar_navigation extends BaseClass {
	
	@Test
	public void verifynavigation() {
		try {
		homepage hp=new homepage(driver);
		for (int i=1;i<10;i++)
		{
		hp.setbtnnavbar(i);
	}
		}catch(Exception e)
		{
			Assert.fail("T4_Navbar_navigation fail"+e.getMessage());
		}
	}
	

}
