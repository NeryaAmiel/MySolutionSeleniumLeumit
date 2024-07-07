package com.leumit.pages.Guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99BankHomePage {
    WebDriver driver;

    @FindBy(id = "navbar-brand-centered")
    WebElement topMenu;

    public Guru99BankHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getTopMenu() {
        return topMenu;
    }

    public WebElement getSubMenu(WebElement selectedInTopMenuElement, String subMenuItem){
        WebElement subItem;
        subItem = selectedInTopMenuElement.findElement(By.xpath(STR."./ancestor::li/ul/li[a[text()='\{subMenuItem}']]"));
        return subItem;
    }

}
