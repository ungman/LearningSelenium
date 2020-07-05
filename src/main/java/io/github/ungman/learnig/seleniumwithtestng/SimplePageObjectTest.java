package io.github.ungman.learnig.seleniumwithtestng;

import io.github.ungman.learnig.seleniumwithtestng.page.Guru99HomePage;
import io.github.ungman.learnig.seleniumwithtestng.page.Guru99LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimplePageObjectTest {

    String driverPath = "D:\\WebDrivers\\chromedriver.exe";
    String driverName = "webdriver.chrome.driver";
    WebDriver webDriver;
    Guru99LoginPage guru99LoginPage;
    Guru99HomePage guru99HomePage;
    String baseUrl = "http://demo.guru99.com/V4/";
    private final String username = "mngr265657";
    private final String password = "uveruja";

    @BeforeTest
    public void setUp() {
        System.setProperty(driverName, driverPath);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(baseUrl);
    }

    @Test
    public void testHomePageAppearCorrect() {
        guru99LoginPage = new Guru99LoginPage(webDriver);
        String actualTitle = guru99LoginPage.getLoginTitle();
        String expectedTitle = "guru99 bank";
        Assert.assertTrue(actualTitle.toLowerCase().contains(expectedTitle));
        guru99LoginPage.loginToGuru99(username, password);

        guru99HomePage = new Guru99HomePage(webDriver);
        Assert.assertTrue(guru99HomePage.getHomePageDashboardUsername().toLowerCase().contains("manger id : " + username));
    }

    @AfterTest
    public void exit(){
        webDriver.quit();
    }
}
