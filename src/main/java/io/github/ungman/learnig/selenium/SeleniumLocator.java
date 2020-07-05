package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumLocator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
        testById();
        testByName();
        testFindElement();
        testFindElements();
    }

    //    private static void testById() {
//        WebDriver webDriver = new ChromeDriver();
//        try {
//            String baseUrl = "http://demo.guru99.com/test/facebook.html";
//            webDriver.get(baseUrl);
//        } catch (Exception exception) {
//            System.out.println("Test not passed");
//            exception.printStackTrace();
//        } finally {
//            webDriver.quit();
//        }
//    }
    private static void testById() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/facebook.html";
            webDriver.get(baseUrl);
            WebElement email = webDriver.findElement(By.id("email"));
            System.out.println(email.getCssValue("type"));
        } catch (Exception exception) {
            System.out.println("Test not passed");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void testByName() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/newtours/";
            webDriver.get(baseUrl);
            String name = "userName";
            WebElement element = webDriver.findElement(By.name(name));
            System.out.println(element.getCssValue("type"));
        } catch (Exception exception) {
            System.out.println("Test not passed");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void testFindElement() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        try {
            String baseUrl = "http://demo.guru99.com/test/ajax.html";
            webDriver.get(baseUrl);
            webDriver.findElement(By.id("no")).click();
            webDriver.findElement(By.id("buttoncheck")).click();
        } catch (Exception exception) {
            System.out.println("Test not passed");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void testFindElements() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/ajax.html";
            webDriver.get(baseUrl);
            List<WebElement> elements = webDriver.findElements(By.name("name"));
            for (WebElement element : elements) {
                System.out.println("Radio button text: "+element.getAttribute("value"));
            }
        } catch (Exception exception) {
            System.out.println("Test not passed");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }
}
