package com.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ToDoListPage {
@FindBy(xpath="//ul[@class='nav navbar-nav headertopmenu']/child::li[4]/a")
public WebElement calander;
@FindBy(xpath="//div[@class='media mt5']")
public WebElement todolist;
@FindBy(xpath="(//div[@class='form-group col-md-12']/child::input)[1]")
public WebElement task;
@FindBy(xpath="(//div[@class='form-group col-md-12']/child::input)[2]")
public WebElement date;
@FindBy(xpath="(//div[@class='form-group col-md-12']/child::input)[3]")
public WebElement saveBtn;
@FindBy(xpath="//div[@class='box-tools pull-right']/button")
public WebElement add;
}
