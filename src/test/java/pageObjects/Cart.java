package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends BasePage {
	public Cart(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement btn_Totalcart;
	
	@FindBy(xpath="//strong[normalize-space()='Checkout']")
	WebElement btn_CheckOut;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btn_FinalCheckout;
	
	public void cart() {
		btn_Totalcart.click();
	}
	
	public void checkout() {
		btn_CheckOut.click();
	}
	
	public void CheckoutConfirm() {
		btn_FinalCheckout.click();
	}

}
