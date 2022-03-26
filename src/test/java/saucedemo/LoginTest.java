package saucedemo;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        getDriver().get(PropertyUtil.getProperty("url"));
        ExtentUtil.getTest().info("logged in to " + PropertyUtil.getProperty("url"));
        getDriver().findElement(By.id("txtUsername")).sendKeys(PropertyUtil.getProperty("username"));
        ExtentUtil.getTest().info("entered username : " + PropertyUtil.getProperty("username"));
        getDriver().findElement(By.id("txtPassword"))
                .sendKeys(DecodeUtil.decodeBase64ToString(PropertyUtil.getProperty("password")));
        ExtentUtil.getTest().info("Entered password: " + PropertyUtil.getProperty("password"));
        getDriver().findElement(By.id("btnLogin")).click();
        ExtentUtil.getTest().info("clicked on login button");
        Assert.assertEquals(getDriver().findElement(By.tagName("h1")).getText().trim().toLowerCase(), "dashboard");
    }

    @Test
    public void loginSauceTest() {
        Map<String, List<String>> credentials = ExcelUtil.getCredentials();
        String username = credentials.get("usernames").get(0);
        String password = credentials.get("passwords").get(0);

        getDriver().get(PropertyUtil.getProperty("sauceurl"));

        getDriver().findElement(By.id("user-name")).sendKeys(username);
        getDriver().findElement(By.id("password"))
                .sendKeys(password);
        getDriver().findElement(By.id("login-button")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        Assert.assertEquals(getDriver().findElement(By.className("title")).getText().trim().toLowerCase(), "products");
    }

    @Test(dataProvider = "credentials", dataProviderClass = DataProviderUtil.class)
    public void loginSauceTest2(String username, String password) {
        getDriver().get(PropertyUtil.getProperty("sauceurl"));

        getDriver().findElement(By.id("user-name")).sendKeys(username);
        getDriver().findElement(By.id("password"))
                .sendKeys(password);
        getDriver().findElement(By.id("login-button")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        Assert.assertEquals(getDriver().findElement(By.className("title")).getText().trim().toLowerCase(), "products");
    }

//    @DataProvider(name = "credentials")
//    Object[][] dataPump() {
//
//        Map<String, List<String>> credentials = ExcelUtil.getCredentials();
//        List<String> usernames = credentials.get("usernames");
//        List<String> passwords = credentials.get("passwords");
//        String[][] data = new String[usernames.size()][credentials.size()];
//        for (int i = 0; i < usernames.size(); i++) {
//            data[i][0] = usernames.get(i);
//            data[i][1] = passwords.get(i);
//        }
//        return data;
//
////        return new String[][]{
////                {"standard_user", "secret_sauce"},
////                {"problem_user", "secret_sauce"},
////                {"performance_glitch_user", "secret_sauce"}
////        };
//    }
}