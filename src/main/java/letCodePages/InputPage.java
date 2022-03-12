package letCodePages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputPage extends BasePage {


    public InputPage(WebDriver driver){
        super(driver);
    }

    By fullNameFieldId = By.id("fullName");
    By appendFieldId = By.id("join");
    By getMeFieldId = By.id("getMe");
    By clearMeFieldId = By.id("clearMe");
    By noEditFieldId = By.id("noEdit");
    By dontWriteFieldId = By.id("dontwrite");

    public void enterFullName(String fullName){
        driver.findElement(fullNameFieldId).sendKeys(fullName);
    }

    public void enterTextIntoAppendField(String text){
        driver.findElement(appendFieldId).sendKeys(text);
    }

    public void passTabKeyIntoAppendField(){
        driver.findElement(appendFieldId).sendKeys(Keys.TAB);
    }

    public String getTextFromGetMeField(){
        return driver.findElement(getMeFieldId).getAttribute("value");
    }

    public void clearTheTextFromClearMeField(){
        driver.findElement(clearMeFieldId).clear();
    }

    public String getTextFromClearMeField(){
       return driver.findElement(clearMeFieldId).getAttribute("value");
    }

    public boolean isEditFieldEnabled(){
        return driver.findElement(noEditFieldId).isEnabled();
    }

    public String getReadonlyStatusforFieldDontWrite(){
       return driver.findElement(dontWriteFieldId).getAttribute("readonly");
    }

    public String getReadOnlyStatusForClearField(){
        return driver.findElement(clearMeFieldId).getAttribute("readonly");
    }
    //renu - override
    //ishmeet - append

}
