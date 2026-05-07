package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverFactory {

	
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	
	public static void initDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}else if (browserName.equalsIgnoreCase("firfox")) {
			driver.set(new FirefoxDriver());
		}else {
			throw new RuntimeException("Browser type is not supported");
		}
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void quiteDriver() {
		getDriver().quit();
		driver.remove();
	}
}
