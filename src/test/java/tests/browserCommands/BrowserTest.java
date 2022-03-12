package tests.browserCommands;

import org.testng.annotations.Test;
import tests.BaseTest;

public class BrowserTest extends BaseTest {

    @Test
    public void broswerCommandsTest(){
        getDriver().navigate().to("https://www.amazon.com/ref=nav_logo");
        System.out.println("title: \n"+getDriver().getTitle());
        System.out.println("url: \n"+getDriver().getCurrentUrl());
        System.out.println("page source: \n" + getDriver().getPageSource());
    }
}
