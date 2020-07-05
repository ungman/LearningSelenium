package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWebTable {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
            testSimpleTable();
            testNestedTable();
            testWithAttribute();
            testBigPathTable();
        } finally {
            System.exit(0);
        }
    }

    private static void testBigPathTable() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/newtours/";
            webDriver.get(baseUrl);
            String innerText = webDriver.findElement(By
                    .xpath("//table/tbody/tr/td[2]"
                            + "/table/tbody/tr[4]/td/"
                            + "table/tbody/tr/td[2]/"
                            + "table/tbody/tr[2]/td[1]/"
                            + "table[2]/tbody/tr[3]/td[2]/font"))
                    .getText();
            System.out.println(innerText);
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();

        } finally {
            webDriver.quit();
        }

    }

    private static void testWithAttribute() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/newtours/";
            webDriver.get(baseUrl);
            String innerText = webDriver.findElement(By.xpath("//table[@width=\"270\"]/tbody/tr/td")).getText();
            System.out.println(innerText);
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void testNestedTable() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/accessing-nested-table.html";
            webDriver.get(baseUrl);
            String nestedTableText = webDriver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]")).getText();
            System.out.println(nestedTableText);
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void testSimpleTable() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/write-xpath-table.html";
            webDriver.get(baseUrl);
            String innerText = webDriver.findElement((By.xpath("//table/tbody/tr[2]/td[2]"))).getText();
            System.out.println(innerText);
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }

    }

}
