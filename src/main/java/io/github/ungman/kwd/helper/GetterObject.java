package io.github.ungman.kwd.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;


public class GetterObject {

    private WebDriver webDriver;
    private Properties p;

    public GetterObject(WebDriver webDriver, Properties p) {
        this.webDriver = webDriver;
        this.p = p;
    }

    public Object getObject(String name, String findBy,String testCase) {
        WebElement webElement;
        String objectName=testCase+"."+name;
        if (findBy.equalsIgnoreCase("XPATH")) {
            webElement = webDriver.findElement(By.xpath(p.getProperty(objectName)));
        } else if (findBy.equalsIgnoreCase("CLASSNAME")) {
            webElement = webDriver.findElement(By.className(p.getProperty(objectName)));
        } else if (findBy.equalsIgnoreCase("NAME")) {
            webElement = webDriver.findElement(By.name(p.getProperty(objectName)));
        } else if (findBy.equalsIgnoreCase("CSS")) {
            webElement = webDriver.findElement(By.cssSelector(p.getProperty(objectName)));
        } else if (findBy.equalsIgnoreCase("LINK")) {
            webElement = webDriver.findElement(By.linkText(p.getProperty(objectName)));
        } else if (findBy.equalsIgnoreCase("PARTIALLINK")) {
            webElement = webDriver.findElement(By.partialLinkText(p.getProperty(objectName)));
        } else if (findBy.equalsIgnoreCase("DRIVER")) {
            return webDriver;
        } else {
            webElement = null;
        }
        return webElement;
    }
}
