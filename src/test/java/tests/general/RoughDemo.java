package tests.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.time.Duration;
import java.util.List;


public class RoughDemo extends BaseTest {

    @Test
    public void fidoMobileTest() {
        getDriver().get("https://www.fido.ca/phones/");
        //
        //drawbacks:
        //1. no specific time
        //2sec - 3sec
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //implicit wait


        WebElement header = new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        System.out.println(header.getText());

        String[] phoneNames = {"motorola edge+", "iPhone 7", "iPhone SE","Samsung Galaxy S20 FE 5G"};

        String dynamicXpath = "//p[text()='$$']/ancestor::div[@class='dsa-nacTile__top']" +
                "/following-sibling::div[contains(@class,'deviceInfo')]//p[contains(@class,'text-semi')]";

        for (String name : phoneNames) {
            String priceXpath = dynamicXpath.replace("$$", name);
            List<WebElement> phoneElements = getDriver().findElements(By.xpath(priceXpath));
            for(WebElement ele:phoneElements){
                System.out.println(name+ "\t :: \t" + ele.getText());
            }
        }
    }
}