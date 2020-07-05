package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class TestNGListenerCase {

    WebDriver driver;

    @BeforeClass
    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    // Test to pass as to verify listeners .
    @Test
    public void Login() {
        driver.get("http://demo.guru99.com/V4/");
        driver.findElement(By.name("uid")).sendKeys("mngr34926");
        driver.findElement(By.name("password")).sendKeys("amUpenu");
        driver.findElement(By.name("btnLogin")).click();
    }

    // Forcefully failed this test as to verify listener.
    @Test
    public void TestToFail() {
        System.out.println("This method to test fail");
        Assert.assertTrue(false);
    }

    @AfterClass
    public void deconstruct() {
        driver.quit();
    }
}
