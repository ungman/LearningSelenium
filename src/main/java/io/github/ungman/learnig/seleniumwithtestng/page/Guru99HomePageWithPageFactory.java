package io.github.ungman.learnig.seleniumwithtestng.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99HomePageWithPageFactory {
    WebDriver webDriver;

    @FindBy(xpath = "//table//tr[@class='heading3']")
    WebElement homePageUserName;

    public Guru99HomePageWithPageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getHomePageDashboardUserName() {
        return homePageUserName.getText();
    }
}
