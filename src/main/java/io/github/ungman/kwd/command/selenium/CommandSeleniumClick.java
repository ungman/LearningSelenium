package io.github.ungman.kwd.command.selenium;

import io.github.ungman.kwd.command.Command;
import org.openqa.selenium.WebElement;

public class CommandSeleniumClick implements Command {
    @Override
    public void execute(Object object, String value) {
        if(object instanceof WebElement){
            ((WebElement)object).click();
        }else {
            System.out.println("Object type not correct");
        }
    }
}
