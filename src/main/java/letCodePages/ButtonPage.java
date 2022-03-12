package letCodePages;

import base.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ButtonPage extends BasePage {


    public ButtonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver.get("https://letcode.in/buttons");
    }

    @FindBy(id = "home")
    WebElement homeButton;

    @FindBy(id = "position")
    WebElement positionButton;

    @FindBy(id = "color")
    WebElement colorButton;

    @FindBy(id = "property")
    WebElement sizeButton;

    @FindBy(css = "#isDisabled.is-info")
    WebElement disabledButton;

    @FindBy(xpath = "//button[@class='button is-primary' and @id='isDisabled']")
    WebElement longPressButton;

    public void clickOnHomeButton() {
        homeButton.click();
    }

    public String getPositionOfPositionButton() {
        Point point = positionButton.getLocation();
        return "X:" + point.getX() + "\tY: " + point.getY();
    }

    public String getColorOfColorButton() {
        return colorButton.getCssValue("background-color");
    }

    public String getHeightAndWidthOfSizeButton() {
        Dimension dimension = sizeButton.getSize();
        return "Height: " + dimension.getHeight() + "\tWidth: " + dimension.getWidth();
    }

    public boolean isButtonEnabled() {
        return disabledButton.isEnabled();
    }

    public void clickAndHoldLongPressButton() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(longPressButton).pause(Duration.ofSeconds(2)).perform();
    }

    public String getTextFromLongPressButton() {
        return longPressButton.getText().trim();
    }
}