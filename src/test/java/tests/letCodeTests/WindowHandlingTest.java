package tests.letCodeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;
import java.util.Set;

public class WindowHandlingTest extends BaseTest {
    @Test
    public void windowTest() {
        getDriver().get("https://letcode.in/windows");
        String parentWindow = getDriver().getWindowHandle();

        getDriver().findElement(By.id("home")).click();
        Set<String> windows = getDriver().getWindowHandles();
        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                getDriver().switchTo().window(window);
            }
        }

        getDriver().findElements(By.cssSelector("p.card-header-title"))
                .stream()
                .forEach(ele -> System.out.println(ele.getText()));

    }

    @Test
    public void windowTest2() {
        getDriver().get("https://letcode.in/windows");
        String parentWindow = getDriver().getWindowHandle();

        getDriver().findElement(By.id("multi")).click();
        Set<String> windows = getDriver().getWindowHandles();
        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                getDriver().switchTo().window(window);
                String url = getDriver().getCurrentUrl();
                if (url.contains("alert")) {
                    System.out.println("************* alert *****************");
                    getDriver().findElements(By.tagName("button"))
                            .stream()//java8
                            .forEach(btn -> System.out.println(btn.getText()));
                } else if (url.contains("dropdowns")) {
                    System.out.println("************* dropdown *****************");
                    List<WebElement> dropdowns = getDriver().findElements(By.tagName("select"));
                    for(WebElement dropdown:dropdowns){
                        System.out.println(dropdown.getAttribute("id"));
                    }
                }
            }
        }
    }
}