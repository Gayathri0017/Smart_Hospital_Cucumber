package com.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientChargePage {
	@FindBy(xpath="(//ul[@class='nav nav-tabs navheader navlistscroll']//li//following-sibling::li[7]/a)[1]")
	public WebElement chargebtn ;
	
	@FindBy(xpath="//table[@id='DataTables_Table_4']/tbody[2]/tr/td")
	public WebElement total_amount ;
}
