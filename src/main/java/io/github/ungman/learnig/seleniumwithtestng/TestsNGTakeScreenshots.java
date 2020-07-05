package io.github.ungman.learnig.seleniumwithtestng;

import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TestsNGTakeScreenshots extends WebDriverInvocationRunner {
    String pathToSave = "D:\\IDE\\Project\\Java\\LearningSelenium\\Guru99\\src\\main\\resources\\snapshot";
    String nameScreenshot = "testSnapShot.png";

    @Test
    public void testTakeScreenshot() {
        String baseUrl = "http://demo.guru99.com/V4/";
        this.takeSnapShot(webDriver, pathToSave + "\\" + nameScreenshot);
    }

    private void takeSnapShot(WebDriver webDriver, String filePath) {
        TakesScreenshot screenshot = ((TakesScreenshot) webDriver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile=new File(filePath);
        copyWithNio(srcFile,destFile);
    }

    @SneakyThrows
    private void copyWithNio(File origFile, File destFile){
        Files.copy(origFile.toPath(),destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    @SneakyThrows
    @Test
    public void testSnapShotWithAshotLib(){
        String url = "http://demo.guru99.com/test/guru99home/";
        webDriver.get(url);
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(webDriver);
        ImageIO.write(screenshot.getImage(),"jpg",new File(pathToSave+"\\ashot1.jpg"));
    }

    @Test
    public void testParticualElement() throws IOException {
        String url = "http://demo.guru99.com/test/guru99home/";
        webDriver.get(url);
        WebElement element = webDriver.findElement(By.xpath ("//*[@id=\"site-name\"]/a[1]/img"));
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(webDriver,element);
        ImageIO.write(screenshot.getImage(),"jpg",new File(pathToSave+"\\ashot1LogoElem.jpg"));
    }

    @SneakyThrows
    @Test
    public void testImageComporation(){
        String url = "http://demo.guru99.com/test/guru99home/";
        webDriver.get(url);

        WebElement logoElement = webDriver.findElement(By.xpath("//*[@id=\"site-name\"]/a[1]/img"));
        Screenshot logoElementScreenshot = new AShot().takeScreenshot(webDriver, logoElement);
        BufferedImage expectedImage = ImageIO.read(new File(pathToSave+"\\ashot1LogoElem.jpg"));
        BufferedImage actualImage = logoElementScreenshot.getImage();
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        if (diff.hasDiff() == true) {
            System.out.println("Images are same");

        } else {
            System.out.println("Images are different");
        }
    }
}
