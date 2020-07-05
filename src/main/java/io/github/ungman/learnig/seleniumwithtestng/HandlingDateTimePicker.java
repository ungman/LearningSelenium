package io.github.ungman.learnig.seleniumwithtestng;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class HandlingDateTimePicker extends WebDriverInvocationRunner {
    @Test
    public void dateTimePicker() {
        webDriver.get("http://demo.guru99.com/test/");
        WebElement dateBox = webDriver.findElement(By.xpath("//form//input[@name='bdaytime']"));
        dateBox.sendKeys("09252013");
        dateBox.sendKeys(Keys.TAB);
        dateBox.sendKeys("0245PM");
    }

    @SneakyThrows
    @Test
    public void testDatePicker() {
        String dateTime = "12/07/2014 2:00 PM";
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");
        WebElement nextLink = webDriver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));
        WebElement midLink = webDriver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-fast')]"));
        WebElement previousLink = webDriver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]"));
        String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");
        int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
        midLink.click();
        if (yearDiff != 0) {
            if (yearDiff > 0) {
                for (int i = 0; i < yearDiff; i++) {
                    System.out.println("Year Diff->" + i);
                    nextLink.click();
                }
            } else if (yearDiff < 0) {
                for (int i = 0; i < (yearDiff * (-1)); i++) {
                    System.out.println("Year Diff->" + i);
                    previousLink.click();
                }
            }
        }
        Thread.sleep(1000);
        List<WebElement> listAllMonthToBook = webDriver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
        listAllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();
        Thread.sleep(1000);
        List<WebElement> listAllDateToBook = webDriver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
        listAllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0]) - 1).click();
        WebElement selectTime = webDriver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));
        selectTime.click();
        List<WebElement> allTime = webDriver.findElements(By.xpath("//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']"));
        dateTime = dateTime.split(" ")[1] + " " + dateTime.split(" ")[2];
        for (WebElement webElement : allTime) {
            if (webElement.getText().equalsIgnoreCase(dateTime)) {
                webElement.click();
            }
        }
    }

}
