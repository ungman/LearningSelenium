package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestNGScrollingPage extends WebDriverInvocationRunner {
    String url = "http://demo.guru99.com/test/guru99home/";

    @Test
    public void scrollByPixel() {
//        String url = "http://demo.guru99.com/test/guru99home/";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriver.get(url);
        webDriver.manage().window().maximize();
        javascriptExecutor.executeScript("window.scrollBy(0,1000)");
    }

    @Test
    public void scrollByVisibleElement() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriver.get(url);
        WebElement Element = webDriver.findElement(By.linkText("Linux"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", Element);

    }

    @Test
    public void scrollByBottomPage() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriver.get(url);
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Test
    public void scrollHorizontal() {
        webDriver.get("http://demo.guru99.com/test/guru99home/scrolling.html");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.linkText("VBScript"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }
}
