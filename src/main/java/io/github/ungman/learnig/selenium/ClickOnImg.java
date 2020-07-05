package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickOnImg {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "https://www.facebook.com/login/identify?ctx=recover";
            webDriver.get(baseUrl);
            webDriver.findElement(By.cssSelector("a[title=\"Перейти на главную страницу Facebook\"]")).click();
            if (webDriver.getTitle().equals("Facebook — Выполните вход или зарегистрируйтесь")) {
                System.out.println("We are back at Facebook's homepage");
            } else {
                System.out.println("We are NOT in Facebook's homepage");
            }
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.close();
        }
        System.exit(0);
    }
}
