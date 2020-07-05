package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AccessDropDown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl="http://demo.guru99.com/test/newtours/register.php";
            webDriver.get(baseUrl);
            Select drpCountry=new Select(webDriver.findElement(By.name("country")));
            drpCountry.selectByVisibleText("ANTARCTICA");

            webDriver.get("http://jsbin.com/osebed/2");
            Select fruits = new Select(webDriver.findElement(By.id("fruits")));
            fruits.selectByVisibleText("Banana");
            fruits.selectByIndex(1);
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.close();
            System.exit(0);
        }
    }
}
