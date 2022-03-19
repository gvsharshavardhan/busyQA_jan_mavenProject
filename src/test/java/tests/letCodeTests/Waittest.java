package tests.letCodeTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.time.Duration;

public class Waittest extends BaseTest {

    @Test
    public void alertTest(){
        getDriver().navigate().to("https://letcode.in/waits");
        getDriver().findElement(By.id("accept")).click();

        Alert alert = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
    }
}
