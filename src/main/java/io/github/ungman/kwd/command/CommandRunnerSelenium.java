package io.github.ungman.kwd.command;

import io.github.ungman.kwd.command.selenium.CommandSeleniumClick;
import io.github.ungman.kwd.command.selenium.CommandSeleniumGoTo;
import io.github.ungman.kwd.command.selenium.CommandSeleniumNull;
import io.github.ungman.kwd.command.selenium.CommandSeleniumSetText;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommandRunnerSelenium implements CommandRunner {

    private Map<String, Command> operationHandlerMap;

    public CommandRunnerSelenium() {
        operationHandlerMap = new ConcurrentHashMap<>();
        operationHandlerMap.put("click", new CommandSeleniumClick());
        operationHandlerMap.put("goto", new CommandSeleniumGoTo());
        operationHandlerMap.put("settext", new CommandSeleniumSetText());
        operationHandlerMap.put("null", new CommandSeleniumNull());
    }

    public void runCommand(String command, String value,Object object) {
        String cmnd = command.toLowerCase();
        if (operationHandlerMap.containsKey(cmnd)) {
            operationHandlerMap.get(cmnd).execute(object,value);
        }
    }
}
