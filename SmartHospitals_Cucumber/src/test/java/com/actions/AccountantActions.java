package com.actions;

import com.pages.AccountantPage;
import com.utils.ExcelWriter;
import com.utils.HelperClass;
import org.openqa.selenium.By;
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

    public AccountantActions() {
        this.driver = HelperClass.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.accountantPage = new AccountantPage(driver);
    }

    public void selectRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPage.accountantRoleButton)).click();
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPage.signInButton)).click();
    }

    public boolean isSummaryTableDisplayed() {
        try {
            accountantPage.dashboard.click();
            return wait.until(ExpectedConditions.visibilityOf(accountantPage.summaryTable)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickExpensesMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPage.expensesMenu)).click();
    }

    public void clickAddExpenseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPage.addExpenseButton)).click();
    }

    public void selectExpenseHeader(String header) {
        Select dropdown = new Select(accountantPage.expenseHeaderDropdown);
        dropdown.selectByVisibleText(header);
    }

    public void enterExpenseName(String name) {
        accountantPage.expenseNameField.clear();
        accountantPage.expenseNameField.sendKeys(name);
    }

    public void enterExpenseAmount(String amount) {
        accountantPage.expenseAmountField.clear();
        accountantPage.expenseAmountField.sendKeys(amount);
    }

    public void clickSaveButton() {
        accountantPage.saveButton.click();
    }

    public boolean isSuccessNotificationDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(accountantPage.successNotification)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public List<List<String>> convertTableDataToRows(String tableData) {
        List<List<String>> rows = new ArrayList<>();
        String[] lines = tableData.split("\n");

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                String[] cells = line.split("\\s{2,}");
                rows.add(Arrays.asList(cells));
            }
        }
        return rows;
    }

    public boolean isErrorNotificationDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(accountantPage.errorNotification)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void captureAndStoreData(String xpath, String filePath) {
        try {
            WebElement table = driver.findElement(By.xpath(xpath));
            String tableData = table.getText();

            System.out.println("Dashboard Table Data");
            System.out.println(tableData);

            ExcelWriter.writeTableData(filePath, "DashboardData", convertTableDataToRows(tableData), true);
        } catch (Exception e) {
            throw new RuntimeException("Failed to capture and store table data: " + e.getMessage(), e);
        }
    }
}