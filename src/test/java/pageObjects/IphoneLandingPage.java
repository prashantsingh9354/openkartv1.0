package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IphoneLandingPage extends BasePage{
	
	public IphoneLandingPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btn_AddToCart;
	
	public void AddtoCart() {
		btn_AddToCart.click();
	}
}
