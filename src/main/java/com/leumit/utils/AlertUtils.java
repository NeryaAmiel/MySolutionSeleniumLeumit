package com.leumit.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertUtils {

    public static boolean isAdAlertPresent(WebDriver driver) {
        try {
            WebElement bodyElement = driver.findElement(By.tagName("body"));
            String ariaHidden = bodyElement.getAttribute("aria-hidden");
            return "true".equals(ariaHidden);
        } catch (NoSuchElementException | NullPointerException e) {
            return false;
        }
    }

    public static void closeAdAlertIfPresent(WebDriver driver) {
        if (isAdAlertPresent(driver)) {
            try {
                // Perform an action to dismiss the ad alert by clicking on the page
                Actions actions = new Actions(driver);
                actions.moveByOffset(0, 0).click().perform();

                // Wait for the body element to have no attribute - aria-hidden
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until((WebDriver d) -> {
                    WebElement bodyElement = d.findElement(By.tagName("body"));
                    return bodyElement.getAttribute("aria-hidden") == null;
                });
                Thread.sleep(2000);
            } catch (Exception e) {
                // Log the exception if the click action fails
                System.err.println("Failed to close the ad alert: " + e.getMessage());
            }
        }
    }
//    public static void closeAdAlertIfPresent(WebDriver driver) {
//        if (isAdAlertPresent(driver)) {
//            // Perform an action to dismiss the ad alert by clicking on the page
//            Actions actions = new Actions(driver);
//            actions.click().perform();
//            // Wait for the body element to have no attribute - aria-hidden
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until((WebDriver d)  -> {
//                WebElement bodyElement = d.findElement(By.tagName("body"));
//                return bodyElement.getAttribute("aria-hidden") == null;
//            });
//        }
//    }

}
