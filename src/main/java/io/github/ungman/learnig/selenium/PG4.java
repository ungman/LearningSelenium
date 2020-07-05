package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PG4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
        testFrames();
        testAlerts();
        System.exit(0);
    }

    private static void testFrames() {
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.get("http://demo.guru99.com/selenium/deprecated.html");
            webDriver.wait(10);
            webDriver.switchTo().frame("classFrame");
            webDriver.findElement(By.linkText("Deprecated")).click();
        } catch (Exception exception) {
            System.out.println("Test not Passed");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    public static void testAlerts() {
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.get("http://jsinput[value=\\\"Go!\\\"]bin.com/usidix/1");
            webDriver.findElement(By.cssSelector("")).click();
            String alertMessage = "";
            alertMessage = webDriver.switchTo().alert().getText();
            webDriver.switchTo().alert().accept();
            System.out.println(alertMessage);
        } catch (Exception exception) {
            System.out.println("Test failed");
            exception.printStackTrace();
        } finally {
            webDriver.quit();

        }
    }
}
