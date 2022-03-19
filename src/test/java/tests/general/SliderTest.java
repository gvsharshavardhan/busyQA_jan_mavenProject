package tests.general;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.time.Duration;

public class SliderTest extends BaseTest {
    @Test
    public void testSlider() {
        Actions actions = new Actions(getDriver());
        getDriver().navigate().to("http://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = getDriver().findElement(By.cssSelector("[type='range']"));
        WebElement range = getDriver().findElement(By.cssSelector("[id='range']"));

        while (Double.parseDouble(range.getText()) != 4) {
            Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
            actions.click(slider).sendKeys(Keys.ARROW_RIGHT).perform();
        }

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }
}
