package com.actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pages.LoginPage;
import com.utils.HelperClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
public class LoginActions {
    private LoginPage loginPage;
    private WebDriverWait wait;
    private static final Logger logger=LogManager.getLogger(LoginActions.class);
    public LoginActions() {
        this.loginPage=new LoginPage();
        PageFactory.initElements(HelperClass.getDriver(), loginPage);
        this.wait=new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
        logger.info("Initialized LoginPage and WebDriverWait");
    }
    public void selectRole(String role) {
        logger.info("Selecting role: %s"+role);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.signInButton));
        switch (role.toLowerCase()) {
            case "super admin":
                loginPage.superAdmin.click();
                break;
            case "admin":
                loginPage.admin.click();
                break;
            case "doctor":
                loginPage.doctor.click();
                break;
            case "pharmacist":
                loginPage.pharmacist.click();
                break;
            case "pathologist":
                loginPage.pathologist.click();
                break;
            case "radiologist":
                loginPage.radiologist.click();
                break;
            case "accountant":
                loginPage.accountant.click();
                break;
            case "receptionist":
                loginPage.receptionist.click();
                break;
            case "nurse":
                loginPage.nurse.click();
                break;
            default:
                logger.error("Invalid role provided: %s"+role);
                throw new IllegalArgumentException("Invalid role: %s"+role);
        }
    }
    public void enterUsername() {
        logger.info("Entering username");
        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameField));
        loginPage.usernameField.clear();
        loginPage.usernameField.sendKeys("username");
    }
    public void enterPassword() {
        logger.info("Entering password");
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordField));
        loginPage.passwordField.clear();
        loginPage.passwordField.sendKeys("password");
    }
    public void clickSignIn() {
        logger.info("Clicking Sign In button");
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.signInButton));
        loginPage.signInButton.click();
    }
    public boolean isDashboardDisplayed(String role) {
        String name=null;
        logger.info("Checking dashboard for role: %s"+role);
        try {
            if (role.equalsIgnoreCase("Pharmacist") || role.equalsIgnoreCase("Pathologist") || role.equalsIgnoreCase("Radiologist")) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"dropdown-toggle\"]")));
                WebElement profileLink=HelperClass.getDriver().findElement(By.xpath("//*[@class=\"dropdown-toggle\"]"));
                profileLink.click();
                WebElement roleNameElement=HelperClass.getDriver().findElement(By.xpath("//*[@class=\"sstopuser-test\"]/child::h5"));
                name=roleNameElement.getText();
            } else if (role.equalsIgnoreCase("Admin") || 
                       role.equalsIgnoreCase("Receptionist") || 
                       role.equalsIgnoreCase("Nurse") || 
                       role.equalsIgnoreCase("Super Admin") || 
                       role.equalsIgnoreCase("Doctor") || 
                       role.equalsIgnoreCase("Accountant")) {
            																		
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"dropdown-toggle\"]")));
                WebElement profileLink=HelperClass.getDriver().findElement(By.xpath("//*[@class=\"dropdown-toggle\"]"));
                profileLink.click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"sstopuser-test\"]/child::h5")));
                WebElement roleNameElement=HelperClass.getDriver().findElement(By.xpath("//*[@class=\"sstopuser-test\"]/child::h5"));
                name=roleNameElement.getText();
            }
            return name.contains(role);
        } catch (Exception e) {
            logger.error("Error while verifying dashboard role: %s"+e.getMessage(), e);
            e.printStackTrace();
            return false;
        }
    }
    public boolean isErrorDisplayed() {
        try {
            return loginPage.errorMessage.isDisplayed();
        } catch (Exception e) {
            logger.warn("Login error message not found: %s"+e.getMessage());
            return false;
        }
    }
}
