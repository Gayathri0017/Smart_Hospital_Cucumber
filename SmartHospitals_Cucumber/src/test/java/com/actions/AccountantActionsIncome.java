package com.actions;

import com.pages.AccountantPageIncome;
import com.utils.HelperClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountantActionsIncome {
    private WebDriver driver;
    private WebDriverWait wait;
    private AccountantPageIncome accountantPageIncome;

    public AccountantActionsIncome() {
        this.driver = HelperClass.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.accountantPageIncome = new AccountantPageIncome(driver);
    }

    public void selectRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.accountantRoleButton)).click();
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.signInButton)).click();
    }

    public void navigateToFinanceSection() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.financeSection)).click();
    }

    public void clickIncome() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.incomeButton)).click();
    }

    public void clickAddIncome() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.addIncomeButton)).click();
    }

    public void enterIncomeDetails(String header, String name, String amount) {
        accountantPageIncome.incomeHeaderField.sendKeys(header);
        accountantPageIncome.incomeNameField.sendKeys(name);
        accountantPageIncome.incomeAmountField.sendKeys(amount);
    }

    public void clickSave() {
        accountantPageIncome.saveButton.click();
    }

    public void verifyIncomeAdded(String amount) {
        try {

            WebElement tableValueElement = wait.until(ExpectedConditions.visibilityOf(accountantPageIncome.tableValue));
            String tableValueText = tableValueElement.getText();
            if (!tableValueText.equals(amount)) {
                throw new AssertionError("The amount in the table does not match the given amount. Expected: " + amount + ", but found: " + tableValueText);
            } else {
                System.out.println("The amount in the table matches the given amount: " + amount);
            }
        } catch (Exception e) {
            System.err.println("Error verifying income added: " + e.getMessage());
            throw e;
        }
    }
    
    public boolean isErrorNotificationDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(accountantPageIncome.errorNotification)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void Welcome() {
    	System.out.println("hi");
    }
}