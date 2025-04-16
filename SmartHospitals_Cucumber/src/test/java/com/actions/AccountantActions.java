package com.actions;

import com.pages.AccountantPage;
import com.utils.ExcelWriter;
import com.utils.HelperClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class AccountantActions {
    private AccountantPage accountantPage;
    private static final Logger logger=LogManager.getLogger(AccountantActions.class);
    public AccountantActions() {
        this.accountantPage=new AccountantPage(HelperClass.getDriver());
        logger.info("Initialized AccountantPage");
    }
    public void selectRole(String role) {
        logger.info("Selecting role: "+role);
        accountantPage.selectRole(role);
    }
    public void clickSignIn() {
        logger.info("Clicking Sign In button");
        accountantPage.clickSignIn();
    }
    public void verifySummaryTable() {
        try {
            logger.info("Verifying if summary table is displayed");
            if (!accountantPage.isSummaryTableDisplayed()) {
                throw new RuntimeException("Dashboard summary table not visible after 15 seconds");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error verifying summary table: "+e.getMessage(), e);
        }
    }
    public void captureAndStoreData(String xpath, String filePath) {
        try {
            logger.info("Capturing table data using xpath: "+xpath);
            WebElement table=HelperClass.getDriver().findElement(By.xpath(xpath));
            String tableData=table.getText();
            logger.info("Dashboard Table Data:\n"+tableData);
            ExcelWriter.writeTableData(filePath, "DashboardData", 
                accountantPage.convertTableDataToRows(tableData), true);
            logger.info("Table data written to Excel at: "+filePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to capture and store table data: "+e.getMessage(), e);
        }
    }
    public void navigateToExpenses() {
        logger.info("Navigating to Expenses");
        accountantPage.clickExpensesMenu();
    }
    public void clickAddExpense() {
        logger.info("Clicking Add Expense button");
        accountantPage.clickAddExpenseButton();
    }
    public void addNewExpense(String header, String name, String amount) {
        logger.info("Adding new expense - Header: "+header+", Name: "+name+", Amount: "+amount);
        accountantPage.selectExpenseHeader(header);
        accountantPage.enterExpenseName(name);
        accountantPage.enterExpenseAmount(amount);
    }
    public void saveExpense() {
        logger.info("Clicking Save button for expense");
        accountantPage.clickSaveButton();
    }
    public void verifySuccessNotification() {
        logger.info("Verifying success notification after saving expense");
        if (!accountantPage.isSuccessNotificationDisplayed()) {
            throw new RuntimeException("Success notification not displayed after saving expense");
        }
        logger.info("Success notification displayed");
    }
    public void isErrorNotificationDisplayed() {
        logger.info("Verifying error notification after saving invalid expense");
        if (!accountantPage.isErrorNotificationDisplayed()) {
            throw new RuntimeException("Error notification not displayed after saving expense with invalid data");
        }
        logger.info("Error notification displayed");
    }
}
