package com.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class SearchPage {
@FindBy(xpath="//input[@class=\"form-control search-form search-form3\"]")
public WebElement searchBar;
@FindBy(xpath="//tr[@class=\"odd\"]//td[2]/a")
public WebElement name;
@FindBy(xpath="//tr[@class=\"odd\"]//td//div")
public WebElement error;
@FindBy(id="search-btn")
public WebElement searchBtn;
@FindBy(xpath="//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[1]/input")
public WebElement chkBox;
@FindBy(xpath="//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[2]/a")
public WebElement delName;
@FindBy(xpath="//button[@id=\"load\"]")
public WebElement delBtn;

}
