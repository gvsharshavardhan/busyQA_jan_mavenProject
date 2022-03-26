package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentUtil {
    static ExtentReports extent;
    static ExtentTest test;

    public static void initReport(String suiteName) {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/login.html");
        spark.config().setReportName(suiteName);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Regression Suite");

        extent.attachReporter(spark);
    }

    public static void flushReport() {
        extent.flush();
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static ExtentTest getTest(){
        return test;
    }
}