package tests.letCodeTests;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.time.Duration;

public class FrameTest extends BaseTest {

    @Test
    public void alertTest1() {
        getDriver().navigate().to("https://letcode.in/frame");

        By firstName = By.cssSelector("[placeholder='Enter name']");
        By lastName = By.cssSelector("[name='lname']");
        By email = By.cssSelector("[name='email']");

        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("#firstFr")));//outerframe
        getDriver().findElement(firstName).sendKeys("busyqa");
        getDriver().findElement(lastName).sendKeys("automation");

        //inenr frame
        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe.has-background-white")));
        getDriver().findElement(email).sendKeys("busyrandomqa@yahoo.com");

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }
}