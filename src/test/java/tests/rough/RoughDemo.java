package tests.rough;

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

        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1"),"PHONES"));

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