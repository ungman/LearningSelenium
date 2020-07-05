package io.github.ungman.learnig.seleniumwithtestng.kwd;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

public interface KWDOperation {

    void perfom(WebDriver webDriver, Properties properties, String operation, String objectName, String objectType, String value);
}
