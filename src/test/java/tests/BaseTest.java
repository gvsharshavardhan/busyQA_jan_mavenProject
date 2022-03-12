package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Optional;

public class BaseTest {

    //saviour
    private final ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return tl.get();
    }

    @BeforeMethod
    protected void setupBrowser() {
//        String browser;
        WebDriver driver;
        String browser = Optional.ofNullable(System.getProperty("browser")).orElse("edge");

        if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            tl.set(driver);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            tl.set(driver);
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            tl.set(driver);
        }

        getDriver().manage().window().maximize();
    }

    @AfterMethod
    protected void quitBrowser() {
        getDriver().quit();
    }
}