package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Wishlist extends BasePage {
	
	public Wishlist(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//i[@class='fa fa-heart']")
	WebElement btn_wishlist;
	
	public void wishlist() {
		btn_wishlist.click();
	}
	
	

}
