package io.github.ungman.learnig.selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GeckoMarionette {
    String driverPath = "D:\\Guru99Demo\\GeckoDriver.exe";
    public WebDriver driver;

    @BeforeMethod
    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver", driverPath);
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver();
    }
    @Test
    public void navigateToUrl() {
        driver.get("http://demo.guru99.com/selenium/guru99home/");
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}
