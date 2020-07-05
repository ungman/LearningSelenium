package io.github.ungman.learnig.seleniumwithtestng.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99LoginPageWithPageFactory {
    WebDriver webDriver;
    @FindBy(name="uid")
    WebElement usernameInput;
    @FindBy(name="password")
    WebElement passwordInput;
    @FindBy(className = "barone")
    WebElement titleText;
    @FindBy (name = "btnLogin")
    WebElement btnLogin;

    public Guru99LoginPageWithPageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public void setUsername(String username){
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }
    public void setPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void clickLogin(){
        btnLogin.click();
    }
    public String getPageTitle(){
        return titleText.getText();
    }
    public void loginToGuru99(String username,String password){
        this.setUsername(username);
        this.setPassword(password);
        this.clickLogin();
    }
}
