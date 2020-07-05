package io.github.ungman.kwd.helper;

import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcel {
    @SneakyThrows
    public Workbook getWorkbook(String filename) {
        File file = new File(filename);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        if (filename.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (filename.endsWith(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        return workbook;
    }

    public Sheet getSheet(String filename, String sheetName) {
        return getWorkbook(filename).getSheet(sheetName);
    }


}
