package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test
	public void Login() {
		logger.info("**** Starting TC002_LoginTest ******");
		try {
		HomePage hp=new HomePage(driver);
		hp.myaccount();
		hp.login();
		
		LoginPage lp=new LoginPage(driver);
		lp.Email(p.getProperty("email"));
		lp.Pass(p.getProperty("pwd"));
		lp.login();
		
		MyAccountPage myacc=new MyAccountPage(driver);
	    boolean target=myacc.ismyaccdis();
	    
	    Assert.assertTrue(target); //Assert.assertEquals(target, true,"Login failed");
		}
		catch(Exception e){
			Assert.fail();
		}
		logger.info("**** Finished TC002_LoginTest ******");
	}
		

}
