package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDragAndDrop extends WebDriverInvocationRunner {
    String url = "http://demo.guru99.com/test/drag_drop.html";

    @Test
    public void simpleDragAndDrop() {
        webDriver.get(url);
        WebElement from = webDriver.findElement(By.xpath("//*[@id='credit2']/a"));
        WebElement to = webDriver.findElement(By.xpath("//*[@id='bank']/li"));
        Actions actions = new Actions(webDriver);
        actions.dragAndDrop(from, to).build().perform();
    }

    @Test
    public void withCoordinateDragAndDrop() {
        webDriver.get(url);
        WebElement source=webDriver.findElement(By.xpath("//*[@id='credit2']/a"));
        new Actions(webDriver)
                .dragAndDropBy(source,135,40)
                .build()
                .perform();
    }
    @Test
    public void fewElementAndVerify(){
        webDriver.get(url);
        WebElement source1=webDriver.findElement(By.xpath("//*[@id='credit2']/a"));
        WebElement target1=webDriver.findElement(By.xpath("//*[@id='bank']/li"));
        WebElement source2=webDriver.findElement(By.xpath("//*[@id='credit1']/a"));
        WebElement target2=webDriver.findElement(By.xpath("//*[@id='loan']/li"));
        WebElement source3=webDriver.findElement(By.xpath("//*[@id='fourth']/a"));
        WebElement target3=webDriver.findElement(By.xpath("//*[@id='amt7']/li"));
        WebElement source4=webDriver.findElement(By.xpath("//*[@id='fourth']/a"));
        WebElement target4=webDriver.findElement(By.xpath("//*[@id='amt8']/li"));

//        Actions act=new Actions(webDriver);
//        act.dragAndDrop(source2, target1).build().perform();
//        act.dragAndDrop(source2, target2).build().perform();
//        act.dragAndDrop(source3, target3).build().perform();
//        act.dragAndDrop(source4, target4).build().perform();
        new Actions(webDriver)
                .dragAndDrop(source1,target1)
                .dragAndDrop(source2,target2)
                .dragAndDrop(source3,target3)
                .dragAndDrop(source4,target4)
                .build()
                .perform();
        WebElement message = webDriver.findElement(By.xpath("//a[contains(text(),'Perfect')]"));
        Assert.assertTrue(message.isDisplayed(),"Message Perfect not displayed");
    }
}
