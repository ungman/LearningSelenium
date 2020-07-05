package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleDynamicTable {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
            testDynamicTable();
            testDynamicTableGetData();
            testDynamicTableGetMinMaxData();
            testDynamicTableGatAllData();
        } finally {
            System.exit(0);
        }
    }

    private static void testDynamicTableGatAllData() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/table.html";
            webDriver.get(baseUrl);
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            WebElement tBody = webDriver.findElement(By.xpath("/html/body/table/tbody"));
            List<WebElement> ListRows = tBody.findElements(By.tagName("tr"));
            for (WebElement row : ListRows) {
                List<WebElement> columnRow = row.findElements(By.tagName("td"));
                for (WebElement column : columnRow) {
                    String cellText = column.getText();
                    System.out.print("| "+cellText +" |");
                }
                System.out.println();
            }
        } catch (
                Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }

    }

    private static void testDynamicTableGetMinMaxData() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/web-table-element.php";
            webDriver.get(baseUrl);
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            WebElement baseTable = webDriver.findElement(By.tagName("table"));
            int sizeRows = baseTable.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr")).size();

            System.out.println("Table rows size: " + sizeRows);
            float[] minValue = new float[]{Integer.MAX_VALUE, -1};
            float[] maxValue = new float[]{Integer.MIN_VALUE, -1};
            for (int i = 1; i <= sizeRows; i++) {
                WebElement element = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[" + i + "]/td[4]"));
                Float val = Float.parseFloat(element.getText());
                if (minValue[0] > val) {
                    minValue[0] = val;
                    minValue[1] = i;
                }
                if (maxValue[0] < val) {
                    maxValue[0] = val;
                    maxValue[1] = i;
                }
            }
            System.out.println("Min value:" + minValue[0] + "[" + minValue[1] + "]");
            System.out.println("Max value:" + maxValue[0] + "[" + maxValue[1] + "]");
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void testDynamicTable() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/web-table-element.php";
            webDriver.get(baseUrl);
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            List col = webDriver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
            List rows = webDriver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
            System.out.println("Count col: " + col.size() + "; Count rows: " + rows.size());
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void testDynamicTableGetData() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/web-table-element.php";
            webDriver.get(baseUrl);
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            WebElement baseTable = webDriver.findElement(By.tagName("table"));
            WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
            String rowtext = tableRow.getText();
            System.out.println("Third row of table : " + rowtext);
            WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
            String valueIneed = cellIneed.getText();
            System.out.println("Cell value is : " + valueIneed);
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }
}
