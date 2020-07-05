package io.github.ungman.learnig.seleniumwithtestng.kwd.kwdoperationui;

import org.openqa.selenium.WebElement;

public class HandleKWDOperationSetText implements HandleKWDOperation {
    @Override
    public void handle(Object object, String value) {
        ((WebElement) object).sendKeys(value);
    }
}
