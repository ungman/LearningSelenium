package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PG2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        String baseUrl = "http://www.facebook.com";
        String tagName = "";
        webDriver.get(baseUrl);
        tagName = webDriver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);
        webDriver.close();
        System.exit(0);
    }
}
