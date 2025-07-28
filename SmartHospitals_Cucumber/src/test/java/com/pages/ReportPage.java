package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPage {

	@FindBy(xpath = "//a[contains(.,'Reports')]")
	public WebElement reportsRootLink;

	@FindBy(xpath = "//a[contains(text(),'Finance')]")
	public WebElement financeLink;

	@FindBy(xpath = "//a[contains(text(),'All Transaction Report')]")
	public WebElement allTransactionReportLink;

	@FindBy(xpath = "//select[@name=\"search_type\"]")
	public WebElement timeDuration;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	public WebElement searchBtn;

	@FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody")
	public WebElement tablelist;

    public ReportPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}