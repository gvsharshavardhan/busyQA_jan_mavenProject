package tests.automateNow;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

public class FormFieldsTest extends BaseTest {

    @Test
    public void forFieldsTest1(){
        getDriver().get("https://automatenow.io/sandbox-automation-testing-practice-website/form-fields/");
        getDriver().manage().window().maximize();
        getDriver().findElement(By.name("g1103-inputfield")).sendKeys("busyqa");
        getDriver().findElement(By.className("checkbox-multiple")).click();
    }
}