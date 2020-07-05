package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGJavaScriptExecutor extends WebDriverInvocationRunner {
    JavascriptExecutor javascriptExecutor;

    @Test
    public void testAsyncScript() {
        javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriver.get("http://demo.guru99.com/V4/ ");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        long startTime = System.currentTimeMillis();
        javascriptExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
        System.out.println("Passed time: " + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void testExecuteSript() {
        javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriver.get("http://demo.guru99.com/V4/ ");
        WebElement button = webDriver.findElement(By.name("btnLogin"));
        //Login to Guru99
        webDriver.findElement(By.name("uid")).sendKeys("mngr34926");
        webDriver.findElement(By.name("password")).sendKeys("amUpenu");
        //Perform Click on LOGIN button using JavascriptExecutor
        javascriptExecutor.executeScript("arguments[0].click();", button);
        //To generate Alert window using JavascriptExecutor. Display the alert message
        javascriptExecutor.executeScript("alert('Welcome to Guru99');");
    }


    @Test
    public void testScrapeDataAndNavigate() {

        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        //Launching the Site.
        webDriver.get("http://demo.guru99.com/V4/");
        //Fetching the Domain Name of the site. Tostring() change object to name.
        String DomainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain name of the site = " + DomainName);
        //Fetching the URL of the site. Tostring() change object to name
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL of the site = " + url);
        //Method document.title fetch the Title name of the site. Tostring() change object to name
        String TitleName = js.executeScript("return document.title;").toString();
        System.out.println("Title of the page = " + TitleName);
        //Navigate to new Page i.e to generate access page. (launch new url)
        js.executeScript("window.location = 'http://demo.guru99.com/'");
    }

    @Test
    public void Login()
    {

        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        //Launching the Site.
        webDriver.get("http://moneyboats.com/");
        //Maximize window
        webDriver.manage().window().maximize();
        //Vertical scroll down by 600  pixels
        js.executeScript("window.scrollBy(0,600)");
    }

}
