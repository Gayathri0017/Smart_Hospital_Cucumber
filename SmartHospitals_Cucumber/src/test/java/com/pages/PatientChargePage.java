package com.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientChargePage {
	@FindBy(xpath="//div[@id='tabs']/div[1]/div[1]//following-sibling::div[1]/div/ul/li[9]//preceding-sibling::li[1]/a")
	public WebElement chargebtn ;
	
	@FindBy(xpath="//table[@id='DataTables_Table_4']/tbody[2]/tr/td")
	public WebElement total_amount ;
}
