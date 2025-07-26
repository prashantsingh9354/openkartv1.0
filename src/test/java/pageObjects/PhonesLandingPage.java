package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhonesLandingPage extends BasePage {
	
	public PhonesLandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='caption']//a[contains(text(),'iPhone')]")
	WebElement lnk_Iphone;
	
	public void iphone() {
		lnk_Iphone.click();
	}

	
}
