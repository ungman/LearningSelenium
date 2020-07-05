package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PG9 {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
            testUploadElement();
        } finally {
            System.exit(0);
        }
    }

    private static void testUploadElement() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/upload/";
            webDriver.get(baseUrl);
            WebElement uploadElement = webDriver.findElement(By.id("uploadfile_0"));
            uploadElement.sendKeys("D:\\IDE\\Project\\Java\\LearningSelenium\\Guru99\\src\\main\\resources\\test.html");
            webDriver.findElement(By.id("terms")).click();
            webDriver.findElement(By.name("send")).click();
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }
}
