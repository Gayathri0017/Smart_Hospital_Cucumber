package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountantPageIncome {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div[3]/a[1]")
    public WebElement accountantRoleButton;

    @FindBy(css = "button.btn[type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "(//a[@href=\"https://demo.smart-hospital.in/admin/patient/search\"])[2]")
    public WebElement financeSection;

    @FindBy(xpath = "(//*[@href=\"https://demo.smart-hospital.in/admin/income\"])[2]")
    public WebElement incomeButton;

    @FindBy(css = "a.btn.btn-primary")
    public WebElement addIncomeButton;

    @FindBy(id = "inc_head_id")
    public WebElement incomeHeaderField;

    @FindBy(id = "name")
    public WebElement incomeNameField;

    @FindBy(id = "amount")
    public WebElement incomeAmountField;

    @FindBy(id = "add_incomebtn")
    public WebElement saveButton;
    
    @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div/p")
    public WebElement errorNotification;

    @FindBy(xpath = "(//td[@class=\" dt-body-right\"])[1]")
    public WebElement tableValue;

    
    public AccountantPageIncome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public By AccountantRoleButton() {
		// TODO Auto-generated method stub
		return null;
	}
}