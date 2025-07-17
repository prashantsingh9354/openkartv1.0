package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
		
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement txt_mail;
	
	@FindBy(xpath ="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath ="//input[@value='Login']")
	WebElement btn_login;
	
	public void Email(String email) {
		txt_mail.sendKeys(email);
	}
	
	public void Pass(String pass) {
		txt_password.sendKeys(pass);
	}
	
	public void login() {
		btn_login.click();
	}

}
