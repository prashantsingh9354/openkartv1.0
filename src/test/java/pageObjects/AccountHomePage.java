package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountHomePage extends BasePage {
	
	public AccountHomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//nav[@id='menu']//li[6]")
	WebElement lnk_Phones;
	
	public void phones()
	{
		lnk_Phones.click();
	}
	

}
