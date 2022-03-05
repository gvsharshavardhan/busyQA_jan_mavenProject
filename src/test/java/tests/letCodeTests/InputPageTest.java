package tests.letCodeTests;

import letCodePages.HomePage;
import letCodePages.InputPage;
import letCodePages.PractiseElementsPage;
import org.testng.annotations.Test;
import tests.BaseTest;

public class InputPageTest extends BaseTest {


    @Test
    public void inputFieldTest() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        homePage.clickWorkSpaceButton();

        PractiseElementsPage practiseElementsPage = new PractiseElementsPage(driver);
        practiseElementsPage.clickOntheLink("Edit");

        InputPage inputPage = new InputPage(driver);
        inputPage.enterFullName("busyqa");
    }
}