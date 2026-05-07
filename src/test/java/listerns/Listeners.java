package listerns;

import com.aventstack.extentreports.*;
import org.testng.*;
import utils.ExtentManager;
import utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import driver.BaseTest;

public class Listeners implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // ✅ ALWAYS initialize here
    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);

        System.out.println("onTestStart executed for: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ensureTestInitialized(result);

        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        // 🔥 CRITICAL FIX
        ensureTestInitialized(result);

        test.get().fail(result.getThrowable());

        // Screenshot
        Object currentClass = result.getInstance();
        WebDriver driver = ((driver.BaseTest) currentClass).getDriver();

        String path = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());

        try {
            test.get().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ensureTestInitialized(result);

        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // 🔥 COMMON METHOD TO FIX NULL ISSUE
    private void ensureTestInitialized(ITestResult result) {

        if (test.get() == null) {

            ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
            test.set(extentTest);

            System.out.println("⚠️ ExtentTest was NULL, re-initialized for: "
                    + result.getMethod().getMethodName());
        }
    }
}