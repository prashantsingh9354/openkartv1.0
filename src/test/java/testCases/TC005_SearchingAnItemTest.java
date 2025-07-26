package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Search;
import pageObjects.Wishlist;
import testBase.BaseClass;

public class TC005_SearchingAnItemTest extends BaseClass {
	
	@Test
	public void Searching() throws InterruptedException {
		
		logger.info("**** Starting TC002_LoginTest ******");
		
		HomePage hp=new HomePage(driver);
		hp.myaccount();
		hp.login();
		
		LoginPage lp=new LoginPage(driver);
		lp.Email(p.getProperty("email"));
		lp.Pass(p.getProperty("pwd"));
		lp.login();
		
		Search src=new Search(driver);
		src.Search(p.getProperty("product_search"));
		//Thread.sleep(1000);
		src.clickSearch();
		Thread.sleep(1000);
		
		// Adding to wishList
		src.addtowishlist();
		
		// opening wishlist
		Wishlist wl=new Wishlist(driver);
		wl.wishlist();
		Thread.sleep(1000);
				
		
		logger.info("**** Finished TC002_LoginTest ******");
		
		
	}

}
