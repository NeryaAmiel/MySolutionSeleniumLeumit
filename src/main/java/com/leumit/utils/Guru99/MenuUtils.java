package com.leumit.utils.Guru99;

import com.aventstack.extentreports.Status;
import com.leumit.pages.Guru99.Guru99BankHomePage;
import com.leumit.utils.AlertUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.leumit.ExtentManager;


public class MenuUtils {
    public static Guru99BankHomePage bankHomePage;

    private static void initialize(WebDriver driver) {
        if (bankHomePage == null) {
            bankHomePage = new Guru99BankHomePage(driver);
        }
    }

    public static void selectMenuItem(WebDriver driver, String menuItem) throws InterruptedException {
        // Check if menuItem contains ';'
        if (menuItem.contains(";")) {
            String[] parts = menuItem.split(";");
            selectMenuItem(driver, parts[0], parts[1]);
        } else {
            selectMenuItem(driver, menuItem, "");
        }
    }

    public static void selectMenuItem(WebDriver driver, String menuItem, String subMenuItem) throws InterruptedException {
        initialize(driver);
        WebElement menu = bankHomePage.getTopMenu();

        WebElement item = null;
        WebElement subItem = null;
        try {
            item = menu.findElement(By.linkText(menuItem));
            item.click();
        } catch (NoSuchElementException e) {
            String errorMsg = "Could not find Top menu item: " + menuItem;
            ExtentManager.getTest().log(Status.INFO, errorMsg);
            throw new NoSuchElementException(errorMsg, e);
        }
        if (subMenuItem != null && !subMenuItem.isEmpty()) {
            try {
                subItem = bankHomePage.getSubMenu(item, subMenuItem);
                System.out.println(subItem.getText());
                subItem.click();
            } catch (NoSuchElementException e) {
                String errorMsg = "Could not find SUB menu item: " + subMenuItem;
                ExtentManager.getTest().log(Status.INFO, errorMsg);
                throw new NoSuchElementException(errorMsg, e);
            }
            AlertUtils.closeAdAlertIfPresent(driver); // Check and close any alert
        }
    }
}

