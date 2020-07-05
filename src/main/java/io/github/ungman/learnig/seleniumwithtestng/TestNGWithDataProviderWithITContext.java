package io.github.ungman.learnig.seleniumwithtestng;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestNGWithDataProviderWithITContext {

    /*
    Check why dont call method with annotations?
     */

    String driverPath = "D:\\WebDrivers\\chromedriver.exe";
    String driverName = "webdriver.chrome.driver";
    WebDriver webDriver;

    List<WebDriver> listDrivers = new ArrayList<>();

    @BeforeSuite
    public void setUp() {
        System.setProperty(driverName, driverPath);
    }

    @BeforeMethod
    public void initMethod() {
        System.out.println("Init method?");
        webDriver = new ChromeDriver();
        listDrivers.add(webDriver);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @SneakyThrows
    @Test(dataProvider = "SearchProvider", groups = "A")
    public void testGroupA(String author, String searchKey) {
        testGoogle(author, searchKey);
    }

    @SneakyThrows
    @Test(dataProvider = "SearchProvider", groups = "B")
    public void testGroupB(String searchKey) {
        testGoogle("Empty author", searchKey);
    }

    private void testGoogle(String author, String searchKey) throws InterruptedException {
        System.setProperty(driverName, driverPath);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://google.com");
        WebElement searchText = webDriver.findElement(By.name("q"));
        searchText.clear();
        searchText.sendKeys(searchKey);
        System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
        System.out.println("Thread will sleep now");
        Thread.sleep(3000);
        System.out.println("Value in Google Search Box = " + searchText.getAttribute("value") + " ::: Value given by input = " + searchKey);
        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
        webDriver.quit();
    }

    @AfterSuite
    public void exit() {
        for (WebDriver webDriver : listDrivers) {
            webDriver.quit();
        }
    }

    @DataProvider(name = "SearchProvider")
    public Object[][] getDataFromDataProvider(ITestContext c) {
        Object[][] groupArray = null;
        for (String group : c.getIncludedGroups()) {
            if (group.equalsIgnoreCase("A")) {
                groupArray = new Object[][]{
                        {"Guru99", "India"},
                        {"Krishna", "UK"},
                        {"Bhupesh", "USA"}
                };
                break;
            } else if (group.equalsIgnoreCase("B")) {
                groupArray = new Object[][]{
                        {"Canada"},
                        {"Russia"},
                        {"Japan"}
                };
            }
            break;
        }
        return groupArray;
    }
}
