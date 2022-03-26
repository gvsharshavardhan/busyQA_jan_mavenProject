package tests.general;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.time.Duration;

public class JavaScriptTest extends BaseTest {
    @Test
    public void javascriptTest() {
        getDriver().get("https://letcode.in/test");

        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,2000)");

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

        WebElement fileLink = getDriver().findElement(By.cssSelector("[href='/file']"));

        for(int i=0;i<5;i++) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", fileLink);
            Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(300));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border=''", fileLink);
            Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(300));
        }

        fileLink.click();
        Assert.assertEquals(getDriver().findElement(By.tagName("h1")).getText().trim(), "Input");
    }
}