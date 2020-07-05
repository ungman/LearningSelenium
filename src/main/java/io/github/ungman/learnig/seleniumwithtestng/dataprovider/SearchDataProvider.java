package io.github.ungman.learnig.seleniumwithtestng.dataprovider;

import org.testng.annotations.DataProvider;

public class SearchDataProvider {
    @DataProvider(name = "SearchProvider")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"UserRussia", "Russia"},
                {"UserUkraine", "Ukraine"},
                {"UserPolish", "Polish"}
        };
    }
}
