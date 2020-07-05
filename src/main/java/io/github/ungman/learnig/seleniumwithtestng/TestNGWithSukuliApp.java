package io.github.ungman.learnig.seleniumwithtestng;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class TestNGWithSukuliApp extends WebDriverInvocationRunner {

    @SneakyThrows
    @Test
    public void testSikuli() {
        String filePath = "D:\\IDE\\Project\\Java\\LearningSelenium\\Guru99\\src\\main\\resources\\sikuli\\";
        String inputFilePath = "D:\\IDE\\Project\\Java\\LearningSelenium\\Guru99\\src\\main\\resources\\sikuli\\";
        Pattern fileInputTextBox;
        fileInputTextBox = new Pattern(filePath + "FileTextBox.PNG");
        Pattern openButton = new Pattern(filePath + "OpenButton.PNG");
        Screen screen = new Screen();
        String url = "http://demo.guru99.com/test/image_upload/index.php";
        webDriver.get(url);
        WebElement photoimg = webDriver.findElement(By.id("photoimg"));
        new Actions(webDriver)
                .click(photoimg)
                .build()
                .perform();
        screen.wait(fileInputTextBox, 5);
        screen.type(fileInputTextBox, inputFilePath + "Test.docx");
        screen.click(openButton);
        // Close the browser
    }

}
