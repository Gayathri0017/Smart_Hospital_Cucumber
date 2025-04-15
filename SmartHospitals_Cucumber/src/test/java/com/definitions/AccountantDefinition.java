package com.definitions;

import com.actions.AccountantActions;
import com.pages.AccountantPage;
import com.utils.HelperClass;
import io.cucumber.java.en.*;

public class AccountantDefinition {
    private AccountantActions accountantActions;
    private AccountantPage accountantPage;
    private String excelFilPath = "target/dashboard_data.xlsx";

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
        accountantActions.verifySummaryTable();
    }

    @Then("User should capture and print the data from dashboard table section this should be stored in the excel for reference")
    public void captureAndStoreData() {
    	String xpath ="/html/body/div[1]/div[1]/section/div[2]";
        accountantActions.captureAndStoreData(xpath, excelFilPath);
    }

    @Then("then need enter to the Expenses")
    public void navigateToExpenses() {
        accountantActions.navigateToExpenses();
    }

    @Then("need click Add Expenses")
    public void clickAddExpense() {
        accountantActions.clickAddExpense();
    }

    @Then("need to give the Header as {string}, name {string} and amount {string}")
    public void addNewExpense(String header, String name, String amount) {
        accountantActions.addNewExpense(header, name, amount);
    }

    @And("the user click the save")
    public void saveExpense() {
        accountantActions.saveExpense();
    }

    @Then("need to see the asseart the success notifications")
    public void verifySuccessNotification() {
        accountantActions.verifySuccessNotification();
    }
    
    @Then("need to see the asseart the error notifications")
    public void verifyErrorNotification() {
        accountantActions.isErrorNotificationDisplayed();
    }
}