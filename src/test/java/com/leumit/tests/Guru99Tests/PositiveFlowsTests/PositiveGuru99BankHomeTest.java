package com.leumit.tests.Guru99Tests.PositiveFlowsTests;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.leumit.ExtentManager;

import com.leumit.pages.Guru99.Guru99BankHomePage;
import com.leumit.utils.Guru99.*;



public class PositiveGuru99BankHomeTest {
    WebDriver driver;
    Guru99BankHomePage bankHomePage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Nerya\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/");
        bankHomePage = new Guru99BankHomePage(driver);
    }

    @Test(dataProvider = "testSingleSearchFieldData")
    public void testSingleSearchField(String searchItem,  String expectedTitle) throws InterruptedException {
        MenuUtils.selectMenuItem(driver, searchItem);
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    @Test(dataProvider = "testTwoSearchFieldsData")
    public void testTwoSearchFields(String topMenuSearch, String subMenuSearch, String expectedTitle) throws InterruptedException {
        MenuUtils.selectMenuItem(driver, topMenuSearch, subMenuSearch);
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    @DataProvider(name = "testSingleSearchFieldData")
    public Object[][] getSingleSearchFieldTestData() {
        return Guru99DataProvider.getSingleSearchFieldData();
    }

    @DataProvider(name = "testTwoSearchFieldsData")
    public Object[][] getTwoSearchFieldsTestData() {
        return Guru99DataProvider.getTwoSearchFieldsData();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}