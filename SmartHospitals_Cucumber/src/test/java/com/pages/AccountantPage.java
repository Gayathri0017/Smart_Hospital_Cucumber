package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountantPage {
    private WebDriver driver;
// (//a[@class=\"btn btn-primary width50\"])[5]
    @FindBy(xpath = "//*[@class=\"btn btn-primary width50\"]/child :: *[@class =\"fa fa-calculator ispace\"]")
    public WebElement accountantRoleButton;
   
    @FindBy(xpath = "//*[@class=\"btn\"]")
    public WebElement signInButton;

    @FindBy(xpath = "//h2[contains(text(),'Accountant Dashboard')]")
    public WebElement dashboardTitle;

    @FindBy(xpath = "(//*[@class=\"treeview active\"]")
    public WebElement dashboard;

    @FindBy(xpath = "//div[@class=\"content-wrapper\"]/child :: *[@class=\"content\"] / child :: div[2]")
    public WebElement summaryTable;

    @FindBy(xpath = "(//*[@class=\"info-box-content\"])[9]")
    public WebElement expensesMenu;

    @FindBy(xpath = "//*[@class=\"btn btn-primary btn-sm addexpense\"]")
    public WebElement addExpenseButton;

    @FindBy(xpath = "//*[@id=\"exp_head_id\"]")
    public WebElement expenseHeaderDropdown;

    @FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement expenseNameField;

    @FindBy(xpath = "//*[@id=\"amount\"]")
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