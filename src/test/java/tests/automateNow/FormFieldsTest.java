package tests.automateNow;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

public class FormFieldsTest extends BaseTest {

    @Test
    public void forFieldsTest1(){
        driver.get("https://automatenow.io/sandbox-automation-testing-practice-website/form-fields/");
        driver.manage().window().maximize();
        driver.findElement(By.name("g1103-inputfield")).sendKeys("busyqa");
        driver.findElement(By.className("checkbox-multiple")).click();
    }
}