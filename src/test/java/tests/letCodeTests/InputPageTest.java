package tests.letCodeTests;

import letCodePages.HomePage;
import letCodePages.InputPage;
import letCodePages.PractiseElementsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class InputPageTest extends BaseTest {


    @Test
    public void inputFieldTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();
        homePage.clickWorkSpaceButton();

        PractiseElementsPage practiseElementsPage = new PractiseElementsPage(getDriver());
        practiseElementsPage.clickOntheLink("Edit");

        InputPage inputPage = new InputPage(getDriver());
        inputPage.enterFullName("busyqa");

        inputPage.enterTextIntoAppendField("sunday");
        inputPage.passTabKeyIntoAppendField();

        String actualText = inputPage.getTextFromGetMeField();
        String expectedText = "ortonikc";

        Assert.assertEquals(actualText,expectedText,"text is not as expected!!!");


        String actualTextFromClearMeField = inputPage.getTextFromClearMeField();
        Assert.assertEquals(actualTextFromClearMeField,"Koushik Chatterjee","text is not as expected!!!");

        inputPage.clearTheTextFromClearMeField();

        actualTextFromClearMeField = inputPage.getTextFromClearMeField();
        Assert.assertEquals(actualTextFromClearMeField,"","text did not clear!!");

        boolean isEnabled = inputPage.isEditFieldEnabled();
        System.out.println(isEnabled);
        Assert.assertFalse(isEnabled, "field is not disabled!!!");

        String actualStatus = inputPage.getReadonlyStatusforFieldDontWrite();
        System.out.println("status:" + actualStatus+"$");
        Assert.assertTrue(actualStatus!=null,"it is not read only!!");

        System.out.println(inputPage.getReadOnlyStatusForClearField());
    }
}