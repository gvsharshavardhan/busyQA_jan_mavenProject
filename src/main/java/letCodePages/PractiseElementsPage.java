package letCodePages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PractiseElementsPage extends BasePage {

    public PractiseElementsPage(WebDriver driver) {
       super(driver);
    }

    String linkXpath = "//a[text()='$$']";

    public void clickOntheLink(String linktext){
        driver.findElement(By.xpath(linkXpath.replace("$$",linktext))).click();
    }

}