package io.github.ungman.learnig.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PG3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\WebDrivers\\chromedriver.exe");
        WebDriver webDriver=new ChromeDriver();
        webDriver.get("http://www.popuptest.com/popuptest2.html");
        webDriver.quit();
    }
}
