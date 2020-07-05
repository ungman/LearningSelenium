package io.github.ungman.kwd;

import io.github.ungman.kwd.command.CommandRunner;
import io.github.ungman.kwd.command.CommandRunnerSelenium;
import io.github.ungman.kwd.helper.GetterObject;
import io.github.ungman.learnig.seleniumwithtestng.WebDriverInvocationRunner;
import io.github.ungman.learnig.seleniumwithtestng.kwd.ReadObject;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.Properties;

public class ExecuteTest extends WebDriverInvocationRunner {
    private final String PATH_TO_RESOURCE = System.getProperty("user.dir") + "\\src\\main\\resources";

    @SneakyThrows
    @Test
    public void ExcelKWDTest() {
        CommandRunner runner = new CommandRunnerSelenium();
        Properties properties = new ReadObject().getObjectRepository();
        GetterObject getterObject = new GetterObject(webDriver, properties);
        String filename = PATH_TO_RESOURCE + "\\test1.xlsx";
        ExcelTestCases excelTestCases = new ExcelTestCases(runner, getterObject);
        excelTestCases.initTestCases(filename, "KWD");
        excelTestCases.runTestCases();
    }

}
