package io.github.ungman.learnig.seleniumwithtestng.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99LoginPage {
    WebDriver webDriver;
    By username = By.name("uid");
    By password = By.name("password");
    By titleText = By.className("barone");
    By login = By.name("btnLogin");

    public Guru99LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setUsername(String username){
        webDriver.findElement(this.username).clear();
        webDriver.findElement(this.username).sendKeys(username);
    }

    public void setPassword(String password){
        webDriver.findElement(this.password).clear();
        webDriver.findElement(this.password).sendKeys(password);
    }

    public  void clickLogin(){
        webDriver.findElement(this.login).click();
    }

    public String getLoginTitle(){
        return webDriver.findElement(titleText).getText();
    }

    public void loginToGuru99(String username,String password){
        this.setUsername(username);
        this.setPassword(password);
        this.clickLogin();
    }
}
