package com.actions;

import com.pages.AccountantPage;
import com.utils.ExcelWriter;
import com.utils.HelperClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountantActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private AccountantPage accountantPage;
    private static final Logger log = LogManager.getLogger(AccountantActions.class);
//constructor
    public AccountantActions() {
        this.driver = HelperClass.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.accountantPage = new AccountantPage(driver);
        log.info("Initialized AccountantActions");
    }

    public void selectRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPage.accountantRoleButton)).click();
        log.info("Selected role: {}", role);

    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPage.signInButton)).click();
        log.info("Clicked Sign In button");
    }

    public boolean isSummaryTableDisplayed() {
        try {
            accountantPage.dashboard.click();
            boolean displayed = wait.until(ExpectedConditions.visibilityOf(accountantPage.summaryTable)).isDisplayed();
            log.info("Summary table displayed: " , displayed);
            return displayed;
        } catch (Exception e) {
            log.error("Summary table not displayed", e);
            return false;
        }
    }

    public void clickExpensesMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPage.expensesMenu)).click();
        log.info("Clicked Expenses menu");
    }

    public void clickAddExpenseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPage.addExpenseButton)).click();
        log.info("Clicked Add Expense button");
    }

    public void selectExpenseHeader(String header) {
        wait.until(ExpectedConditions.visibilityOf(accountantPage.expenseHeaderDropdown));
        Select dropdown = new Select(accountantPage.expenseHeaderDropdown);
        dropdown.selectByVisibleText(header);
        log.info("Selected Expense Header: " , header);
    }

    public void enterExpenseName(String name) {
    	accountantPage.expenseNameField.sendKeys(name);
        log.info("Entered Expense Name: " , name);
    }

    public void enterExpenseAmount(String amount) {
        accountantPage.expenseAmountField.clear();
        accountantPage.expenseAmountField.sendKeys(amount);
        log.info("Entered Expense Amount: " , amount);
    }

    public void clickSaveButton() {
        accountantPage.saveButton.click();
        log.info("Clicked Save button");
    }

    public boolean isSuccessNotificationDisplayed() {
        try {
            boolean displayed = wait.until(ExpectedConditions.visibilityOf(accountantPage.successNotification)).isDisplayed();
            log.info("Success notification displayed: " , displayed);
            return displayed;
        } catch (Exception e) {
            log.error("Success notification not displayed", e);
            return false;
        }
    }
//converting to the table data
    public List<List<String>> convertTableDataToRows(String tableData) {
        List<List<String>> rows = new ArrayList<>();
        String[] lines = tableData.split("\n");

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
            	//if there is 2 or more space it will split
                String[] cells = line.split("\\s{2,}");
                rows.add(Arrays.asList(cells));
            }
        }

        log.info("Converted table data to rows with " + rows.size() + " entries");
        return rows;
    }

    public boolean isErrorNotificationDisplayed() {
        try {
            boolean displayed = wait.until(ExpectedConditions.visibilityOf(accountantPage.errorNotification)).isDisplayed();
            log.info("Error notification displayed: " , displayed);
            return displayed;
        } catch (Exception e) {
            log.error("Error notification not displayed", e);
            return false;
        }
    }

    public void captureAndStoreData(String xpath, String filePath) {
        try {
            WebElement table = driver.findElement(By.xpath(xpath));
            String tableData = table.getText();
            log.info("Captured dashboard table data");
            System.out.println(tableData);
            ExcelWriter.writeTableData(filePath, "DashboardData", convertTableDataToRows(tableData), true);
            log.info("Stored dashboard table data to Excel at: " + filePath);
        } catch (Exception e) {
            log.error("Failed to capture and store table data", e);
            throw new RuntimeException("Failed to capture and store table data: " + e.getMessage(), e);
        }
    }
}
