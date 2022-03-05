package tests.xpathsdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class XpathTest extends BaseTest {
    String url = "http://omayo.blogspot.com/";

    @Test
    public void checkTheCountOfPracticeSitesTest() {
        //AAA
        //arrange -> test data that is required for our test
        By linkElementsXpath = By.xpath("//h2[text()='Other Sites to Practice Automation']/following-sibling::div//a");
        int expectedCount = 5;

        //ACT -> perform required actions
        driver.get(url);
        List<WebElement> linkElements = driver.findElements(linkElementsXpath);
        List<String> linkTexts = new ArrayList<>();
        List<String> linkUrls = new ArrayList<>();
        for (WebElement element : linkElements) {
            linkTexts.add(element.getText());
            linkUrls.add(element.getAttribute("href"));
            System.out.println(element.getText() + "\t ::\t" + element.getAttribute("href"));
        }

        //Assert -> validations point
        Assert.assertEquals(linkTexts.size(), expectedCount, "Actual sites count is not matching with the expected count!!");
    }


    @Test
    public void exceptionTest() {
        driver.get(url);
        WebElement linkElement = driver.findElement(By.xpath("(//input[@class='classone'])[1]"));
        //xyz123
        linkElement.sendKeys("selenium");

        driver.navigate().refresh();


        linkElement = driver.findElement(By.xpath("(//input[@class='classone'])[1]"));
        linkElement.sendKeys("selenium");
        // do i get same id in both the cases?
        //different -> gopika, ishmeet
    }

    @Test
    public void findElementsTest() {
        driver.get("http://leafground.com/home.html");
        List<WebElement> headers = driver.findElements(By.tagName("h8"));
        System.out.println(headers.size());
        for (WebElement ele : headers) {
            System.out.println(ele.getText());
        }
    }
}