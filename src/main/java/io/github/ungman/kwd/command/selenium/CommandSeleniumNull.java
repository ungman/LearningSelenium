package io.github.ungman.kwd.command.selenium;

import io.github.ungman.kwd.command.Command;

public class CommandSeleniumNull implements Command {
    @Override
    public void execute(Object object, String value) {
        System.out.println("Null command");
    }
}
