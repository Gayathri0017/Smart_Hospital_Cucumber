package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.HelperClass;

public class AccountantPageIncome {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Accountant')]")
    public WebElement accountantRoleButton;
   
    @FindBy(xpath = "//*[@class=\"btn\"]")
    public WebElement signInButton;

    @FindBy(xpath = "(//*[@href=\"https://demo.smart-hospital.in/admin/patient/search\"])[2]")
    public WebElement financeSection;

    @FindBy(xpath = "(//*[@href=\"https://demo.smart-hospital.in/admin/income\"])[2]")
    public WebElement incomeButton;

    @FindBy(xpath = "//*[@class=\"box-tools pull-right\"]/child :: a")
    public WebElement addIncomeButton;

    @FindBy(xpath = "//div[@class=\"form-group\"]/child::select")
    public WebElement incomeHeaderField;

    @FindBy(xpath = "(//*[@class=\"form-control\"])[2]")
    public WebElement incomeNameField;

    @FindBy(xpath = "(//*[@class=\"form-control\"])[5]")
    public WebElement incomeAmountField;

    @FindBy(xpath = "//*[@class=\"pull-right\"]/child::button")
    public WebElement saveButton;
    // //*[@id=\"toast-container\"]/div/div/p
    @FindBy(id = "toast-container")
    public WebElement errorNotification;

    @FindBy(xpath = "//tr[contains(@class, 'odd')]/following-sibling :: tr[1] /*[@class=\" dt-body-right\"]")
    public WebElement tableValue;
    
    

    
    public AccountantPageIncome(WebDriver driver) {
        driver = HelperClass.getDriver();
        PageFactory.initElements(driver, this);
    }

}