package roughPrac;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportTest {
    public static void main(String[] args) {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
        extent.attachReporter(spark);

        ExtentTest test = extent.createTest("TestName 1");
        test.info("step 1");
        test.info("step 2");
        test.info("step 3");
        test.pass("test passed!!");

        ExtentTest test2 = extent.createTest("Testname 2");
        test2.info("step 101");
        test2.info("step 201");
        test2.info("step 301");
        test2.fail("test2 passed!!");

        ExtentTest test3 = extent.createTest("Testname 3");
        test3.info("step 201");
        test3.info("step 202");
        test3.info("step 203");
        test3.skip("test3 passed!!");

        extent.flush();
    }
}