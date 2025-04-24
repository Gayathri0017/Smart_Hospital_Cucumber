package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//div[@class=\"form-group\"]/child::*[@id=\"email\"]")
    public WebElement usernameField;

    @FindBy(xpath = "//div[@class=\"form-group\"]/child::*[@id=\"password\"]")
    public WebElement passwordField;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@class=\"fa fa-user-secret ispace\"]/parent :: *[@class=\"btn btn-primary width100\"]")
    public WebElement superAdmin;

    @FindBy(xpath = "//*[@class=\"fa fa-user ispace\"]/parent :: *[@class=\"btn btn-primary width50\"]")
    public WebElement admin;

    @FindBy(xpath = "//*[@class=\"fa fa-user-md ispace\"]/parent :: *[@class=\"btn btn-primary width100\"]")
    public WebElement doctor;

    @FindBy(xpath = "//*[@class=\"fas fa-mortar-pestle ispace\"]/parent :: *[@class=\"btn btn-primary width50\"]")
    public WebElement pharmacist;

    @FindBy(xpath = "(//a[.//i[@class=\"fas fa-mortar-pestle ispace\"]]/following-sibling::a)[1]")
    public WebElement pathologist;

    @FindBy(xpath = "(//a[.//i[@class=\"fas fa-mortar-pestle ispace\"]]/following-sibling::a)[2]")
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