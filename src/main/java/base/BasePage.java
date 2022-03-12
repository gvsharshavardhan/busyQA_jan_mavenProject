package base;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateBack(){
        driver.navigate().back();
    }

    public String getThePageTitle(){
        return driver.getTitle();
    }
}