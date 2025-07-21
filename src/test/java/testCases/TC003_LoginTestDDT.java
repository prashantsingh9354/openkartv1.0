package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginTestDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void LoginDDT(String email,String pwd, String exp )
	{
		logger.info("*******Starting TC003_LoginTestDDT******");
		
		try 
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.myaccount();
		hp.login();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.Email(email);
		lp.Pass(pwd);
		lp.login();
		
		//MyAccount
		MyAccountPage myacc=new MyAccountPage(driver);
		boolean target=myacc.ismyaccdis();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(target==true)
			{
				myacc.logout();
				Assert.assertTrue(true);
			}	
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(target==true)
			{
				myacc.logout();		
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
		logger.info("*******Finished TC003_LoginTestDDT******");
		
	}

}
