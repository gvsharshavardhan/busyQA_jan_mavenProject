package tests.kitchen;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterTest
    public void teardown() {
        getDriver().quit();
    }

    @Test()
    public void alertTest1() {
        getDriver().get("https://kitchen.applitools.com/ingredients/alert");
        getDriver().findElement(By.cssSelector("#alert-button")).click();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        Alert alert = getDriver().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test()
    public void alertTest2() {
        getDriver().findElement(By.cssSelector("#confirm-button")).click();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        Alert alert = getDriver().switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        Assert.assertTrue(getDriver().findElement(By.cssSelector("#confirm-answer")).getText().contains("No"));
    }

    @Test()
    public void alertTest3() {
        getDriver().findElement(By.cssSelector("#prompt-button")).click();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        Alert alert = getDriver().switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Biryani");
        alert.accept();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Assert.assertTrue(getDriver().findElement(By.cssSelector("#prompt-answer")).getText().contains("Biryani"));
    }
}