package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGGroup {

    /*

    Access details to demo site.
User ID :	mngr265657
Password :	uveruja
This access is valid only for 20 days
     */
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
    }

    private final WebDriver webDriver = new ChromeDriver();
    private final String driverPath = "D:\\WebDrivers\\chromedriver.exe";
    private final String driverName = "webdriver.chrome.driver";
    private final String launchPageHeading = "//h3[text()='Guru99 Bank']";
    private final String userName_element = "/html/body/form/table/tbody/tr[1]/td[2]/input";
    private final String password_element = "/html/body/form/table/tbody/tr[2]/td[2]/input";
    private final String signIn_element = "/html/body/form/table/tbody/tr[3]/td[2]/input[1]";
    private final String userName_value = "mngr265657";
    private final String password_value = "uveruja";
    private final String managerID = "//td[contains(text(),'Manger Id')]";
    private final String newCustomer = "//a[@href='addcustomerpage.php']";
    private final String fundTransfer = "//a[@href='FundTransInput.php']";

    @BeforeClass
    public void initClass() {

    }

    @Test(groups = {"bonding", "strong_ties"})
    public void tc01LaunchURL() {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("http://www.demo.guru99.com/V4/");
    }

    @Test(groups = {"bonding"})
    public void tc02VerifyLaunchPage() {
        Assert.assertTrue(webDriver.findElement(By.xpath(launchPageHeading)).isDisplayed(),
                "Home Page heading is not displayed");
        System.out.println("Home Page heading is displayed");
    }

    @Test(groups = {"bonding", "strong_ties"})
    public void tc03EnterCredentials() {
        webDriver.findElement(By.xpath(userName_element)).sendKeys(userName_value);
        webDriver.findElement(By.xpath(password_element)).sendKeys(password_value);
        webDriver.findElement(By.xpath(signIn_element)).click();
    }

    @Test(groups = {"strong_ties"})
    public void tc04VerifyLoggedInPage() {
        Assert.assertTrue(webDriver.findElement(By.xpath(managerID)).isDisplayed(),
                "Manager ID label is not displayed");
        System.out.println("Manger Id label is displayed");
    }

    @Test(groups = {"bonding"})
    public void tc05VerifyHyperlinks() {
        Assert.assertTrue(webDriver.findElement(By.xpath(newCustomer)).isEnabled(),
                "New customer hyperlink is not displayed");
        System.out.println("New customer hyperlink is displayed");

        Assert.assertTrue(webDriver.findElement(By.xpath(fundTransfer)).isEnabled(),
                "Fund Transfer hyperlink is not displayed");
        System.out.println("Fund Transfer hyperlink is displayed");
    }

    @AfterClass
    public void deconstructor() {
        webDriver.quit();
    }

}
