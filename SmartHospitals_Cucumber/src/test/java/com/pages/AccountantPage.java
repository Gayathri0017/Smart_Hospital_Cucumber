package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountantPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AccountantPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div[3]/a[1]")
    private WebElement accountantRoleButton;

    @FindBy(css = "button.btn[type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//h2[contains(text(),'Accountant Dashboard')]")
    private WebElement dashboardTitle;

    @FindBy(xpath = "//*[@id=\"sibe-box\"]/ul[2]/li[1]/a")
    private WebElement dashboard;

    @FindBy(xpath = "/html/body/div[1]/div[1]/section/div[2]")
    private WebElement summaryTable;

    @FindBy(xpath = "/html/body/div[1]/div[1]/section/div[2]/div[9]/div/a/div")
    private WebElement expensesMenu;

    @FindBy(css = "a.btn.btn-primary")
    private WebElement addExpenseButton;

    @FindBy(id = "exp_head_id")
    private WebElement expenseHeaderDropdown;

    @FindBy(id = "name")
    private WebElement expenseNameField;

    @FindBy(id = "amount")
    private WebElement expenseAmountField;

    @FindBy(id = "addexpensebtn")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id='toast-container']/div/div")
    private WebElement successNotification;

    @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
    private WebElement errorNotification;
    
    public void selectRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(accountantRoleButton)).click();
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public boolean isSummaryTableDisplayed() {
        try {
            dashboard.click();
            return wait.until(ExpectedConditions.visibilityOf(summaryTable)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickExpensesMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(expensesMenu)).click();
    }

    public void clickAddExpenseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addExpenseButton)).click();
    }

    public void selectExpenseHeader(String header) {
        Select dropdown = new Select(expenseHeaderDropdown);
        dropdown.selectByVisibleText(header);
    }

    public void enterExpenseName(String name) {
        expenseNameField.clear();
        expenseNameField.sendKeys(name);
    }

    public void enterExpenseAmount(String amount) {
        expenseAmountField.clear();
        expenseAmountField.sendKeys(amount);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public boolean isSuccessNotificationDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(successNotification)).isDisplayed();
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
            return wait.until(ExpectedConditions.visibilityOf(errorNotification)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}