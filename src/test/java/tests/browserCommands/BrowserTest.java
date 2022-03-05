package tests.browserCommands;

import org.testng.annotations.Test;
import tests.BaseTest;

public class BrowserTest extends BaseTest {

    @Test
    public void broswerCommandsTest(){
        driver.navigate().to("https://www.amazon.com/ref=nav_logo");
        System.out.println("title: \n"+driver.getTitle());
        System.out.println("url: \n"+driver.getCurrentUrl());
        System.out.println("page source: \n" + driver.getPageSource());
    }
}
