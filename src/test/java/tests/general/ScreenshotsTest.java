package tests.general;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenshotsTest extends BaseTest {
    @Test
    public void screenshotTest(){
        getDriver().get("https://www.google.com");
        getDriver().findElement(By.name("q")).sendKeys("selenium", Keys.ENTER);
        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a"),5));
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("./screenshots/random.png"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}