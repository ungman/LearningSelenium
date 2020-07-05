package io.github.ungman.testing;

import io.github.ungman.learnig.seleniumwithtestng.WebDriverInvocationRunner;
import io.github.ungman.testing.pages.HomePage;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGGuru99TestPage extends WebDriverInvocationRunner {

    private  HomePage homePage;
    private final String url = "http://demo.guru99.com/test/guru99home/";

    @BeforeClass
    public void postConstructor(){
        homePage=new HomePage(webDriver);
    }

    @BeforeMethod
    public void initPage() {
        webDriver.get(url);
    }

    @SneakyThrows
    @Test
    public void testPageCorrect() {
        String expectedUrl = "http://demo.guru99.com/test/guru99home/";
        String expectedTitle = "Demo Guru99 Page";
        String actualUrl = webDriver.getCurrentUrl();
        String actualTitle = webDriver.getTitle();
        AssertJUnit.assertEquals("URL not equals", expectedUrl, actualUrl);
        AssertJUnit.assertEquals("Title not equals", expectedTitle, actualTitle);
    }

    @Test
    public void testHomeSiteNavigateBar() {
        WebElement navBarSite = homePage.getNavBarSite();
        AssertJUnit.assertNotNull("Navigation bar site not found", navBarSite);
    }

    @Test
    public void testVisibleHomeSiteNavigateBar() {
        WebElement navBarSite = homePage.getNavBarSite();
        AssertJUnit.assertNotNull("Navigation bar site not found", navBarSite);
        AssertJUnit.assertTrue("Navigation bar site not visible ", navBarSite.isDisplayed());
    }
}
