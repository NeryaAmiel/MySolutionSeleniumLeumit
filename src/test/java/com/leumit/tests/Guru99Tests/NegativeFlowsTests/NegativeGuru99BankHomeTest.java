package com.leumit.tests.Guru99Tests.NegativeFlowsTests;

import com.leumit.pages.Guru99.Guru99BankHomePage;
import com.leumit.utils.Guru99.MenuUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NegativeGuru99BankHomeTest {
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

    @Test
    public void testNegativeSelectTopMenuItemNotExist() throws InterruptedException {
        boolean exceptionThrown = false;
        String topMenuNotExist = "Fake selection";
        try {
            MenuUtils.selectMenuItem(driver, topMenuNotExist);
        } catch (NoSuchElementException e) {
            exceptionThrown = true;
            String expectedMessage = STR."Could not find Top menu item: \{topMenuNotExist}";
            Assert.assertTrue(e.getMessage().contains(expectedMessage), "Exception message does not match");
        }
        Assert.assertTrue(exceptionThrown, "Expected NoSuchElementException was not thrown");
    }

    @Test
    public void testNegativeIncorrectParametersOrder() throws InterruptedException {
        //Sending top and sub menu details exist, but in reverse order
        //expectation: fail on the top menu item error
        boolean exceptionThrown = false;
        String topMenuExist = "Selenium";
        String subMenuExist = "Yahoo";
        try {
            MenuUtils.selectMenuItem(driver, subMenuExist,topMenuExist);
        } catch (NoSuchElementException e) {
            exceptionThrown = true;
            String expectedMessage = STR."Could not find Top menu item: \{subMenuExist}";
            Assert.assertTrue(e.getMessage().contains(expectedMessage), "Exception message does not match");
        }
        Assert.assertTrue(exceptionThrown, "Expected NoSuchElementException was not thrown");
    }

    @Test
    public void testNegativeSelectSubMenuItemAsTopMenuItem() throws InterruptedException {
        //Sending a sub-item without its parent item
        //expectation: fail on the top menu item error
        boolean exceptionThrown = false;
        String subMenuExist = "Table Demo";
        try {
            MenuUtils.selectMenuItem(driver, subMenuExist);
        } catch (NoSuchElementException e) {
            exceptionThrown = true;
            String expectedMessage = STR."Could not find Top menu item: \{subMenuExist}";
            Assert.assertTrue(e.getMessage().contains(expectedMessage), "Exception message does not match");
        }
        Assert.assertTrue(exceptionThrown, "Expected NoSuchElementException was not thrown");
    }

    @Test
    public void testNegativeSelectTwoTopMenuItemsExist() throws InterruptedException {
        //Sending a TwoTopMenuItemsExist, one of them sending as sub-item
        //expectation: fail on the sub menu item error
        boolean exceptionThrown = false;
        String topMenuExist1 = "Selenium";
        String topMenuExist2 = "New Tours";
        try {
            MenuUtils.selectMenuItem(driver, topMenuExist1,topMenuExist2);
        } catch (NoSuchElementException e) {
            exceptionThrown = true;
            String expectedMessage = STR."Could not find SUB menu item: \{topMenuExist2}";
            Assert.assertTrue(e.getMessage().contains(expectedMessage), "Exception message does not match");
        }
        Assert.assertTrue(exceptionThrown, "Expected NoSuchElementException was not thrown");
    }

    @Test
    public void testNegativeSelectTopMenuExistSubMenuNotExist() throws InterruptedException {
        boolean exceptionThrown = false;
        String topMenuExist = "Selenium";
        String subMenuNotExist = "Fake selection";
        try {
            MenuUtils.selectMenuItem(driver, topMenuExist, subMenuNotExist);
        } catch (NoSuchElementException e) {
            exceptionThrown = true;
            String expectedMessage = STR."Could not find SUB menu item: \{subMenuNotExist}";
            Assert.assertTrue(e.getMessage().contains(expectedMessage), "Exception message does not match");
        }
        Assert.assertTrue(exceptionThrown, "Expected NoSuchElementException was not thrown");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}