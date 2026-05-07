package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="username")
	private WebElement userName;
	
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="submit")
	private WebElement submitButton;
	
	@FindBy(xpath="//div[text()='Your password is invalid!']")
	private WebElement inValidLoginMessage;
	
	
	public void enterUserName(String user) {
		userName.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnSubmitButton() {
		submitButton.click();;
	}
	
	public void login(String user,String pass) {
		enterUserName(user);
		enterPassword(pass);
		clickOnSubmitButton();
	}
	
	public String getInvalidLoginMsg() {
		return inValidLoginMessage.getText();
	}
	
	
}
