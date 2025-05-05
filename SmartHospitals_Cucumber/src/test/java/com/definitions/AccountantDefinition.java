package com.definitions;

import org.testng.Assert;

import com.actions.AccountantActions;
import com.pages.AccountantPage;
import com.utils.HelperClass;
import io.cucumber.java.en.*;

public class AccountantDefinition {
    private AccountantActions accountantActions;
    private AccountantPage accountantPage;
    private String excelFilePath = "target/dashboard_data.xlsx";

    @Given("User launches the Smart Hospital application")
    public void launchApplication() {
        accountantActions = new AccountantActions();
    }

    @When("the user selects role {string}")
    public void selectRole(String role) {
        accountantActions.selectRole(role);
    }

    @When("the user clicks the Sign In buttons")
    public void clickSignIn() {
        accountantActions.clickSignIn();
    }

    @Then("User should see the dashboard summary table")
    public void verifySummaryTable() {
        if (!accountantActions.isSummaryTableDisplayed()) {
            throw new RuntimeException("Dashboard summary table not visible after 15 seconds");
        }
    }

    @Then("User should capture and print the data from dashboard table section this should be stored in the excel for reference")
    public void captureAndStoreData() {
        String xpath = "(//div[@class=\"row\"])[2]";
        accountantActions.captureAndStoreData(xpath, excelFilePath);
    }

    @Then("then need enter to the Expenses")
    public void navigateToExpenses() {
        accountantActions.clickExpensesMenu();
    }

    @Then("need click Add Expenses")
    public void clickAddExpense() {
        accountantActions.clickAddExpenseButton();
    }

    @Then("need to give the Header as {string}, name {string} and amount {string}")
    public void addNewExpense(String header, String name, String amount) {
        accountantActions.selectExpenseHeader(header);
        accountantActions.enterExpenseName(name);
        accountantActions.enterExpenseAmount(amount);
    }
    

    @And("the user click the save")
    public void saveExpense() {
        accountantActions.clickSaveButton();
    }

    @Then("need to see the asseart the success notifications")
    public void verifySuccessNotification() {
        Assert.assertTrue(accountantActions.isSuccessNotificationDisplayed());
    }

    @Then("need to see the asseart the error notifications")
    public void verifyErrorNotification() {
        Assert.assertTrue(accountantActions.isErrorNotificationDisplayed());
    }
}