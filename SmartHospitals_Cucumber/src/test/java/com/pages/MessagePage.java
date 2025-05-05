package com.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class MessagePage {
@FindBy(xpath="//ul[@class=\"sidebar-menu verttop\"]/li[13]/a")
public WebElement msg;
@FindBy(xpath="//div[@class=\"box-tools pull-right\"]/child::a[1]")
public WebElement postNew;
@FindBy(xpath="//input[@id=\"title\"]")
public WebElement title;
@FindBy(xpath="//input[@id=\"date\"]")
public WebElement date;
@FindBy(xpath="//input[@id=\"publish_date\"]")
public WebElement publishDate;
@FindBy(xpath="//body[@class=\"form-control wysihtml5-editor\"]")
public WebElement content;
@FindBy(xpath="//div[@class=\"modal-footer\"]/div/button")
public WebElement sendBtn;
@FindBy(xpath="//div[@class=\"alert alert-success\"]")
public WebElement success;
@FindBy(xpath="//div[@class=\"col-md-9\"]/descendant::span[1]")
public WebElement error;
@FindBy(xpath="//i[@class=\"fa fa-trash\"]")
public WebElement del;
}
