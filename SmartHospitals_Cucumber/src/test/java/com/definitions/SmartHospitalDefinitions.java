package com.definitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import com.actions.*;
public class SmartHospitalDefinitions {

    private WebDriver driver;
    private SmartHospitalActions actions;

    public SmartHospitalDefinitions(WebDriver driver) {
        this.driver = driver;
        this.actions = new SmartHospitalActions(driver);
    }

    @When("the user selects \"Accountant\" role")
    public void the_user_selects_accountant_role() {
        WebElement roleDropdown = driver.findElement(By.id("roleDropdown"));
        Select select = new Select(roleDropdown);
        select.selectByVisibleText("Accountant");
    }

    @When("the user clicks the Sign In")
    public void the_user_clicks_the_sign_in() {
        WebElement signInButton = driver.findElement(By.id("signInButton"));
        signInButton.click();
    }

    @Then("the user clicks the Report")
    public void the_user_clicks_the_report() {
        actions.clickReport();
    }

    @Then("clicks on the Finance")
    public void clicks_on_the_finance() {
        actions.clickFinance();
    }

    @Then("selects the All Transaction Report")
    public void selects_the_all_transaction_report() {
        actions.selectAllTransactionReport();
    }

    @Then("the user selects the drop down button and chooses \"Last Week\"")
    public void the_user_selects_the_drop_down_button_and_chooses_last_week() {
        actions.selectLastWeek();
    }

    @Then("clicks the search")
    public void clicks_the_search() {
        actions.clickSearch();
    }

    @Then("the total amount should match the sum of the amounts in the table")
    public void the_total_amount_should_match_the_sum_of_the_amounts_in_the_table() {
        double totalAmountDisplayed = actions.getTotalAmountDisplayed();
        double totalAmountFromTable = actions.getTotalAmountFromTable();
        assertEquals("Total amount does not match the sum of the amounts in the table", totalAmountDisplayed, totalAmountFromTable, 0.01);
    }
}