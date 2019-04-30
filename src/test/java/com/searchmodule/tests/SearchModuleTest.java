package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchModuleTest {
    private WebDriver driver;
    private String keyWord;

    @BeforeTest
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        this.driver = new ChromeDriver();
    }

    @Test
    @Parameters({"oLaLa"})
    public void search(String oLaLa) {
        this.keyWord = oLaLa;
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyWord);
        searchPage.goToVideos();
        int size = searchPage.getResult();
        Assert.assertTrue(size > 0);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
