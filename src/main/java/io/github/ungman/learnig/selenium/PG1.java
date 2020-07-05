package io.github.ungman.learnig.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PG1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http:\\demo.guru99.com/test/newtours";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        driver.get(baseUrl);
        actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test passed");
        }else {
            System.out.println("Test Failed");
        }
        driver.close();
    }
}
