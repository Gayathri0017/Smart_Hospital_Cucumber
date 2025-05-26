package com.definitions;

import com.actions.TPAManagementActions;
import com.pages.TPAManagementPage;
import com.utils.HelperClass;
import io.cucumber.java.en.*;

public class TPAManagementDefinition {
    private TPAManagementActions tpaManagementActions;

    @Given("Users launches the Smart Hospital application")
    public void launchApplication() {
        tpaManagementActions = new TPAManagementActions();
        tpaManagementActions.launchApplication("https://demo.smart-hospital.in/admin/admin/dashboard");
    }

    @When("the users selects role {string}")
    public void selectRole(String role) {
        tpaManagementActions.selectRole(role);
    }

    @When("the users clicks the Sign In buttons")
    public void clickSignIn() {
        tpaManagementActions.clickSignIn();
    }

    @Then("Users should see the dashboard summary table")
    public void verifySummaryTable() {
        if (!tpaManagementActions.isSummaryTableDisplayed()) {
            throw new RuntimeException("Dashboard summary table not visible after 15 seconds");
        }
    }

    @And("the Users Clicks the TPA Management button")
    public void clickTPAManagementMenu() {
        tpaManagementActions.clickTPAManagementMenu();
    }

    @Then("the users Should be able to see the Name of the TPA managers")
    public void verifyTPAManagerName() {
        if (!tpaManagementActions.isTPAManagerNameDisplayed()) {
            throw new RuntimeException("TPA manager name not visible after 15 seconds");
        }
    }
    @And("the user should need to print the name of the TPA Managers")
    public void printTPAManagerNames() {
        tpaManagementActions.printTPAManagerNames();
    }

}