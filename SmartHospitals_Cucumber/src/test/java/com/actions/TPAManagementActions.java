package com.actions;

import com.pages.TPAManagementPage;
import com.utils.HelperClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TPAManagementActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private TPAManagementPage tpaManagementPage;
    private static final Logger log = LogManager.getLogger(TPAManagementActions.class);

    public TPAManagementActions() {
        this.driver = HelperClass.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.tpaManagementPage = new TPAManagementPage(driver);
        log.info("Initialized TPAManagementActions");
    }

    public void launchApplication(String url) {
        driver.get(url);
        log.info("Launched Smart Hospital application");
    }

    public void selectRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(tpaManagementPage.accountantRoleButton)).click();
        log.info("Selected role: {}", role);
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(tpaManagementPage.signInButton)).click();
        log.info("Clicked Sign In button");
    }

    public boolean isSummaryTableDisplayed() {
        try {
            tpaManagementPage.dashboard.click();
            boolean displayed = wait.until(ExpectedConditions.visibilityOf(tpaManagementPage.summaryTable)).isDisplayed();
            log.info("Summary table displayed: %s" , displayed);
            return displayed;
        } catch (Exception e) {
            log.error("Summary table not displayed", e);
            return false;
        }
    }

    public void clickTPAManagementMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(tpaManagementPage.tpaManagementMenu)).click();
        log.info("Clicked TPA Management menu");
    }

    public boolean isTPAManagerNameDisplayed() {
        try {
            boolean displayed = wait.until(ExpectedConditions.visibilityOf(tpaManagementPage.tpaManagerName)).isDisplayed();
            log.info("TPA manager name displayed: %s" , displayed);
            return displayed;
        } catch (Exception e) {
            log.error("TPA manager name not displayed", e);
            return false;
        }
    }
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