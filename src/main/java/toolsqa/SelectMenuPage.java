package toolsqa;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SelectMenuPage extends BasePage {

    public SelectMenuPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://demoqa.com/select-menu");
    }

    private final By oldStyleDropDown = By.cssSelector("#oldSelectMenu");
    private final By carsMultiSelect = By.cssSelector("#cars");

    public void selectFromOldStyleDropDown(String visibleText) {
        getoldDropDownSelect().selectByVisibleText(visibleText);
    }

    public String getSelectedValueFromTheOldStyleDropDown() {
        return getoldDropDownSelect().getFirstSelectedOption().getText();
    }

    public List<String> getAllOptionsFromTheDropDown(String name) {
        List<WebElement> options;
        if (name.equals("single")) {
            options = getoldDropDownSelect().getOptions();
        } else {
            options = getoldMultiDropDown().getOptions();
        }
        List<String> values = new ArrayList<>();
        for (WebElement option : options) {
            values.add(option.getText());
        }
        return values;
    }

    public Select getoldDropDownSelect() {
        WebElement dropdown = driver.findElement(oldStyleDropDown);
        return new Select(dropdown);
    }

    public Select getoldMultiDropDown() {
        WebElement dropdown = driver.findElement(carsMultiSelect);
        return new Select(dropdown);
    }

    public void selectOptionsFromMultiSelect(List<String> myoptions) {
        for (String option : myoptions) {
            getoldMultiDropDown().selectByVisibleText(option);
        }
    }

    public List<String> getSelectedOptionsFromMultiSelect() {
        List<WebElement> options = getoldMultiDropDown().getAllSelectedOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : options) {
            values.add(option.getText());
        }
        return values;
    }
}