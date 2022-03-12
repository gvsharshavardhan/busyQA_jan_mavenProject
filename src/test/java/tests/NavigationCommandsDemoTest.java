package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NavigationCommandsDemoTest extends BaseTest {


    @Test
    void testNavigateTo() {
        //getDriver().get()
        getDriver().navigate().to("https://www.selenium.dev/");

        getDriver().manage().window().maximize();
        String homepagetitle = getDriver().getTitle();

        getDriver().findElement(By.xpath("//a[@href='/downloads']")).click();
        String downloadsPageTitle = getDriver().getTitle();
        System.out.println("After clicking on downloads link: " + downloadsPageTitle);

        getDriver().navigate().back();
        String title = getDriver().getTitle();

        if (homepagetitle.equals(title)) {
            System.out.println("passed!!");
        } else {
            System.out.println("Failed!!");
            throw new RuntimeException("title is not as expected after navigating back to homepage!!");
        }
    }
}