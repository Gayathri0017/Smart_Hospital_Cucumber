package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountantPage {
    private WebDriver driver;

    @FindBy(xpath = " (//a[@class=\"btn btn-primary width50\"])[5]")
    public WebElement accountantRoleButton;
   
    @FindBy(xpath = "//*[@class=\"btn\"]")
    public WebElement signInButton;

    @FindBy(xpath = "//h2[contains(text(),'Accountant Dashboard')]")
    public WebElement dashboardTitle;

    @FindBy(xpath = "(//*[@href=\"https://demo.smart-hospital.in/admin/admin/dashboard\"])[2]")
    public WebElement dashboard;

    @FindBy(xpath = "/html/body/div[1]/div[1]/section/div[2]")
    public WebElement summaryTable;

    @FindBy(xpath = "//*[@class=\"info-box-content\"]")
    public WebElement expensesMenu;

    @FindBy(css = "a.btn.btn-primary")
    public WebElement addExpenseButton;

    @FindBy(id = "exp_head_id")
    public WebElement expenseHeaderDropdown;

    @FindBy(id = "name")
    public WebElement expenseNameField;

    @FindBy(id = "amount")
    public WebElement expenseAmountField;

    @FindBy(id = "addexpensebtn")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@class=\"toast toast-success\"]")
    public WebElement successNotification;

    @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
    public WebElement errorNotification;

    public AccountantPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}