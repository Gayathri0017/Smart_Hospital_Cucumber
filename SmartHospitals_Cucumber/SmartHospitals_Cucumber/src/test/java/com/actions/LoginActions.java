package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LoginPage;
import com.utils.HelperClass;

import java.time.Duration;

public class LoginActions {
    private LoginPage loginPage;
    private WebDriverWait wait;
    public LoginActions() {
    	this.loginPage = new LoginPage();
        PageFactory.initElements(HelperClass.getDriver(), loginPage);
        this.wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
    }
    public void selectRole(String role) {
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
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    public void enterUsername() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameField));
        loginPage.usernameField.clear();
        loginPage.usernameField.sendKeys("username");
    }

    public void enterPassword() {
    	wait.until(ExpectedConditions.visibilityOf(loginPage.passwordField));
        loginPage.passwordField.clear();
       loginPage.passwordField.sendKeys("password");
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.signInButton));
        loginPage.signInButton.click();
     
    }

    public boolean isDashboardDisplayed(String role) {
    	String  name = null ;
        try {
        	
        if(role.equalsIgnoreCase("Pharmacist") || role.equalsIgnoreCase("Pathologist") || role.equalsIgnoreCase("Radiologist")) {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"alert\"]/nav/div[2]/div/div/ul/li[5]/a")));
            WebElement profileLink = HelperClass.getDriver().findElement(By.xpath("//*[@id=\"alert\"]/nav/div[2]/div/div/ul/li[5]/a"));
            profileLink.click();
            WebElement roleNameElement = HelperClass.getDriver().findElement(By.xpath("//*[@id=\"alert\"]/nav/div[2]/div/div/ul/li[5]/ul/li/div/div[2]/h5"));
            name = roleNameElement.getText();
            
            }
        else if (role.equalsIgnoreCase("Admin") || 
                role.equalsIgnoreCase("Receptionist") || 
                role.equalsIgnoreCase("Nurse") || 
                role.equalsIgnoreCase("Super Admin") || 
                role.equalsIgnoreCase("Doctor") || 
                role.equalsIgnoreCase("Accountant")) 
       {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"alert\"]/nav/div[2]/div/div/ul/li[6]/a")));
           WebElement profileLink = HelperClass.getDriver().findElement(By.xpath("//*[@id=\"alert\"]/nav/div[2]/div/div/ul/li[6]/a"));
           profileLink.click();
           Thread.sleep(1000);
           WebElement roleNameElement = HelperClass.getDriver().findElement(By.xpath("//*[@id=\"alert\"]/nav/div[2]/div/div/ul/li[6]/ul/li/div/div[2]/h5"));
           name = roleNameElement.getText();
       }

       
        return name.contains(role);
           
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isErrorDisplayed() {
        try {
            return loginPage.errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}