package io.github.ungman.learnig.seleniumwithtestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class testNGAdvancedXpath extends WebDriverInvocationRunner{

    @Test
    public void testSiblingAndContains(){
        String url = "http://demo.guru99.com/test/guru99home/";
        webDriver.get(url);
        //Search element inside 'Popular course' which are sibling of control 'SELENIUM' ,Here first we will find a h2 whose text is ''A few of our most popular courses' ,then we move to its parent element which is a 'div' , inside this div we will find a link whose text is 'SELENIUM' then at last we will find all of the sibling elements of this link('SELENIUM')
        List<WebElement> dateBox = webDriver.findElements(By.xpath("//h2[contains(text(),'A few of our most popular courses')]/parent::div//div[//a[text()='SELENIUM']]/following-sibling::div[@class='rt-grid-2 rt-omega']"));
        for (WebElement webElement : dateBox) {
            System.out.println(webElement.getText());
        }
    }

    @Test
    public void testAncestor(){
        String url = "http://demo.guru99.com/test/guru99home/";
        webDriver.get(url);
        //Search All elements in 'Popular course' section
        //with the help of ancestor of the anchor whose text is 'SELENIUM'
        List <WebElement> dateBox = webDriver.findElements(By.xpath("//div[.//a[text()='SELENIUM']]/ancestor::div[@class='rt-grid-2 rt-omega']/following-sibling::div"));
        //Print all the which are sibling of the element named as 'SELENIUM' in 'Popular course'
        for (WebElement webElement : dateBox) {
            System.out.println(webElement.getText());
        }
    }

    @Test
    public void testAndOr(){
        webDriver.get("https://www.guru99.com/");

        //Search element using OR in the xpath
        WebElement el1 = webDriver.findElement(By.xpath("//*[@type='submit' OR @name='btnReset']"));
        //Print the text of the element
        System.out.println(el1.getText());

        //Search element using AND in the xpath
        WebElement el2 = webDriver.findElement(By.xpath("//input[@type='submit' and @name='btnLogin']"));
        //Print the text of the searched element
        System.out.println(el2.getText());
    }

    @Test
    public void testParent(){
        webDriver.get("https://www.guru99.com/");
        //Search the element by using PARENT
        WebElement element = webDriver.findElement(By.xpath("//*[@id='rt-feature']//parent::div"));
        //Print the text of the searched element
        System.out.println(element.getText());
        //Close the browser
        webDriver.quit();

    }

    @Test
    public void testStartWith() {
        webDriver.get("https://www.guru99.com/");
        //Search the element by using starts-with
        WebElement element = webDriver.findElement(By.xpath("//label[starts-with(@id,'message')]"));
        //Print the text of the searched element
        System.out.println(element.getText());
    }

    @Test
    public  void testWithAxes(){
        String url = "https://www.guru99.com/";
        webDriver.get(url);
        //Search the element by using Following method
        WebElement element1 = webDriver.findElement(By.xpath("//*[@type='text']//following::input"));
        //Print the text of the searched element
        System.out.println(element1.getText());

        //Search the element by using preceding method
        WebElement element2 = webDriver.findElement(By.xpath("//*[@type='submit']//preceding::input"));
        //Print the text of the searched element
        System.out.println(element2.getText());

        //Search the element by using descendant method
        WebElement element3 = webDriver.findElement(By.xpath("//*[@id='rt-feature']//descendant::a"));
        //Print the text of the searched element
        System.out.println(element3.getText());
    }
}
