package io.github.ungman.learnig.seleniumwithtestng;

import io.github.ungman.learnig.seleniumwithtestng.dataprovider.SearchDataProvider;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNGWithDataProvider {
    String driverPath = "D:\\WebDrivers\\chromedriver.exe";
    String driverName = "webdriver.chrome.driver";
    WebDriver webDriver;

    List<WebDriver> listDrivers = new ArrayList<>();

    @BeforeTest
    public void setUp() {
        System.setProperty(driverName, driverPath);
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
        testGoogle(author, searchKey);
    }

    private void testGoogle(String author, String searchKey) throws InterruptedException {
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
    @Test(dataProvider = "SearchProvider")
    public void testWithDataProvider(String author, String searchKey) {
        testGoogle(author, searchKey);
    }


    @SneakyThrows
    @Test(dataProvider = "SearchProvider",dataProviderClass = SearchDataProvider.class)
    public void testWithDataProviderClass(String author, String searchKey) {
        testGoogle(author, searchKey);
    }

    @SneakyThrows
    @Test(dataProvider = "SearchProviderWithParam")
    public  void testMethodWith2Param(String author, String searchKey){
        testGoogle(author, searchKey);
    }

    @SneakyThrows
    @Test(dataProvider="SearchProviderWithParam")
    public void testMethodWith1Param(String searchKey) {
        testGoogle("LOOOOL",searchKey);
    }

    @AfterTest
    public void exit() {
        for (WebDriver webDriver : listDrivers) {
            webDriver.quit();
        }
    }

    @DataProvider(name = "SearchProvider")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]
                {
                        {"Guru99", "India"},
                        {"Krishna", "UK"},
                        {"Bhupesh", "USA"}
                };

    }


    @DataProvider(name="SearchProviderWithParam")
    public Object[][] getDataFromDataprovider(Method m){
        if(m.getName().equalsIgnoreCase("testMethodA")){
            return new Object[][] {
                    { "Guru99", "India" },
                    { "Krishna", "UK" },
                    { "Bhupesh", "USA" }
            };}
        else{
            return new Object[][] {
                    { "Canada" },
                    { "Russia" },
                    { "Japan" }
            };}
    }

}
