package io.github.ungman.testing.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class HomePage {
    WebDriver webDriver;

    @FindBy(id = "navbar-brand-centered")
    private WebElement navBarSite;

    public HomePage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getNavBarSiteItem(String text) {
        WebElement element = getElement(navBarSite.findElements(By.linkText(text)));
        return element;
    }

    public HomePage clickNavBarSiteItem(String text) {
        return clickOnElement(getNavBarSiteItem(text));
    }

    private WebElement getElement(List<WebElement> elements) {
        if (elements.size() > 0) {
            return elements.get(0);
        }
        return null;
    }

    private HomePage clickOnElement(WebElement element) {
        if (element != null)
            element.click();
        return this;
    }

}

