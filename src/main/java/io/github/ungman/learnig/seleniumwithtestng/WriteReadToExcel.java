package io.github.ungman.learnig.seleniumwithtestng;

import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class WriteReadToExcel {
    @SneakyThrows
    public void readFromExcel(String filePath, String filename, String sheetName) {
        File file = getFile(filePath, filename);
        try (FileInputStream inputStream = new FileInputStream(file);
             FileOutputStream outputStream = new FileOutputStream(file);) {
            Workbook workbook = null;
            workbook = getWorkbook(filename, inputStream, workbook);
            Sheet sheet = getSheet(sheetName, workbook);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
            Row row = sheet.getRow(0);
            Row newRow = sheet.createRow(rowCount + 1);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    System.out.println(row.getCell(i).getStringCellValue() + "|| ");
                }
                System.out.println();
            }
            workbook.write(outputStream);
        }
    }

    @NotNull
    private File getFile(String filePath, String filename) throws IOException {
        String fullFileName = filePath + "\\" + filename;
        File file = new File(filePath + "\\" + filename);
        if(!Files.exists(file.toPath())){
            file.createNewFile();
        }
        return file;
    }


    @SneakyThrows
    public void writeToExcel(String filePath, String filename, String sheetName, String[] dataToWrite) {
        File file = getFile(filePath, filename);
        try (FileInputStream inputStream = new FileInputStream(file);
             FileOutputStream outputStream = new FileOutputStream(file);) {
            Workbook workbook = null;
            workbook = getWorkbook(filename, inputStream, workbook);
            Sheet sheet = getSheet(sheetName, workbook);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
            Row row = sheet.getRow(0);
            Row newRow = sheet.createRow(rowCount + 1);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = newRow.createCell(j);
                cell.setCellValue(dataToWrite[j]);
            }
            workbook.write(outputStream);
        }
    }

    private Sheet getSheet(String sheetName, Workbook workbook) {
        Sheet sheet;
        if (workbook.getSheet(sheetName) != null) {
            sheet = workbook.getSheet(sheetName);
        } else {
            sheet = workbook.createSheet(sheetName);
        }
        return sheet;
    }

    private Workbook getWorkbook(String filename, FileInputStream inputStream, Workbook workbook) throws IOException {
        if (filename.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        }
        if (filename.endsWith(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        return workbook;
    }

    public static void main(String... strings) throws IOException {
        String[] valueToWrite = {"Mr. E", "Noida"};
        String path = "D:\\IDE\\Project\\Java\\LearningSelenium\\Guru99\\src\\main\\resources";
        String filename = "test.xls";
        String sheetName = "Sheet1Java";
        WriteReadToExcel writeReadToExcel = new WriteReadToExcel();
        writeReadToExcel.writeToExcel(path, filename, sheetName, valueToWrite);

        writeReadToExcel.readFromExcel(path, filename, sheetName);
    }
}
