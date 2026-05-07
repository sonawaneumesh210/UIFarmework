package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport_" + timeStamp + ".html");

            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Selenium TestNG Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Nitin");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}