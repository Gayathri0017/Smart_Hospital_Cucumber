package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientDischargePage {
	

	@FindBy(xpath = "//div[@class='slimScrollDiv']/section/ul[2]/li[1]//following-sibling::li[4]/a")
	public WebElement ipd ;
	
	@FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td/a")
	public WebElement firstPatient ;
	
	@FindBy(xpath = "//div[@id='overview']/div/div[1]/div[1]/h3")
	public WebElement dischargePatientName ;
	
	@FindBy(xpath = "//div[@id='overview']/div/div[1]/div[1]/div/div/a[3]/i")
	public WebElement dischargeIcon ;
	
	@FindBy(name = "discharge_date")
	public WebElement dischargeDate ;
	
	@FindBy(xpath="(//div[@class='col-md-6'])[1]/div/label")
	public WebElement dischargeDateText ;
	
	@FindBy(xpath = "//form[@id=\"patient_discharge\"]/div[2]/div[2]/div/select")
	public WebElement dischargeStatus ;
	
	@FindBy(id = "add_paymentbtn")
	public WebElement dischargeSaveBtn ;
	
	@FindBy(xpath = "//div[@id=\"toast-container\"]/div/div/p")
	public WebElement error ;
	
	@FindBy(xpath = "//div[@id='DataTables_Table_0_filter']/label/input")
	public WebElement searchField ;
	
	@FindBy(xpath = "//tr[@class='odd']/td/div")
	public WebElement nodataAvailable ;
}
