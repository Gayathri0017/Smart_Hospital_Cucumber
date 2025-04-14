package com.definitions;

import com.actions.AccountantActions;
import com.utils.HelperClass;
import io.cucumber.java.en.*;

public class AccountantDefinition {
    private AccountantActions accountantActions;
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

    @Then("User should be navigated to the accountant dashboard")
    public void verifyDashboardNavigation() {
        accountantActions.verifyDashboardNavigation();
    }

    @Then("User should see the dashboard summary table")
    public void verifySummaryTable() {
        accountantActions.verifySummaryTable();
    }

    @Then("User should capture and print the data from dashboard table section {string} this should be stored in the excel for reference")
    public void captureAndStoreData(String xpath) {
        accountantActions.captureAndStoreData(xpath, excelFilePath);
    }
}