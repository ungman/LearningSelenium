package io.github.ungman.learnig.seleniumwithtestng.kwd;

import io.github.ungman.learnig.seleniumwithtestng.WebDriverInvocationRunner;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

import java.util.Properties;

public class ExecuteTest extends WebDriverInvocationRunner {
    Properties allProperties;

    @SneakyThrows
    private Sheet getSheetTestCase(String filename, String sheetName) {
        ReadExcel readExcel = new ReadExcel();
        ReadObject readObject = new ReadObject();
        allProperties = readObject.getObjectRepository();
        String pathToResource=System.getProperty("user.dir")+"\\src\\main\\resources";
        Sheet sheet = readExcel.readExcel(pathToResource+"\\", filename, sheetName);
        return sheet;
    }

    @SneakyThrows
    @Test
    public void KWDTest() {
        Sheet testCaseSheet = getSheetTestCase("test1.xlsx", "KWD");
        KWDOperation kwdOperation = new KWDOperationUI();
        int rowCount = testCaseSheet.getLastRowNum() - testCaseSheet.getFirstRowNum();
        for (int i = 1; i <= rowCount; i++) {
            Row row = testCaseSheet.getRow(i);
            if (row.getCell(0)==null || row.getCell(0).toString().length() == 0) {
                System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" +
                        row.getCell(3).toString() + "----" + row.getCell(4).toString());
                kwdOperation.perfom(webDriver, allProperties,row.getCell(1).toString(),row.getCell(2).toString(),row.getCell(3).toString(),row.getCell(4).toString());
            } else{
                //Print the new testcase name when it started
                System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
                Thread.sleep(3000);

            }
        }
    }

}
