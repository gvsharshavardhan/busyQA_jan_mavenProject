package letCodePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
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