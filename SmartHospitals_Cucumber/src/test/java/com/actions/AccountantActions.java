package com.actions;

import com.pages.AccountantPage;
import com.utils.ExcelWriter;
import com.utils.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
                accountantPage.convertTableDataToRows(tableData), true);
        } catch (Exception e) {
            throw new RuntimeException("Failed to capture and store table data: " + e.getMessage(), e);
        }
    }

    public void navigateToExpenses() {
        accountantPage.clickExpensesMenu();
    }

    public void clickAddExpense() {
        accountantPage.clickAddExpenseButton();
    }

    public void addNewExpense(String header, String name, String amount) {
        accountantPage.selectExpenseHeader(header);
        accountantPage.enterExpenseName(name);
        accountantPage.enterExpenseAmount(amount);
    }

    public void saveExpense() {
        accountantPage.clickSaveButton();
    }

    public void verifySuccessNotification() {
        if (!accountantPage.isSuccessNotificationDisplayed()) {
            throw new RuntimeException("Success notification not displayed after saving expense");
        }
    }
    
    public void isErrorNotificationDisplayed() {
    	if (!accountantPage.isErrorNotificationDisplayed()) {
            throw new RuntimeException("Error notification not displayed after saving expense with invalid data");
        }
    }
}