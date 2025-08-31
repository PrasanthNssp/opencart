package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homepage;
import pageObjects.shoppingcartpage;
import testBase.BaseClass;

public class T3_addcart extends BaseClass {

	shoppingcartpage sc;
	@Test(priority=1)
	public void verifyaddcart()
	{
		logger.info("started verifyaddcart");
		try
		{
		homepage hp=new homepage(driver);
		hp.addcard("iPhone");
		Thread.sleep(2000);
		
		String CartHeadprice=hp.gettxtFcart();
		hp.clickOnShoppingCart();
		logger.info("clicked on ShoppingCart button");
		String productprice = hp.getproductprice();
		 
		sc= new shoppingcartpage(driver);
		sc.isproductdisplayed();
		logger.info("product display pass");
		sc.ispricedisplayed();
		sc.isquantitydisplayed();
		logger.info("quanty display pass");
		String totalprice = sc.istotalpricedisplayed();
		logger.info("comparistion started "+ totalprice+"is"+CartHeadprice+"look");
		
		// Capture price with $ sign
		CartHeadprice = CartHeadprice.replaceAll(".*(\\$[0-9.]+).*", "$1");


		// Trim just in case
		CartHeadprice = CartHeadprice.trim();
		totalprice = totalprice.trim();
		Assert.assertEquals(totalprice, CartHeadprice, 
			    "Total price and price from cart are mismatched!");

		logger.info("completed verifyaddcart");
		}
		catch(Exception e)
		{
			  logger.error("Exception in verifyaddcart: ", e);
			  Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
	
	@Test(priority=2)
	public void verifyremovecart()
	{
		try
		{
			logger.info("verifyremovecart is started");
		sc.toRemoveTheProduct();
		String prompt = sc.isemptypromptdisplayed();
		Assert.assertEquals(prompt, "Your shopping cart is empty!");
		logger.info("verifyremovecart is completed");
		}
		catch (Exception e)
		{
			Assert.fail("due to exception verifyremovecart failed"+e.getMessage());
		}
	}
	
}
