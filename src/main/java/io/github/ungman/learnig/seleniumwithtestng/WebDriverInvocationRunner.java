package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class WebDriverInvocationRunner {

    String driverPath = "D:\\WebDrivers\\chromedriver.exe";
    String driverName = "webdriver.chrome.driver";
    protected WebDriver webDriver;

    List<WebDriver> listDrivers = new ArrayList<>();

    @BeforeSuite
    public void setUp() {
        System.setProperty(driverName, driverPath);
    }

    @BeforeMethod
    public void initMethod() {

        
        webDriver = new ChromeDriver();
        listDrivers.add(webDriver);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void closeBrowse(WebDriver webDriver){
        webDriver.quit();
        listDrivers.remove(webDriver);
    }

    @AfterSuite
    public void exit() {
        for (WebDriver webDriver : listDrivers) {
            if (webDriver != null)
                webDriver.quit();
        }
    }

}
