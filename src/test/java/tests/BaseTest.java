package tests;

import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    @BeforeMethod
    protected void setupBrowser() {
        DriverManager.initDriver();
        getDriver().manage().window().maximize();
    }

    @AfterMethod
    protected void quitBrowser() {
        DriverManager.quitDriver();
    }
}