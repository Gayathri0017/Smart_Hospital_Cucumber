package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.HelperClass;

public class AccountantPage {

    @FindBy(xpath = "(//*[@class=\"btn-group btn-group-justified\"])[3]/child::a[1]")
    public WebElement accountantRoleButton;
   
    @FindBy(xpath = "//*[@class=\"btn\"]")
    public WebElement signInButton;

    @FindBy(xpath = "//h2[contains(text(),'Accountant Dashboard')]")
    public WebElement dashboardTitle;

    @FindBy(xpath = "(//*[@href=\"https://demo.smart-hospital.in/admin/admin/dashboard\"])[2]")
    public WebElement dashboard;

    @FindBy(xpath = "//*[@class=\"content\"]/child :: div[2]")
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

    @FindBy(xpath = "//*[@class=\"pull-right\"]/child::button")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@class=\"toast toast-success\"]")
    public WebElement successNotification;

    @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
    public WebElement errorNotification;

    public AccountantPage(WebDriver driver) {
        driver = HelperClass.getDriver();
        PageFactory.initElements(driver, this);
    }
}