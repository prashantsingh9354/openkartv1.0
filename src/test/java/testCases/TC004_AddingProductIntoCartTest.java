package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountHomePage;
import pageObjects.Cart;
import pageObjects.HomePage;
import pageObjects.IphoneLandingPage;
import pageObjects.LoginPage;
import pageObjects.PhonesLandingPage;
import testBase.BaseClass;

public class TC004_AddingProductIntoCartTest extends BaseClass {
	
	@Test
	public void AddingProduct()
	{
		HomePage hp=new HomePage(driver);
		hp.myaccount();
		hp.login();
		
		LoginPage lp=new LoginPage(driver);
		lp.Email(p.getProperty("email"));
		lp.Pass(p.getProperty("pwd"));
		lp.login();
		
		AccountHomePage acchp= new AccountHomePage(driver);
		acchp.phones();
		
		PhonesLandingPage ph=new PhonesLandingPage(driver);
		ph.iphone();
		
		IphoneLandingPage iph=new IphoneLandingPage(driver);
		iph.AddtoCart();
		
		Cart cart=new Cart(driver);
		cart.cart();
		cart.checkout();
		cart.CheckoutConfirm();
		
		
	}

}
