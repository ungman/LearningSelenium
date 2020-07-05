package io.github.ungman.learnig.seleniumwithtestng;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNWithAnnParameters {
    String driverPath = "D:\\WebDrivers\\chromedriver.exe";
    String driverName = "webdriver.chrome.driver";
    WebDriver webDriver;

    List<WebDriver> listDrivers = new ArrayList<>();

    @BeforeTest
    public void setUp() {
        System.setProperty(driverName, driverPath);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void initMethod() {
        webDriver = new ChromeDriver();
        listDrivers.add(webDriver);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @SneakyThrows
    @Test
    public void testNoParameter() {
        String author = "guru99";
        String searchKey = "india";
        webDriver.get("https://google.com");
        WebElement searchText = webDriver.findElement(By.name("q"));
        searchText.clear();
        searchText.sendKeys(searchKey);
        System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
        System.out.println("Thread will sleep now");
        Thread.sleep(3000);
        System.out.println("Value in Google Search Box = " + searchText.getAttribute("value") + " ::: Value given by input = " + searchKey);
        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
    }

    @SneakyThrows
    @Test
    @Parameters({"author","searchKey"})
    public void testParametersWithXml(@Optional("Abc") String author,String searchKey){
        webDriver.get("https://google.com");
        WebElement searchText = webDriver.findElement(By.name("q"));
        searchText.clear();
        searchText.sendKeys(searchKey);
        System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
        System.out.println("Thread will sleep now");
        Thread.sleep(3000);
        System.out.println("Value in Google Search Box = " + searchText.getAttribute("value") + " ::: Value given by input = " + searchKey);
        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
    }

        @AfterTest
        public void exit() {
            for (WebDriver webDriver : listDrivers) {
                webDriver.quit();
            }
        }
}
