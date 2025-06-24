package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TPAManagementPage {

    @FindBy(xpath = "(//*[@class=\"btn-group btn-group-justified\"])[3]/child::a[1]")
    public WebElement accountantRoleButton;
    @FindBy(xpath = "//*[@class=\"btn\"]")
    public WebElement signInButton;
    @FindBy(xpath = "//h2[contains(text(),'Accountant Dashboard')]")
    public WebElement dashboardTitle;
    @FindBy(xpath = "//*[@class=\"treeview active\"]//a")
    public WebElement dashboard;
    @FindBy(xpath = "//*[@class=\"content\"]")
    public WebElement summaryTable;
    @FindBy(xpath = "(//*[@class=\\\"treeview \\\"])[12]//a")
    public WebElement tpaManagementMenu;
    @FindBy(xpath = "//*[@class=\"box-body\"]")
    public WebElement tpaManagerName;
    @FindBy(xpath = "//*[@role=\"row\"]//td[1]")
    public List<WebElement> tpaManagerNamesLocator;

    public TPAManagementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}