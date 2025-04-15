package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "email")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    public WebElement signInButton;

    // Role locators with better XPath
    @FindBy(xpath = "//a[contains(text(),'Super Admin')]")
    public WebElement superAdmin;

    @FindBy(xpath = "//a[contains(text(),'Admin')][2]")
    public WebElement admin;

    @FindBy(xpath = "//a[contains(text(),'Doctor')]")
    public WebElement doctor;

    @FindBy(xpath = "//a[contains(text(),'Pharmacist')]")
    public WebElement pharmacist;

    @FindBy(xpath = "//a[contains(text(),'Pathologist')]")
    public WebElement pathologist;

    @FindBy(xpath = "//a[contains(text(),'Radiologist')]")
    public WebElement radiologist;

    @FindBy(xpath = "//a[contains(text(),'Accountant')]")
    public WebElement accountant;

    @FindBy(xpath = "//a[contains(text(),'Receptionist')]")
    public WebElement receptionist;

    @FindBy(xpath = "//a[contains(text(),'Nurse')]")
    public WebElement nurse;

    @FindBy(css = "div.alert, div.error-message")
    public WebElement errorMessage;


}