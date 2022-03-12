package tests.letCodeTests;

import com.google.common.util.concurrent.Uninterruptibles;
import letCodePages.ButtonPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.time.Duration;

public class ButtonPageTest extends BaseTest {

    @Test
    public void buttonTest1() {
        ButtonPage buttonPage = new ButtonPage(getDriver());
        buttonPage.clickOnHomeButton();
        String expectedHomePageTitle = "LetCode with Koushik";
        Assert.assertEquals(buttonPage.getThePageTitle(), expectedHomePageTitle, "home page button did not take us to homepage!!");

        //alternative to Thread.sleep()
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

        buttonPage.navigateBack();
        Assert.assertEquals("Interact with Button fields", buttonPage.getThePageTitle(), "did not navigateBack to button page!!");
    }

    @Test
    public void buttonTest2() {
        ButtonPage buttonPage = new ButtonPage(getDriver());
        System.out.println(buttonPage.getPositionOfPositionButton());
        System.out.println(buttonPage.getColorOfColorButton());
        System.out.println(buttonPage.getHeightAndWidthOfSizeButton());
        System.out.println(buttonPage.isButtonEnabled());//false

        System.out.println("before loong press: " + buttonPage.getTextFromLongPressButton());
        buttonPage.clickAndHoldLongPressButton();
        System.out.println("after loong press: " + buttonPage.getTextFromLongPressButton());

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }


}