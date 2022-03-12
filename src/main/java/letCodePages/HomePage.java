package letCodePages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    private String workSpaceButtonXpath = "//a[text()='Explore Workspace']";
    private String url =  "https://letcode.in/";


    public void navigateToHomePage(){
        driver.get(url);
    }

    public void clickWorkSpaceButton() {
        driver.findElement(By.xpath(workSpaceButtonXpath)).click();
    }
}