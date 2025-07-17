package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test
	public void AccountRegister()
	{
		logger.info("***** Starting AccountRegister *****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.myaccount();
		logger.info("clicked on myAccount");
		hp.registration();
		logger.info("Clicked on Registration");
		
		
		logger.info("Customer's Details");
		RegistrationPage reg=new RegistrationPage(driver);
		reg.firstname(randomString().toUpperCase());
		reg.lastname(randomString().toUpperCase());
		reg.Mail(randomString()+"@gmail.com");
		reg.phoneNo(randomnumber());
		
		String password=pwd();
		reg.pass(password);
		reg.confirm(password);
		
		reg.Agree();
		reg.Conti();
		
		logger.info("validating expected message");
		String confmsg=reg.getmess();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("test failed");
			logger.debug("dubug...");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e){
						Assert.fail();
		}
		logger.info("***** Finished AccountRegister *****");
		}
	
	}
