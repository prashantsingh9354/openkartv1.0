package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
 
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myAccMess;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btn_logout;
	
	public void logout() {
		btn_logout.click();
	}
	
	public boolean ismyaccdis() 
	{
		try {
		return(myAccMess.isDisplayed());
		}
		catch(Exception e){
			return false;
		}
	
	}
}
