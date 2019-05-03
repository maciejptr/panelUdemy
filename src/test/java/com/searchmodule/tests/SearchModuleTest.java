package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SearchModuleTest extends BaseTest {
    private String keyWord;

    @BeforeTest
    @Parameters({"oLaLa"})
    public void setUpParameters(String oLaLa) {
        System.out.println("Uruchamiam SetUpParameters z SearchModuleTest");
        this.keyWord = oLaLa;
    }

    @Test
    public void search() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyWord);
        searchPage.goToVideos();
        int size = searchPage.getResult();
        Assert.assertTrue(size > 0);
    }

}
