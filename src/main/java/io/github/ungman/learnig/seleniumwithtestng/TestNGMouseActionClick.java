package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestNGMouseActionClick extends WebDriverInvocationRunner {
    @Test
    public void testDoubleClick() {

        String url = "http://demo.guru99.com/test/simple_context_menu.html";
        webDriver.get(url);
        webDriver.manage().window().maximize();
//Double click the button to launch an alertbox
        Actions action = new Actions(webDriver);
        WebElement link = webDriver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        action.doubleClick(link).perform();
//Switch to the alert box and click on OK button
        Alert alert = webDriver.switchTo().alert();
        System.out.println("Alert Text\n" + alert.getText());
        alert.accept();
    }

    @Test
    public void testRightClick() {
        webDriver.get("http://demo.guru99.com/test/simple_context_menu.html");
        webDriver.manage().window().maximize();
        // Right click the button to launch right click menu options
        Actions action = new Actions(webDriver);
        WebElement link = webDriver.findElement(By.cssSelector(".context-menu-one"));
        action.contextClick(link).perform();
        // Click on Edit link on the displayed menu options
        WebElement element = webDriver.findElement(By.cssSelector(".context-menu-icon-copy"));
        element.click();
        // Accept the alert displayed
        webDriver.switchTo().alert().accept();
    }
}

