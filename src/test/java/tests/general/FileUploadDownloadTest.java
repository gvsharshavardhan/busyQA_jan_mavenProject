package tests.general;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.time.Duration;

public class FileUploadDownloadTest extends BaseTest {
    @Test
    public void fileUploadTest(){
        getDriver().get("https://kitchen.applitools.com/ingredients/file-picker");
        Assert.assertTrue(getDriver().findElements(By.xpath("//figure")).size()==0);
        getDriver().findElement(By.id("photo-upload")).sendKeys("C:\\Users\\Harsha\\canada_automation_prep\\busyQA_jan_mavenProject\\screenshots\\random.png");

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        Assert.assertTrue(getDriver().findElements(By.xpath("//figure")).size()>0);

        String uploadedfilename = getDriver().findElement(By.id("photo-upload")).getAttribute("value");
        System.out.println(uploadedfilename);
        Assert.assertTrue(uploadedfilename.contains("random.png"));
    }
}