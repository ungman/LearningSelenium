package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testNGIframe extends WebDriverInvocationRunner {
    @Test
    public void TestNGIfrime() {
        String baseUrl = "http://demo.guru99.com/test/guru99home/";
        webDriver.get(baseUrl);
        webDriver.switchTo().frame("a077aa5e");
        System.out.println("********We are switch to the iframe*******");
        webDriver.findElement(By.xpath("html/body/a/img")).click();
        System.out.println("*********We are done***************");
    }

    @Test
    public void testSwitchingAndBack() {
        String baseUrl = "http://demo.guru99.com/test/guru99home/";
        webDriver.manage().window().maximize();
        int size=webDriver.findElements(By.tagName("iframe")).size();
        for (int i = 0; i < size; i++) {
            webDriver.switchTo().frame(i);
            int total=webDriver.findElements(By.xpath("html/body/a/img")).size();
            System.out.println(total);
            webDriver.switchTo().defaultContent();
        }
        webDriver.switchTo().frame(0);
        System.out.println("********We are switched to the iframe*******");
        webDriver.findElement(By.xpath("html/body/a/img")).click();
        System.out.println("*********We are done***************");
    }

    @Test
    @Ignore
    public void testNestedFrames(){
        String baseUrl="URL";
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        int countOuterFrame=webDriver.findElements(By.tagName("iframe")).size();
        System.out.println("Total frames -- "+countOuterFrame);
        webDriver.switchTo().frame(0);
        System.out.println("Switched to frame");
        int countNestedFrame = webDriver.findElements(By.tagName("iframe")).size();
        System.out.println("Total nested frame --"+countNestedFrame);

        webDriver.switchTo().defaultContent();
    }
}
