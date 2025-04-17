package com.actions;

import com.pages.AccountantPageIncome;
import com.utils.HelperClass;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountantActionsIncome {
    private WebDriver driver;
    private WebDriverWait wait;
    private AccountantPageIncome accountantPageIncome;
    private static final Logger log = LogManager.getLogger(AccountantActionsIncome.class);

    public AccountantActionsIncome() {
        this.driver = HelperClass.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.accountantPageIncome = new AccountantPageIncome(driver);
        log.info("Initialized AccountantActionsIncome");
    }

    public void selectRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.accountantRoleButton)).click();
        log.info("Selected role: " + role);
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.signInButton)).click();
        log.info("Clicked Sign In button");
    }

    public void navigateToFinanceSection() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.financeSection)).click();
        log.info("Navigated to Finance section");
    }

    public void clickIncome() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.incomeButton)).click();
        log.info("Clicked Income button");
    }

    public void clickAddIncome() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.addIncomeButton)).click();
        log.info("Clicked Add Income button");
    }

    public void enterIncomeDetails(String header, String name, String amount) {
        accountantPageIncome.incomeHeaderField.sendKeys(header);
        accountantPageIncome.incomeNameField.sendKeys(name);
        accountantPageIncome.incomeAmountField.sendKeys(amount);
        log.info("Entered income details - Header: " + header + ", Name: " + name + ", Amount: " + amount);
    }

    public void clickSave() {
        accountantPageIncome.saveButton.click();
        log.info("Clicked Save button");
    }

    public void verifyIncomeAdded(String amount) {
        try {
            WebElement tableValueElement = wait.until(ExpectedConditions.visibilityOf(accountantPageIncome.tableValue));
            String tableValueText = tableValueElement.getText();
            if (!tableValueText.equals(amount)) {
                log.error("Mismatch in income amount. Expected: " + amount + ", Found: " + tableValueText);
                throw new AssertionError("The amount in the table does not match the given amount. Expected: " + amount + ", but found: " + tableValueText);
            } else {
                log.info("Income amount verified successfully: " + amount);
            }
        } catch (Exception e) {
            log.error("Error verifying income added", e);
            throw e;
        }
    }

    public boolean isErrorNotificationDisplayed() {
        try {
            boolean displayed = wait.until(ExpectedConditions.visibilityOf(accountantPageIncome.errorNotification)).isDisplayed();
            log.info("Error notification displayed: " + displayed);
            return displayed;
        } catch (Exception e) {
            log.error("Error notification not displayed", e);
            return false;
        }
    }

    public void Welcome() {
        log.info("Welcome method called");
        System.out.println("hi");
    }
}
