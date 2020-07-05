package io.github.ungman.learnig.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class AlertsAndPopup {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
            testAlert();
            testWindow();
        } finally {
            System.exit(0);
        }
    }

    private static void testAlert() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/delete_customer.php";
            webDriver.get(baseUrl);
            webDriver.findElement(By.name("cusid")).sendKeys("53920");
            webDriver.findElement(By.name("submit")).submit();
            Alert alert = webDriver.switchTo().alert();
            String alertMessage = webDriver.switchTo().alert().getText();
            System.out.println(alertMessage);
            alert.accept();
        } catch (Exception exception) {
            System.out.println("Test failed".toUpperCase());
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }

    }

    private static void testWindow() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/popup.php";
            webDriver.get(baseUrl);
            webDriver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
            String mainWindowHandle = webDriver.getWindowHandle();
            Set<String> windowHandles = webDriver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if(!windowHandle.equals(mainWindowHandle)){
                    webDriver.switchTo().window(windowHandle);
                    webDriver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                    webDriver.findElement(By.name("btnLogin")).click();
                    webDriver.close();
                }
            }
            webDriver.switchTo().window(mainWindowHandle);
        } catch (Exception exception) {
            System.out.println("Test failed".toUpperCase());
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }

    }
}
