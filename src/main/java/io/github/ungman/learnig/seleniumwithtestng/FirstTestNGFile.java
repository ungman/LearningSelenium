package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTestNGFile {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "D:\\WebDrivers\\chromedriver.exe";
    public WebDriver webDriver;
    public String expected = null;
    public String actual = null;

    @BeforeTest
    public void launchBrowser() {
        System.out.println("launching firefox browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        webDriver = new ChromeDriver();
        webDriver.get(baseUrl);
    }

    @BeforeMethod
    public void verifyHomepageTitle() {
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = webDriver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 0)
    public void register() {
        webDriver.findElement(By.linkText("REGISTER")).click();
        expected = "Register: Mercury Tours";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void support() {
        webDriver.findElement(By.linkText("SUPPORT")).click();
        expected = "Under Construction: Mercury Tours";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void goBackToHomepage() {
        webDriver.findElement(By.linkText("Home")).click();
    }

    @AfterTest
    public void terminateBrowser() {
        webDriver.close();
    }
}
