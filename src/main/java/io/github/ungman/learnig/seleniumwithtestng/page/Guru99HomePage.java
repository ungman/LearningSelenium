package io.github.ungman.learnig.seleniumwithtestng.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99HomePage {
    WebDriver webDriver;
    By homePageUsername=By.xpath("//table//tr[@class=\"heading3\"]");

    public Guru99HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public  String getHomePageDashboardUsername(){
        return webDriver.findElement(homePageUsername).getText();
    }
}
