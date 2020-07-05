package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class PG7 {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
            testOneAction();
            testMultipleAction();
        } finally {
            System.exit(0);
        }
    }

    private static void testMultipleAction() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://www.facebook.com/";
            webDriver.get(baseUrl);
            Actions builder = new Actions(webDriver);
            WebElement txtUsername = webDriver.findElement(By.id("email"));
            Action seriesOfActions = builder
                    .moveToElement(txtUsername)
                    .click()
                    .keyDown(txtUsername, Keys.SHIFT)
                    .sendKeys(txtUsername,"hello")
                    .keyUp(txtUsername,Keys.SHIFT)
                    .doubleClick(txtUsername)
                    .contextClick()
                    .build();
            seriesOfActions.perform();
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void testOneAction() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/newtours/";
            webDriver.get(baseUrl);
            WebElement linkHome = webDriver.findElement(By.linkText("Home"));
            WebElement td_Home = webDriver
                    .findElement(By
                            .xpath("//html/body/div"
                                    + "/table/tbody/tr/td"
                                    + "/table/tbody/tr/td"
                                    + "/table/tbody/tr/td"
                                    + "/table/tbody/tr"));

            Actions builder = new Actions(webDriver);
            Action mouseOverHome = builder
                    .moveToElement(linkHome)
                    .build();
            String bgColor = td_Home.getCssValue("background-color");
            System.out.println("Color before : " + bgColor);
            mouseOverHome.perform();
            bgColor = td_Home.getCssValue("background-color");
            System.out.println("Color after : " + bgColor);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            webDriver.close();
        }

    }
}
