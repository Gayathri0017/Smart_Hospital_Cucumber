package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartHospitalPage {

    private WebDriver driver;

    @FindBy(id = "reportButton")
    private WebElement reportButton;

    @FindBy(id = "financeButton")
    private WebElement financeButton;

    @FindBy(id = "allTransactionReport")
    private WebElement allTransactionReport;

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(id = "transactionsTable")
    private WebElement transactionsTable;

    @FindBy(id = "totalAmount")
    private WebElement totalAmount;

    public SmartHospitalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getReportButton() {
        return reportButton;
    }

    public WebElement getFinanceButton() {
        return financeButton;
    }

    public WebElement getAllTransactionReport() {
        return allTransactionReport;
    }

    public WebElement getDropdown() {
        return dropdown;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getTransactionsTable() {
        return transactionsTable;
    }

    public WebElement getTotalAmount() {
        return totalAmount;
    }
}