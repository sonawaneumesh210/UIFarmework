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

public class LoginTest2  extends BaseTest{

	

	@Test(priority=1,dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
	public void validateLoginWithPositiveScenario(String username, String password) {
		Log.logger.info("Test scenario with validateLoginWithPositiveScenario");
		Log.logger.info("Login with username and password " + username + ", " + password);
		loginPage.login(username,password);
		Log.logger.info("Home Page text is" + homePage.getText());
		//System.out.println("Text: "+homePage.getText());
		Assert.assertEquals(homePage.getText(), "Logged In Successfully");	
	}
	
	@Test(priority=2,enabled=false)
	public void validateLoginWithInvalid() throws InterruptedException {
		loginPage.login("student", "Password1234");
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.getInvalidLoginMsg(),"xyz");
	}
}
