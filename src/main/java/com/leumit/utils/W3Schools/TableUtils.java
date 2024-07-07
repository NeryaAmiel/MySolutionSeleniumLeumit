package com.leumit.utils.W3Schools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableUtils {

    public static String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        int rowCount = table.findElements(By.tagName("tr")).size();
        for (int i = 1; i < rowCount; i++) {
            try {
                WebElement cell = table.findElement(By.xpath(".//tr[" + (i + 1) + "]/td[" + searchColumn + "]"));
                if (cell.getText().equals(searchText)) {
                    return table.findElement(By.xpath(".//tr[" + (i + 1) + "]/td[" + returnColumnText + "]")).getText();
                }
            } catch (Exception e) {
                System.out.println("Exception occurred while retrieving table cell text: " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
        String actualText = getTableCellText(table, searchColumn, searchText, returnColumnText);
        return expectedText.equals(actualText);
    }

    public static String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) throws Exception {
        try {
            String xpath = ".//tr[td[" + searchColumn + "][text()='" + searchText + "']]/td[" + returnColumnText + "]";
            WebElement cell = table.findElement(By.xpath(xpath));
            return cell.getText();
        } catch (Exception e) {
            System.out.println("Exception occurred while retrieving table cell text: " + e.getMessage());
            return null;
        }
    }
}
