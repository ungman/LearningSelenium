package io.github.ungman.kwd;

import io.github.ungman.kwd.command.CommandRunner;
import io.github.ungman.kwd.helper.GetterObject;
import lombok.Builder;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Row;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExcelTestCase {

    private String testCaseName;
    private Map<String, String> dataProvider;
    private List<RowCommand> rowCommands;
    private GetterObject getterObject;
    private CommandRunner runner;

    public ExcelTestCase() {
        dataProvider = new HashMap<>();
        rowCommands = new LinkedList<>();
    }

    public ExcelTestCase(String testCaseName, GetterObject getterObject, CommandRunner runner) {
        this.testCaseName = testCaseName;
        this.getterObject = getterObject;
        this.runner = runner;
        dataProvider = new HashMap<>();
        rowCommands = new LinkedList<>();
    }

    public ExcelTestCase(String testCaseName) {
        this.testCaseName = testCaseName;
        dataProvider = new HashMap<>();
        rowCommands = new LinkedList<>();
    }


    private void addRowData(RowCommand row) {
        rowCommands.add(row);
    }

    public void addRowData(Row row) {

        RowCommand rowData = RowCommand.builder()
                .command((row.getCell(1) != null) ? row.getCell(1).toString() : "")
                .findBy((row.getCell(2) != null) ? row.getCell(2).toString() : "")
                .propertyName((row.getCell(3) != null) ? row.getCell(3).toString() : "")
                .value((row.getCell(4) != null) ? row.getCell(4).toString() : "")
                .build();
        addRowData(rowData);
    }

    public void addDataProviderData(String key, String value) {
        this.dataProvider.put(key, value);
    }

    @SneakyThrows
    public void runTestCase() {
        RowCommand row1 = null;
        try {
            for (RowCommand row : rowCommands) {
                row1 = row;
                String command = row.getCommand();
                String value = getValueFromDataProvider(row.getValue());
                Object object = getterObject.getObject(row.getPropertyName(), row.getFindBy(),this.testCaseName);
                runner.runCommand(command, value, object);
            }
        } catch (Exception e) {
            System.out.println("Test not passed");
            System.out.println("Row: " + row1.toString());
            throw new Exception(e);
        }
    }

    private String getValueFromDataProvider(String name) {
        if (dataProvider.containsKey(name))
            return dataProvider.get(name);
        return name;
    }

}

@Builder
@Getter
@ToString
class RowCommand {
    private final String command;
    private final String findBy;
    private final String propertyName;
    private final String value;
}
