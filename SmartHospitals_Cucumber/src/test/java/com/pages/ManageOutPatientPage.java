package com.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ManageOutPatientPage {
@FindBy(xpath="//ul[@class=\"sidebar-menu verttop\"]/li[4]/a")
public WebElement opd;
@FindBy(xpath="//div[@id=\"DataTables_Table_1_filter\"]//input")
public WebElement search;
@FindBy(xpath="//*[@id=\"DataTables_Table_1\"]/tbody/tr[1]/td[9]/div/a[5]")
public WebElement ipd;
@FindBy(xpath="//*[@id=\"form_confirm-move\"]/div/div[2]/div/div/div/div[2]/div/div[8]/div/div/select")
public WebElement bedId;
@FindBy(id ="select2-bed_no-container")
public WebElement bedNo;
@FindBy(xpath="//button[@class=\"btn btn-info pull-right btn-ok\"]")
public WebElement move;
@FindBy(xpath="/html/body/span[2]/span/span[1]/input")
public WebElement input;
@FindBy(xpath="//div[@class=\"box-header border-b mb10 pl-0 pt0\"]/h3")
public WebElement text;
@FindBy(xpath="//*[@id=\"live_consult\"]")
public WebElement live;
}
