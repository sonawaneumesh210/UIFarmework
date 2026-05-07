package driver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import configReader.ConfigReader;
import pages.HomePage;
import pages.LoginPage;

public class BaseTest {

    // 🔥 Make it protected so listener + child classes can access
    public WebDriver driver;

    protected LoginPage loginPage;
    protected HomePage homePage;

    @Parameters({"browser","url"})
    @BeforeMethod(alwaysRun = true)
    public void setBrowser(@Optional("chrome") String browser, String url) throws IOException {

        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();

        System.out.println("Browser : " + browser);
        System.out.println("URL : " + url);

        driver.get(ConfigReader.getProperty(url));

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit(); // ✅ safer than factory call sometimes
        }

        // OR if you want factory cleanup:
        // DriverFactory.quitDriver();
    }

    // ✅ Optional getter (BEST PRACTICE)
    public WebDriver getDriver() {
        return driver;
    }
}