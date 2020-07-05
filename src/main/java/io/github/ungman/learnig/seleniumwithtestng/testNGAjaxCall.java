package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testNGAjaxCall extends WebDriverInvocationRunner {
    private String URL = "http://demo.guru99.com/test/ajax.html";
    WebDriverWait webDriverWait;

    @Test
    public void TestAjaxCall() {
        webDriver.navigate().to(URL);
        By container = By.cssSelector(".container");
        webDriverWait = new WebDriverWait(webDriver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(container));
        WebElement noTextElement = webDriver.findElement(By.className("radiobutton"));
        String textBefore = noTextElement.getText().trim();
        webDriver.findElement(By.id("yes")).click();
        webDriver.findElement(By.id("buttoncheck")).click();
        WebElement TextElement = webDriver.findElement(By.className("radiobutton"));
        webDriverWait.until(ExpectedConditions.visibilityOf(TextElement));
        String textAfter = TextElement.getText().trim();

        /*Verify both texts before ajax call and after ajax call text.*/
        Assert.assertNotEquals(textBefore, textAfter);
        System.out.println("Ajax Call Performed");

        String expectedText = "Radio button is checked and it's value is Yes";
        /*Verify expected text with text updated after ajax call*/
        Assert.assertEquals(textAfter, expectedText);
    }
}
