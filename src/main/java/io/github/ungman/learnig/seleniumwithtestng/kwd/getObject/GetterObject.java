package io.github.ungman.learnig.seleniumwithtestng.kwd.getObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class GetterObject {
    private WebDriver webDriver;
    private Properties p;

    public Object getObject(String objectName, String findBy) {
        WebElement webElement;
        if(findBy.equalsIgnoreCase("XPATH")){
            webElement = webDriver.findElement(By.xpath(p.getProperty(objectName)));
        }
        //find by class
        else if(findBy.equalsIgnoreCase("CLASSNAME")){
            webElement = webDriver.findElement(By.className(p.getProperty(objectName)));
        }
        //find by name
        else if(findBy.equalsIgnoreCase("NAME")){
            webElement = webDriver.findElement(By.name(p.getProperty(objectName)));
        }
        //Find by css
        else if(findBy.equalsIgnoreCase("CSS")){
            webElement = webDriver.findElement(By.cssSelector(p.getProperty(objectName)));
        }
        //find by link
        else if(findBy.equalsIgnoreCase("LINK")){
            webElement = webDriver.findElement(By.linkText(p.getProperty(objectName)));
        }
        //find by partial link
        else if(findBy.equalsIgnoreCase("PARTIALLINK")){
            webElement = webDriver.findElement(By.partialLinkText(p.getProperty(objectName)));
        }else
        {
            return webDriver;
        }
        return  webElement;
    }
}
