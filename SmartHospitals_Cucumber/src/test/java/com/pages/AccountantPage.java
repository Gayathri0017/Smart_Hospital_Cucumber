package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountantPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Improved locators
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div[3]/a[1]")
    private WebElement accountantRoleButton;
    
    @FindBy(css = "button.btn[type='submit']")
    private WebElement signInButton;
    
    @FindBy(xpath = "//h2[contains(text(),'Accountant Dashboard')]")
    private WebElement dashboardTitle;
    
    @FindBy(xpath = "/html/body/div[1]/div[1]/section/div[2]")
    private WebElement summaryTable;

    public AccountantPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void selectRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(accountantRoleButton)).click();
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public boolean isDashboardDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(dashboardTitle)).isDisplayed();
        } catch (Exception e) {
            System.err.println("Dashboard verification failed: " + e.getMessage());
            return false;
        }
    }

    public boolean isSummaryTableDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(summaryTable)).isDisplayed();
        } catch (Exception e) {
            System.err.println("Summary table verification failed: " + e.getMessage());
            return false;
        }
    }

    public List<List<String>> convertTableDataToRows(String tableData) {
        List<List<String>> rows = new ArrayList<>();
        String[] lines = tableData.split("\n");
        
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                String[] cells = line.split("\\s{2,}"); // Split on 2+ whitespace
                rows.add(Arrays.asList(cells));
            }
        }
        return rows;
    }
}