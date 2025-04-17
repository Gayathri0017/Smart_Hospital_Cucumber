package com.definitions;

import com.actions.AccountantActionsIncome;
import io.cucumber.java.en.*;

public class AccountantDefinitionIncome {
    private AccountantActionsIncome accountantActionsIncome;

    @Given("User launches Smart Hospital website")
    public void launchApplication() {
        accountantActionsIncome = new AccountantActionsIncome();
    }

    @When("the user selects {string} role")
    public void selectRole(String role) {
        accountantActionsIncome.selectRole(role);
    }

    @When("the user clicks the Sign In")
    public void clickSignIn() {
        accountantActionsIncome.clickSignIn();
    }

    @Then("the user navigates to the finance section and clicks on income")
    public void navigateToIncome() {
        accountantActionsIncome.navigateToFinanceSection();
        accountantActionsIncome.clickIncome();
    }

    @Then("the user clicks on Add Income")
    public void clickAddIncome() {
        accountantActionsIncome.clickAddIncome();
    }

    @Then("the user enters the Header as {string}, name as {string}, and amount as {string}")
    public void enterIncomeDetails(String header, String name, String amount) {
        accountantActionsIncome.enterIncomeDetails(header, name, amount);
    }

    @Then("the user clicks the save button")
    public void clickSave() {
        accountantActionsIncome.clickSave();
    }

    @Then("the user verifies that the new income is added to the table")
    public void verifyIncomeAdded() {
        String amount = "1500.00"; 
        accountantActionsIncome.verifyIncomeAdded(amount);
    }
    
    @Then("the user should see an error notification")
    public void verifyErrorNotification() {
        if (!accountantActionsIncome.isErrorNotificationDisplayed()) {
            throw new RuntimeException("Error notification not displayed after saving expense with invalid data");
        }
    }
    
}