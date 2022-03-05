package letCodePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputPage {

    WebDriver driver;

    public InputPage(WebDriver driver){
        this.driver = driver;
    }

    By fullNameFieldId = By.id("fullName");

    public void enterFullName(String fullName){
        driver.findElement(fullNameFieldId).sendKeys(fullName);
    }
}
