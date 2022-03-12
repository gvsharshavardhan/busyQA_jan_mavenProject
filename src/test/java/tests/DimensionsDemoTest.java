package tests;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

public class DimensionsDemoTest extends BaseTest {
    @Test
    void testDimension() {
        getDriver().get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.1.1");
        //to specify the dimension of the window
        Dimension d = new Dimension(450, 500);
        getDriver().manage().window().setSize(d);
    }

    @Test
    void testMaximize() {
        //maximizes the window
        getDriver().manage().window().maximize();
        getDriver().get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.1.1");
    }
}