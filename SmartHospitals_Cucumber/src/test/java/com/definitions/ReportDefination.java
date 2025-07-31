package com.definitions;

import com.actions.ReportActions;
import com.actions.TPAManagementActions;
import io.cucumber.java.en.*;

public class ReportDefination {

    private final TPAManagementActions tpa  = new TPAManagementActions();
    private final ReportActions reports     = new ReportActions();

    @Given("User launches the Smart Hospital application for report feature")
    public void launchApplication() {
        tpa.launchApplication("https://demo.smart-hospital.in/site/login");
    }

    @When("the user selects role {string} for report feature")
    public void selectRole(String role) { tpa.selectRole(role); }

    @And("the user clicks the Sign In buttons for report feature")
    public void clickSignIn() { tpa.clickSignIn(); }

    @Then("User should see the dashboard summary table for report feature")
    public void verifyDashboard() {
        tpa.isSummaryTableDisplayed();}

    @When("the user clicks the Report menu")
    public void reportMenu() { reports.clickReportMenu(); }

    @And("the user navigates to the Finance group")
    public void financeGroup() { reports.clickFinanceGroup(); }

    @And("the user clicks on the Reports")
    public void allTransactionReport() { reports.clickAllTransactionReport(); }

    @When("the user selects the time duration {string}")
    public void timeDuration(String duration) { reports.selectDateRange(duration); }

    @And("the user clicks the Search button")
    public void searchButton() { reports.clickSearch(); }

    @Then("the user should see the total amount")
    public void seeTableList() {
        reports.getTotalTable();
    }
    
    @Then("the user should see the {string}")
    public void seeErrorText(String expectedMessage) {
        reports.seeErrorText(expectedMessage);
    }
}