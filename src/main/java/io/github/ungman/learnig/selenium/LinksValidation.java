package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinksValidation {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
//            testFindBrokenLink();
            testGetAllLinks();
        } finally {
            System.exit(0);
        }
    }

    private static void testFindBrokenLink() {
        WebDriver webDriver = new ChromeDriver();
        try {
//            String homePage = "http://demo.guru99.com/test/web-table-element.php";
            String homePage = "https://www.zlti.com";
            String url = "";
            HttpURLConnection httpURLConnection = null;
            int responseCode = 200;
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            webDriver.get(homePage);
            List<WebElement> listLinks = webDriver.findElements(By.tagName("a"));
            for (WebElement listLink : listLinks) {
                url = listLink.getAttribute("href");
                System.out.println("url link: " + url);
                if (url == null || url.isEmpty()) {
                    System.out.println("URL is either not configured for anchor tag or it is empty");
                    continue;
                }
                if (!url.startsWith(homePage)) {
                    System.out.println("URL belongs to another domain, skipping it.");
                    continue;
                }
                try {
                    httpURLConnection = (HttpURLConnection) (new URL(url).openConnection());
                    httpURLConnection.setRequestMethod("HEAD");
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode >= 400) {
                        System.out.println(url + " this a broken link");
                    } else {
                        System.out.println(url + " this a valid  link");
                    }
                } catch (MalformedURLException e) {
                    System.out.println("Cant open url: " + url + "; Cause: " + e.getMessage());
//
                } catch (IOException e) {
                    System.out.println("Cant open url: " + url + "; Cause: " + e.getMessage());
                }
            }
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void testGetAllLinks() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/newtours/";
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            webDriver.get(baseUrl);
            List<WebElement> linkElements = webDriver.findElements(By.tagName("a"));
            String underConsTitle = "Under Construction: Mercury Tours";
            for (WebElement linkElement : linkElements) {
                System.out.println(linkElement);
                if (linkElement.getAttribute("href").startsWith("https")) {
                    continue;
                }
                linkElement.click();
                String linkText = linkElement.getText();
                if (webDriver.getTitle().equals(underConsTitle)) {
                    System.out.println("\"" + linkText + "\"" + " is under construction.");
                } else {
                    System.out.println("\"" + linkText + "\"" + " is working.");
                }
                webDriver.navigate().back();
            }
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }
}
