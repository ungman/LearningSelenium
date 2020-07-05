package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.NoSuchElementException;

public class TestNGWaits extends WebDriverInvocationRunner {
    @Test
    public void implicitlyWait() {
        String eTitle = "Demo Guru99 Page";
        String aTitle = "";
        // launch Chrome and redirect it to the Base URL
        webDriver.get("http://demo.guru99.com/test/guru99home/");
        //Maximizes the browser window
        webDriver.manage().window().maximize();
        //get the actual value of the title
        aTitle = webDriver.getTitle();
        //compare the actual title with the expected title
        Assert.assertEquals(aTitle, eTitle, "Title not equals");
    }

    @Test
    public void explicitWait() {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        String eTitle = "Demo Guru99 Page";
        String aTitle = "";
        // launch Chrome and redirect it to the Base URL
        webDriver.get("http://demo.guru99.com/test/guru99home/");
        //Maximizes the browser window
        webDriver.manage().window().maximize();
        //get the actual value of the title
        aTitle = webDriver.getTitle();
        //compare the actual title with the expected title
        Assert.assertEquals(aTitle, eTitle, "Title not equals");
        WebElement guru99seleniumlink;
        guru99seleniumlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i")));
        guru99seleniumlink.click();
    }

    public void fluentWait() {
        String eTitle = "Demo Guru99 Page";
        String aTitle = "";
        // launch Chrome and redirect it to the Base URL
        webDriver.get("http://demo.guru99.com/test/guru99home/");
        //Maximizes the browser window
        webDriver.manage().window().maximize();
        //get the actual value of the title
        aTitle = webDriver.getTitle();
        //compare the actual title with the expected title
        Assert.assertEquals(aTitle, eTitle, "Title not equals");
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement clickseleniumlink = wait.until(
                driver -> driver
                        .findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i"))
        );
        clickseleniumlink.click();
    }


}
