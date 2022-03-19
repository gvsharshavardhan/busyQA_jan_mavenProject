package tests.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

public class JavaFrameTest extends BaseTest {

    @Test
    public void javaFrameTest() {
        getDriver().get("https://docs.oracle.com/javase/7/docs/api/");


        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//frame[@name='packageListFrame']")));
        List<WebElement> packages = getDriver().findElements(By.xpath("(//a[@target='packageFrame'])[position()<6]"));
        System.out.println("************************ Packages: *********************");
        for (WebElement pkg : packages) {
            System.out.println(pkg.getText());
        }
        getDriver().switchTo().parentFrame();
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//frame[@name='packageFrame']")));
        List<WebElement> classes = getDriver().findElements(By.xpath("(//a[@target='classFrame'])[position()<6]"));
        System.out.println("************************ classes: *********************");
        for (WebElement cls : classes) {
            System.out.println(cls.getText());
        }

        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//frame[@name='classFrame']")));
        List<WebElement> elements = getDriver().findElements(By.xpath("//a[@target='_top']"));
        System.out.println("************************ elements: *********************");
        for (WebElement ele : elements) {
            System.out.println(ele.getText());
        }
    }
}