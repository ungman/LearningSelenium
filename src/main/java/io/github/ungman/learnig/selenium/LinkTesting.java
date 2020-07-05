package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTesting {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
            testLinkTest();
            testPartialLinkTest();
            tesInsideOutsideLink();
        } finally {
            System.exit(0);
        }
    }

    private static void testLinkTest() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/link.html";
            webDriver.get(baseUrl);
            webDriver.findElement(By.linkText("click here")).click();
            System.out.println("title of page is: " + webDriver.getTitle());
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void testPartialLinkTest() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/accessing-link.html";
            webDriver.get(baseUrl);
            webDriver.findElement(By.partialLinkText("here")).click();
            System.out.println("title of page is: " + webDriver.getTitle());
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void tesInsideOutsideLink() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/block.html";
            webDriver.get(baseUrl);
            webDriver.findElement(By.partialLinkText("Inside")).click();
            System.out.println("title of page is: " + webDriver.getTitle());
            webDriver.navigate().back();
            webDriver.findElement(By.partialLinkText("Outside")).click();
            System.out.println("title of page is: " + webDriver.getTitle());
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }
}
