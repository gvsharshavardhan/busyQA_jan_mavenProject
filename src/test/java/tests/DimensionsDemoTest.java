package tests;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

public class DimensionsDemoTest extends BaseTest {
    @Test
    void testDimension() {
        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.1.1");
        //to specify the dimension of the window
        Dimension d = new Dimension(450, 500);
        driver.manage().window().setSize(d);
    }

    @Test
    void testMaximize() {
        //maximizes the window
        driver.manage().window().maximize();
        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.1.1");
    }
}