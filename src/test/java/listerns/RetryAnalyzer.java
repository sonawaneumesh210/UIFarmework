package listerns;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 2;

    public boolean isRetryAvailable() {
        return retryCount < maxRetryCount;
    }

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying: " + result.getName() + " Attempt: " + retryCount);
            return true;
        }
        return false;
    }
}