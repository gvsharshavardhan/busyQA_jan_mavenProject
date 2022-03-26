package tests.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksTest extends BaseTest {
    @Test
    public void brokenLinkTest() throws IOException {
        getDriver().get("http://leafground.com/pages/Link.html#");
        List<WebElement> links = getDriver().findElements(By.xpath("//a"));

        for (WebElement link : links) {
            String url_string = link.getAttribute("href");
            URL url = new URL(url_string);
            HttpURLConnection httpurlConnection = (HttpURLConnection) url.openConnection();
            httpurlConnection.connect();
            if (httpurlConnection.getResponseCode() >= 400) {
                System.out.println(url_string + " is broken!");
            }
        }
    }

    @Test
    public void brokenImagesTest() throws IOException {
        getDriver().get("http://leafground.com/pages/Image.html");
        List<WebElement> links = getDriver().findElements(By.xpath("//img"));

        for (WebElement link : links) {
            String url_string = link.getAttribute("src");
            URL url = new URL(url_string);
            HttpURLConnection httpurlConnection = (HttpURLConnection) url.openConnection();
            httpurlConnection.connect();
            if (httpurlConnection.getResponseCode() >= 400) {
                System.out.println(url_string + " is broken!");
            }
        }
    }
}