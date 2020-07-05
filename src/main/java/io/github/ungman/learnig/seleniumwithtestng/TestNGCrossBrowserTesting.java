package io.github.ungman.learnig.seleniumwithtestng;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGCrossBrowserTesting {
    //create Edge instance
    WebDriver webDriver ;
    String name = "Null";

    @SneakyThrows
    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) {
        String path = "D:\\WebDrivers";
        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", path + "\\geckodriver.exe");
            webDriver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", path + "\\chromedriver.exe");
            //create chrome instance
            webDriver = new ChromeDriver();
        }
        //Check if parameter passed as 'Edge'
        else if (browser.equalsIgnoreCase("Edge")) {
            //set path to Edge.exe
            System.setProperty("webdriver.edge.driver", path + "\\msedgedriver.exe");
            webDriver = new EdgeDriver();
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testParameterWithXML() throws InterruptedException {
        System.out.println("Browser which will be running");
        if (webDriver instanceof ChromeDriver) {
            return;
        }
        webDriver.get("http://demo.guru99.com/V4/");
        WebElement userName = webDriver.findElement(By.name("uid"));
        userName.sendKeys("guru99");
        WebElement password = webDriver.findElement(By.name("password"));
        password.sendKeys("guru99");
    }

    @AfterTest
    public void close() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
