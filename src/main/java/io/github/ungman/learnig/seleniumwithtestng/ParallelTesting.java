package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;


public class ParallelTesting {

    private final List<WebDriver> webDriverList=new ArrayList<>();

    @BeforeClass
    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
    }

    @Test
    public void executSessionOne() {
        //First session of WebDriver
        WebDriver driver = new ChromeDriver();
        webDriverList.add(driver);
        //Goto guru99 site
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("Driver 1");

    }

    @Test
    public void executeSessionTwo() {
        //Second session of WebDriver
        WebDriver driver = new ChromeDriver();
        webDriverList.add(driver);
        //Goto guru99 site
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("Driver 2");
        driver.quit();
    }

    @Test
    public void executSessionThree() {
        //Third session of WebDriver
        WebDriver driver = new ChromeDriver();
        webDriverList.add(driver);
        //Goto guru99 site
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("Driver 3");
    }

    @AfterClass
    public void deconstructor(){
        for (WebDriver webDriver : webDriverList) {
            webDriver.quit();
        }
    }
}
