package com.leumit.tests.W3SchoolsTests.PositiveFlowsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.leumit.pages.W3Schools.W3SchoolsHtmlTablesPage;
import com.leumit.utils.W3Schools.TableUtils;

public class PositiveW3SchoolsHtmlTablesTest {
    WebDriver driver;
    W3SchoolsHtmlTablesPage tablePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Nerya\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.w3schools.com/html/html_tables.asp");
        tablePage = new W3SchoolsHtmlTablesPage(driver);
    }

    @Test
    public void testGetTableCellText() {
        int searchColumn = 1;
        String searchText = "Island Trading";
        int returnColumnText = 3;
        String expectedResult = "UK";
        String country = TableUtils.getTableCellText(tablePage.getTable(), searchColumn, searchText, returnColumnText);
        Assert.assertEquals(country, expectedResult);
    }

    @Test
    public void testVerifyTableCellText() {
        int searchColumn = 1;
        String searchText = "Island Trading";
        int returnColumnText = 3;
        String expectedResult = "UK";
        boolean result = TableUtils.verifyTableCellText(tablePage.getTable(), searchColumn, searchText, returnColumnText, expectedResult);
        Assert.assertTrue(result);
    }

    @Test
    public void testGetTableCellTextByXpath() throws Exception {
        int searchColumn = 2;
        String searchText = "Maria Anders";
        int returnColumnText = 1;
        String expectedResult = "Alfreds Futterkiste";
        String country = TableUtils.getTableCellTextByXpath(tablePage.getTable(), searchColumn, searchText, returnColumnText);
        Assert.assertEquals(country, expectedResult);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
