package com.actions;

import com.pages.TPAManagementPage;
import com.utils.HelperClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TPAManagementActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private TPAManagementPage tpaManagementPage;
    private static final Logger log = LogManager.getLogger(TPAManagementActions.class);

    // Constructor
    public TPAManagementActions() {
        this.driver = HelperClass.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased timeout to 60 seconds
        this.tpaManagementPage = new TPAManagementPage(driver);
        log.info("Initialized TPAManagementActions");
    }

    // Method to launch the application
    public void launchApplication(String url) {
        driver.get(url);
        log.info("Launched Smart Hospital application with URL: {}", url);
    }

    // Method to select a role
    public void selectRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(tpaManagementPage.accountantRoleButton)).click();
        log.info("Selected role: {}", role);
    }

    // Method to click the Sign In button
    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(tpaManagementPage.signInButton)).click();
        log.info("Clicked Sign In button");
    }

    // Method to check if the summary table is displayed
    public boolean isSummaryTableDisplayed() {
        try {
            tpaManagementPage.dashboard.click();
            boolean displayed = wait.until(ExpectedConditions.visibilityOf(tpaManagementPage.summaryTable)).isDisplayed();
            log.info("Summary table displayed: {}", displayed);
            return displayed;
        } catch (Exception e) {
            log.error("Failed to display summary table", e);
            return false;
        }
    }

    // Method to click the TPA Management menu with fallback
    public void clickTPAManagementMenu() {
        try {
            log.info("Attempting to click TPA Management menu");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='treeview '])[12]//a")));
            element.click();
            log.info("Clicked TPA Management menu successfully");
        } catch (TimeoutException e) {
            log.warn("Timeout waiting for TPA Management menu to be clickable. Continuing with the test.", e);
        } catch (StaleElementReferenceException e) {
            log.warn("Element became stale while trying to click TPA Management menu. Continuing with the test.", e);
        } catch (Exception e) {
            log.warn("Failed to click TPA Management menu. Continuing with the test.", e);
        }
    }

    // Method to check if the TPA manager name is displayed
    public boolean isTPAManagerNameDisplayed() {
        try {
            boolean displayed = wait.until(ExpectedConditions.visibilityOf(tpaManagementPage.tpaManagerName)).isDisplayed();
            log.info("TPA manager name displayed: {}", displayed);
            return displayed;
        } catch (Exception e) {
            log.error("TPA manager name not displayed", e);
            return false;
        }
    }

    // Method to print the names of all TPA managers
    public void printTPAManagerNames() {
        try {
            List<WebElement> managerNames = wait.until(ExpectedConditions.visibilityOfAllElements(tpaManagementPage.tpaManagerNamesLocator));
            System.out.println("\n\n");
            for (WebElement name : managerNames) {
                System.out.println("TPA Manager Name: " + name.getText());
            }
        } catch (Exception e) {
            log.error("Failed to print TPA manager names", e);
        }
    }
}