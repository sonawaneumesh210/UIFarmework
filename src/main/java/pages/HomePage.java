package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//h1[@class='post-title']")
	private WebElement homePageMsg;
	
	
	public String getText() {
		return homePageMsg.getText();
	}
	
	public boolean isDisplay() {
		return homePageMsg.isDisplayed();
	}
	
}
