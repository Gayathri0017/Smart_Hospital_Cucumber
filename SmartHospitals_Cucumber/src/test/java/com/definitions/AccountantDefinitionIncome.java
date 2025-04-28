package com.definitions;

import java.util.List;
import java.util.Map;

import com.actions.AccountantActionsIncome;

import io.cucumber.datatable.DataTable;
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

    @When("the user enters the following income details:")
    public void enterIncomeDetailsFromDataTable(DataTable dataTable) {
    	List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

    	for (Map<String, String> row : data) {
    	    String header = row.get("header");
    	    String name = row.get("name");
    	    String amount = row.get("amount");

    	    header = (header == null || header.equalsIgnoreCase("[empty]")) ? "" : header;
    	    name = (name == null || name.equalsIgnoreCase("[empty]")) ? "" : name;
    	    amount = (amount == null || amount.equalsIgnoreCase("[empty]")) ? "" : amount;

    	    accountantActionsIncome.enterIncomeDetails(header, name, amount);
    	}

    }

    @Then("the user enters the Header as {string}, name as {string}, and amount as {string}")
    public void enterIncomeDetails(String header, String name, String amount) {
        accountantActionsIncome.enterIncomeDetails(header, name, amount);
        int amt=Integer.parseInt(amount);
    }
    
    @Then("the user clicks the save button")
    public void clickSave() {
        accountantActionsIncome.clickSave();
    }

    @Then("the user verifies that the new income is added to the table")
    public void verifyIncomeAdded() {
        String amount = "200.00"; 
        accountantActionsIncome.verifyIncomeAdded(amount);
    }
    
    @Then("the user should see an error notification")
    public void verifyErrorNotification() {
        if (!accountantActionsIncome.isErrorNotificationDisplayed()) {
            throw new RuntimeException("Error notification not displayed after saving expense with invalid data");
        }
    }
    
}