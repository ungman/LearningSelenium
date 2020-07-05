package io.github.ungman.learnig.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
        testForm();
        testCheckBox();
        System.exit(0);
    }

    private static void testCheckBox() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/radio.html";
            webDriver.get(baseUrl);
            WebElement radioButton1 = webDriver.findElement(By.id("vfb-7-1"));
            WebElement radioButton2 = webDriver.findElement(By.id("vfb-7-2"));
            radioButton1.click();
            System.out.println("RadioButton 1 click");
            radioButton2.click();
            System.out.println("RadioButton 2 click");

            WebElement checkbox1 = webDriver.findElement(By.id("vfb-6-0"));
            checkbox1.click();
            if (checkbox1.isSelected()) {
                System.out.println("Checkbox is Toggled On");
            } else {
                System.out.println("Checkbox is Toggled Off");
            }

            webDriver.get("http://demo.guru99.com/test/facebook.html");
            WebElement chkFBPersist = webDriver.findElement(By.id("persist_box"));
            for (int i = 0; i < 2; i++) {
                chkFBPersist.click();
                System.out.println("Facebook Persists Checkbox Status is -  " + chkFBPersist.isSelected());
            }
        } catch (Exception exception) {
            System.out.println("TEST FAILED");
            exception.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }

    private static void testForm() {
        WebDriver webDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/login.html";
            webDriver.get(baseUrl);
            WebElement email = webDriver.findElement(By.id("email"));
            WebElement password = webDriver.findElement(By.name("passwd"));

            email.clear();
            email.sendKeys("abcd@gmail.com");
            password.clear();
            password.sendKeys("abcdefghlkjl");
            System.out.println("Text field set");

            email.clear();
            password.clear();
            System.out.println("Text Field Cleared");
            WebElement login = webDriver.findElement(By.id("SubmitLogin"));


            // Using click method to submit form
            email.sendKeys("abcd@gmail.com");
            password.sendKeys("abcdefghlkjl");
            login.click();
            System.out.println("Login Done with Click");


            webDriver.get(baseUrl);
            webDriver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
            webDriver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
            webDriver.findElement(By.id("SubmitLogin")).submit();
            System.out.println("Login Done with Submit");
        } catch (Exception exception) {
            System.out.println("Test failed");
            exception.printStackTrace();
        } finally {
            webDriver.close();
        }
    }
}
