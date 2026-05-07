package tests;

import java.util.logging.LogManager;

import org.testng.Assert;
import org.testng.annotations.Test;

import driver.BaseTest;
import driver.DriverFactory;
import listerns.RetryAnalyzer;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;

public class LoginTest  extends BaseTest{

	

	@Test(priority=1)
	public void validateLoginWithPositiveScenario() {
		Log.logger.info("Test scenario with validateLoginWithPositiveScenario");
		String userName="student";
		String passWord="Password123";
		Log.logger.info("Login with username and password " + userName + ", " + passWord);
		loginPage.login(userName,passWord);
		Log.logger.info("Home Page text is" + homePage.getText());
		//System.out.println("Text: "+homePage.getText());
		Assert.assertEquals(homePage.getText(), "Logged In Successfully");	
	}
	
	@Test(priority=2)
	public void validateLoginWithInvalid() throws InterruptedException {
		loginPage.login("student", "Password1234");
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.getInvalidLoginMsg(),"xyz");
	}
}
