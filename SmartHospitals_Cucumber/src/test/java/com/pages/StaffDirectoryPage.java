package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StaffDirectoryPage {
	@FindBy(xpath = "//section[@id='sibe-box']/ul[2]/li[13]")
	public WebElement hr ;
	
	@FindBy(xpath = "//section[@class='content']/div/div/div/div[3]/div[2]/ul/li[1]/following-sibling::li/a")
	public WebElement listView ;
	
	@FindBy(xpath = "//div[@class='tab-content']/div[3]/preceding-sibling::div[1]/div/table/tbody/tr/td[2]")
	public List<WebElement> name ;
	
	@FindBy(xpath = "//div[@class='tab-content']/div[3]/preceding-sibling::div[1]/div/table/tbody/tr/td[3]")
	public List<WebElement> role ;
	
}
