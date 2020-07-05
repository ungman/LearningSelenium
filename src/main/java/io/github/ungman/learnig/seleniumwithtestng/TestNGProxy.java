package io.github.ungman.learnig.seleniumwithtestng;

import org.testng.annotations.Test;

public class TestNGProxy extends  WebDriverInvocationRunner {

    @Test
    public  void  testProxyWithAlerts(){
        webDriver.get("http://demo.guru99.com/test/basic_auth.php");
        // Handling Username alert
        webDriver.switchTo().alert().sendKeys("guru99");
        webDriver.switchTo().alert().accept();
        // Handling Password alert
        webDriver.switchTo().alert().sendKeys("guru99");
        webDriver.switchTo().alert().accept();
    }
}
