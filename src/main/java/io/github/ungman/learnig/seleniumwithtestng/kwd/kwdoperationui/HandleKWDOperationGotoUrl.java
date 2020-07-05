package io.github.ungman.learnig.seleniumwithtestng.kwd.kwdoperationui;

import org.openqa.selenium.WebDriver;

public class HandleKWDOperationGotoUrl implements HandleKWDOperation {
    @Override
    public void handle(Object object, String value) {
        ((WebDriver)object).get(value);
    }
}
