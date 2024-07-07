package com.leumit.pages.W3Schools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3SchoolsHtmlTablesPage {
    WebDriver driver;

    @FindBy(xpath = "//table[@id='customers']")
    WebElement table;

    public W3SchoolsHtmlTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getTable() {
        return table;
    }
}
