package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class TestNGWithHTMLUnitDeiver {

    @Test
    public void testHtmlUnitDriver() {
        WebDriver webDriver = new HtmlUnitDriver();
        String url = "http://www.google.com";
        webDriver.get(url);
        WebElement element = webDriver.findElement(By.name("q"));
        element.sendKeys("Test...");
        element.submit();
        System.out.println("Page title is: " + webDriver.getTitle());
        webDriver.quit();
    }
}
