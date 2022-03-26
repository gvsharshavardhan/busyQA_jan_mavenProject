package listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import driverManager.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentUtil;

public class MyListener implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult result) {
//create a extent test
        ExtentUtil.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
//close the test
        ExtentUtil.getTest().pass(result.getMethod().getMethodName() + "is passed!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
//close the test
        String screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        ExtentUtil.getTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
        ExtentUtil.getTest().fail(result.getMethod().getMethodName() + "is failed!!");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
//close the test
        ExtentUtil.getTest().skip(result.getMethod().getMethodName() + "is skipped!!");
    }

    @Override
    public void onStart(ISuite suite) {
        //create a report
        ExtentUtil.initReport(suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
//flush the report
        ExtentUtil.flushReport();
    }
}