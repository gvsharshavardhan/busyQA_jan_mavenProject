package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Optional;

public class DriverManager {
    private final static ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    public static void initDriver(){
        WebDriver driver;
        String browser = Optional.ofNullable(System.getProperty("browser")).orElse("chrome");

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
    }

    public static void quitDriver(){
        getDriver().quit();
    }

    public static WebDriver getDriver(){
        return tl.get();
    }

}
