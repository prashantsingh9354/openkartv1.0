package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
		
	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement txtFname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtmail;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtphone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPass;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement btnAgree;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnConti;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement ConfirmationMess;
	
	public void firstname(String fName) {
		txtFname.sendKeys(fName);
	}
	
	public void lastname(String Lname) {
		txtLname.sendKeys(Lname);
	}
	
	public void Mail(String mail) {
		txtmail.sendKeys(mail);
	}
	
	public void phoneNo(String no) {
		txtphone.sendKeys(no);
	}
	
	public void pass(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void confirm(String pwd) {
		txtConfirmPass.sendKeys(pwd);
	}
	
	public void Agree() {
		btnAgree.click();
	}
	
	public void Conti() {
		btnConti.click();
	}
	
	public String getmess() {
		try {
			return(ConfirmationMess.getText());
		}
		catch(Exception e){
			return(e.getMessage());
		}
	}
	
	
	
	
}
