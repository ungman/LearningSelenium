package io.github.ungman.learnig.seleniumwithtestng;

import org.apache.commons.lang3.text.StrTokenizer;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Date;

public class TestNGCookieHandler extends WebDriverInvocationRunner {
    String path = "D:\\IDE\\Project\\Java\\LearningSelenium\\Guru99\\src\\main\\resources\\cookie.data";

    @Test
    public void testSaveCookieToFile() {
        String url = "http://demo.guru99.com/test/cookie/selenium_aut.php";
        webDriver.get(url);
        webDriver.findElement(By.name("username")).sendKeys("abc123");
        webDriver.findElement(By.name("password")).sendKeys("123xyz");
        webDriver.findElement(By.name("submit")).click();
        File file = new File(path);

        try {
            file.delete();
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cookie cookie : webDriver.manage().getCookies()) {
                bufferedWriter.write((cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";" + cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

@Test
    public void testCookieReadToLogin() {
        File file = new File(path);
        String url = "http://demo.guru99.com/test/cookie/selenium_aut.php";
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String sline;
            while ((sline = bufferedReader.readLine()) != null) {
                StrTokenizer tokenizer = new StrTokenizer(sline, ";");
                while (tokenizer.hasNext()) {
                    String name = tokenizer.nextToken();
                    String value = tokenizer.nextToken();
                    String domain = tokenizer.nextToken();
                    String path = tokenizer.nextToken();
                    Date expiry = null;
                    String val;
                    if (!(val = tokenizer.nextToken()).equals("null")) {
                        expiry = new Date(val);
                    }
                    Boolean isSecure = new Boolean(tokenizer.hasNext()).booleanValue();
                    Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
                    System.out.println("Cookie : "+ck);
                    webDriver.manage().addCookie(ck);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        webDriver.get(url);
    }
}
