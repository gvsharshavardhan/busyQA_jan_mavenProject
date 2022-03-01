package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NavigationCommandsDemoTest extends BaseTest {


    @Test
    void testNavigateTo() {
        //driver.get()
        driver.navigate().to("https://www.selenium.dev/");

        driver.manage().window().maximize();
        String homepagetitle = driver.getTitle();

        driver.findElement(By.xpath("//a[@href='/downloads']")).click();
        String downloadsPageTitle = driver.getTitle();
        System.out.println("After clicking on downloads link: " + downloadsPageTitle);

        driver.navigate().back();
        String title = driver.getTitle();

        if (homepagetitle.equals(title)) {
            System.out.println("passed!!");
        } else {
            System.out.println("Failed!!");
            throw new RuntimeException("title is not as expected after navigating back to homepage!!");
        }
    }
}