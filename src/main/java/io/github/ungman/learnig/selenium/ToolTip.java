package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ToolTip {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
            testSimpleTooltip();
            jqueryToolTip();
        } finally {
            System.exit(0);
        }
    }
    private static void testSimpleTooltip() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/social-icon.html";
            webDriver.get(baseUrl);
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            String expectedTooltip = "Github";
            WebElement github = webDriver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));
            String actualTooltip = github.getAttribute("title");
            System.out.println("Actual Title of Tool Tip "+actualTooltip);
            if(actualTooltip.equals(expectedTooltip)) {
                System.out.println("Test Case Passed");
            }
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void jqueryToolTip(){
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/tooltip.html";
            webDriver.get(baseUrl);
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            String expectedTooltip = "What's new in 3.2";
            webDriver.get(baseUrl);
            WebElement download = webDriver.findElement(By.xpath(".//*[@id='download_now']"));
            Actions builder = new Actions(webDriver);
            builder.clickAndHold().moveToElement(download);
            builder.moveToElement(download).build().perform();
            WebElement toolTipElement = webDriver.findElement(By.xpath(".//*[@class='box']/div/a"));
            String actualTooltip = toolTipElement.getText();
            System.out.println("Actual Title of Tool Tip  "+actualTooltip);
            if(actualTooltip.equals(expectedTooltip)) {
                System.out.println("Test Case Passed");
            }
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }


}
