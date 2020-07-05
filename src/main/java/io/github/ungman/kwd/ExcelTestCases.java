package io.github.ungman.kwd;

import io.github.ungman.kwd.command.CommandRunner;
import io.github.ungman.kwd.helper.GetterObject;
import io.github.ungman.kwd.helper.ReadExcel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExcelTestCases {
    private Map<String, ExcelTestCase> testCasesMap;
    private Map<String, List<String>> dataProvider;
    private CommandRunner runner;
    private GetterObject getterObject;

    public ExcelTestCases() {
        testCasesMap = new ConcurrentHashMap<>();
        dataProvider = new ConcurrentHashMap<>();
    }

    public ExcelTestCases(CommandRunner runner, GetterObject getterObject) {
        testCasesMap = new ConcurrentHashMap<>();
        dataProvider = new ConcurrentHashMap<>();
        this.runner = runner;
        this.getterObject = getterObject;
    }

    public void initTestCases(String filename, String sheetName) {
        Sheet testCaseSheet = new ReadExcel().getSheet(filename, sheetName);
        int rowCount = testCaseSheet.getLastRowNum() - testCaseSheet.getFirstRowNum();
        ExcelTestCase testCase = null;
        String nameTestCaseDataProvider = "";
        for (int i = 1; i <= rowCount; i++) {
            Row row = testCaseSheet.getRow(i);
            testCase = computingRow(testCase, row);
            nameTestCaseDataProvider=computingRowDataProvider(nameTestCaseDataProvider, row);
        }
        addingDataProviderToTestCases();
    }

    private void addingDataProviderToTestCases() {
        for (Map.Entry<String, List<String>> dataProviderEntry : dataProvider.entrySet()) {
            ExcelTestCase testCase = testCasesMap.get(dataProviderEntry.getKey());
            if (testCase != null) {
                Map<String, String> dataList = new HashMap<>();
                for (String data : dataProviderEntry.getValue()) {
                    String[] dataSplit = data.split("#");
                    testCase.addDataProviderData(dataSplit[0], dataSplit[1]);
                }
            }
        }
    }

    private String computingRowDataProvider(String nameTestCaseDataProvider, Row row) {
        if ( nameTestCaseDataProvider!=null && (row.getCell(7) == null || row.getCell(7).toString().length() == 0) ){
            List<String> dataList = dataProvider.get(nameTestCaseDataProvider);
            if (dataList != null) {
                if(row.getCell(8)!=null && row.getCell(9)!=null) {
                    dataList.add(row.getCell(8).toString() + "#" + row.getCell(9).toString());
                }
            }
        } else {
            nameTestCaseDataProvider = row.getCell(7).toString();
            dataProvider.put(nameTestCaseDataProvider, new ArrayList<>());
        }
        return nameTestCaseDataProvider;
    }

    @Nullable
    private ExcelTestCase computingRow(ExcelTestCase testCase, Row row) {
        if (row.getCell(0) == null || row.getCell(0).toString().length() == 0) {
            if (testCase != null) {
                testCase.addRowData(row);
            }
        } else {
            String nameTestCase;
            nameTestCase = row.getCell(0).toString();
            testCase = new ExcelTestCase(nameTestCase, getterObject, runner);
            testCasesMap.put(nameTestCase, testCase);
        }
        return testCase;
    }

    public void runTestCases() {
        System.out.println("TestCase length: "+testCasesMap.size());
        for (String nameTestCase : testCasesMap.keySet()) {
            runTestCase(nameTestCase);
        }
    }

    public void runTestCase(String name) {
        testCasesMap.get(name).runTestCase();
    }
}
