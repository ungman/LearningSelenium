package io.github.ungman.kwd.command.selenium;

import io.github.ungman.kwd.command.Command;
import org.openqa.selenium.WebDriver;

public class CommandSeleniumGoTo implements Command {
    @Override
    public void execute(Object object, String value) {
        if(object instanceof WebDriver) {
            ((WebDriver)object).get(value);
        }else {
            System.out.println("Object type not correct");
        }
    }
}
