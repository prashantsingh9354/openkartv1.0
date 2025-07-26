package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends BasePage{
	public Search(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement input_Search;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	WebElement btn_search;
	
	public void Search(String src) {
		input_Search.sendKeys(src); 		
	}
	
	public void clickSearch() {
		btn_search.click();
	}

}
