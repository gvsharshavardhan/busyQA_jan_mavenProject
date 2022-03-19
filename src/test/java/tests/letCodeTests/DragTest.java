package tests.letCodeTests;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.time.Duration;

public class DragTest extends BaseTest {

    @Test
    public void dragTest() {
        getDriver().navigate().to("https://letcode.in/draggable");
        Actions actions = new Actions(getDriver());

        WebElement draggable = getDriver().findElement(By.id("sample-box"));
        actions.dragAndDropBy(draggable, 70, 70).perform();
//        actions.clickAndHold(draggable).moveByOffset(180,180).build().perform();

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));


        //#sample-box
    }

    //https://letcode.in/dropable
    @Test
    public void dragTest2() {
        getDriver().navigate().to("https://letcode.in/dropable");
        Actions actions = new Actions(getDriver());

        WebElement draggable = getDriver().findElement(By.id("draggable"));
        WebElement dropable = getDriver().findElement(By.id("droppable"));
        actions.dragAndDrop(draggable, dropable).perform();
//        actions.clickAndHold(draggable).moveByOffset(180,180).build().perform();

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        //#sample-box
    }
}