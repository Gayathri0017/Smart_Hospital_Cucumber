package com.actions;

import com.pages.AccountantPage;
import com.utils.ExcelWriter;
import com.utils.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountantActions {
    private AccountantPage accountantPage;

    public AccountantActions() {
        this.accountantPage = new AccountantPage(HelperClass.getDriver());
    }

    public void selectRole(String role) {
        accountantPage.selectRole(role);
    }

    public void clickSignIn() {
        accountantPage.clickSignIn();
    }

    public void verifyDashboardNavigation() {
        try {
            if (!accountantPage.isDashboardDisplayed()) {
                throw new RuntimeException("Accountant dashboard not displayed. Current page: " + 
                    HelperClass.getDriver().getCurrentUrl());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to navigate to accountant dashboard: " + e.getMessage(), e);
        }
    }

    public void verifySummaryTable() {
        try {
            if (!accountantPage.isSummaryTableDisplayed()) {
                throw new RuntimeException("Dashboard summary table not visible after 15 seconds");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error verifying summary table: " + e.getMessage(), e);
        }
    }

    public void captureAndStoreData(String xpath, String filePath) {
        try {
            WebElement table = HelperClass.getDriver().findElement(By.xpath(xpath));
            String tableData = table.getText();
            
            System.out.println("=== Dashboard Table Data ===");
            System.out.println(tableData);
            
            ExcelWriter.writeTableData(filePath, "DashboardData", 
                accountantPage.convertTableDataToRows(tableData));
        } catch (Exception e) {
            throw new RuntimeException("Failed to capture and store table data: " + e.getMessage(), e);
        }
    }
}