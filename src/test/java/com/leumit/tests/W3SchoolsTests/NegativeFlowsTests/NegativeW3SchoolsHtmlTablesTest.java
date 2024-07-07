package com.leumit.tests.W3SchoolsTests.NegativeFlowsTests;

import com.leumit.pages.W3Schools.W3SchoolsHtmlTablesPage;
import com.leumit.utils.W3Schools.TableUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NegativeW3SchoolsHtmlTablesTest {
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
    public void testGetTableCellTextSearchTextNotExists() {
        int searchColumn = 1;
        String searchText = "Not Exists";
        int returnColumnText = 3;
        String expectedResult = TableUtils.getTableCellText(tablePage.getTable(), searchColumn, searchText, returnColumnText);
        Assert.assertNull(expectedResult);
    }

    @Test
    public void testGetTableCellTextSearchColumnNotExists() {
        //Expectation: return - null
        int searchColumn = 10; // Non-existent column
        String searchText = "Island Trading";
        int returnColumnText = 3;
        String expectedResult;
        try {
            expectedResult = TableUtils.getTableCellText(tablePage.getTable(), searchColumn, searchText, returnColumnText);
            Assert.assertNull(expectedResult,"Expected Result value to be null");
        } catch (Exception e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }


    @Test
    public void testGetTableCellTextReturnColumnTextNotExists() {
        //Expectation: return - null
        int searchColumn = 1;
        String searchText = "Island Trading";
        int returnColumnText = 10; // Non-existent column
        String expectedResult;
        try {
            expectedResult = TableUtils.getTableCellText(tablePage.getTable(), searchColumn, searchText, returnColumnText);
            Assert.assertNull(expectedResult,"Expected Result value to be null");
        } catch (Exception e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testVerifyTableCellTextSearchTextNotExists() {
        //Expectation: return - false
        int searchColumn = 1;
        String searchText = "Not Exists";
        int returnColumnText = 3;
        String expectedResult = "UK";
        boolean result = TableUtils.verifyTableCellText(tablePage.getTable(), searchColumn, searchText, returnColumnText, expectedResult);
        Assert.assertFalse(result);
    }

    @Test
    public void testVerifyTableCellTextSearchColumnNotExists() {
        //Expectation: return - false
        int searchColumn = 10; // Non-existent column
        String searchText = "Island Trading";
        int returnColumnText = 3;
        String expectedResult = "UK";
        try {
            boolean result = TableUtils.verifyTableCellText(tablePage.getTable(), searchColumn, searchText, returnColumnText, expectedResult);
            Assert.assertFalse(result);
        } catch (Exception e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testVerifyTableCellTextWrongExpectedResult() {
        //Expectation: return - false
        int searchColumn = 1;
        String searchText = "Island Trading";
        int returnColumnText = 3;
        String expectedResult = "WrongExpected";
        boolean result = TableUtils.verifyTableCellText(tablePage.getTable(), searchColumn, searchText, returnColumnText, expectedResult);
        Assert.assertFalse(result);
    }

    @Test
    public void testGetTableCellTextByXpathSearchTextNotExists() throws Exception {
        int searchColumn = 2;
        String searchText = "Not Exists";
        int returnColumnText = 1;
        String expectedResult = TableUtils.getTableCellTextByXpath(tablePage.getTable(), searchColumn, searchText, returnColumnText);
        Assert.assertNull(expectedResult);
    }

    @Test
    public void testGetTableCellTextByXpathReturnColumnTextNotExists() throws Exception {
        int searchColumn = 3;
        String searchText = "Germany";
        int returnColumnText = 10; // Non-existent column
        try {
            String expectedResult = TableUtils.getTableCellTextByXpath(tablePage.getTable(), searchColumn, searchText, returnColumnText);
            Assert.assertNull(expectedResult);
        } catch (Exception e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
