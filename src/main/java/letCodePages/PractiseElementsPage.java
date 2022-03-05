package letCodePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PractiseElementsPage {

    WebDriver driver;

    public PractiseElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    String linkXpath = "//a[text()='$$']";

    public void clickOntheLink(String linktext){
        driver.findElement(By.xpath(linkXpath.replace("$$",linktext))).click();
    }

}
