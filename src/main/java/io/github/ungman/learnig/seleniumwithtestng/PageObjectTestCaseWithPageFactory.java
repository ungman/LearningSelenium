package io.github.ungman.learnig.seleniumwithtestng;

import io.github.ungman.learnig.seleniumwithtestng.page.Guru99HomePageWithPageFactory;
import io.github.ungman.learnig.seleniumwithtestng.page.Guru99LoginPageWithPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageObjectTestCaseWithPageFactory {

    String driverPath = "D:\\WebDrivers\\chromedriver.exe";
    String driverName = "webdriver.chrome.driver";
    WebDriver webDriver;
    Guru99LoginPageWithPageFactory guru99LoginPage;
    Guru99HomePageWithPageFactory guru99HomePage;
    String baseUrl = "http://demo.guru99.com/V4/";
    private final String username = "mngr265657";
    private final String password = "uveruja";

    @BeforeTest
    public void setup() {
        System.setProperty(driverName, driverPath);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(baseUrl);
    }

    @Test(priority = 0)
    public void testHomePageAppearCorrect() {
        guru99LoginPage = new Guru99LoginPageWithPageFactory(webDriver);
        String loginPageTitle = guru99LoginPage.getPageTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        guru99LoginPage.loginToGuru99("mgr123", "mgr!23");
        guru99HomePage = new Guru99HomePageWithPageFactory(webDriver);
        Assert.assertTrue(guru99HomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }

    @AfterTest
    public void exit() {
        webDriver.quit();
    }

}
