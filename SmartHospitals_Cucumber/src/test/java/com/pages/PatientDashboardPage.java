package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientDashboardPage {
	
	@FindBy(xpath="//div[@class='navbar-custom-menu']/ul/li[4]/a/img")
	public WebElement profile ;
	
	@FindBy(xpath="//div[@class='navbar-custom-menu']/ul/li[4]/ul/li/div/div[1]//following-sibling::div/h5")
	public WebElement verifyProfile ;
	
	@FindBy(xpath = "//aside[@id='alert2']/div/section/ul/li[1]//following-sibling::li[1]/a/span")
	public WebElement myAppointment ;
	
	@FindBy(xpath = "//section[@class='content']/div/div[2]/div/div/div/a")
	public WebElement addAppointment ;
	
	@FindBy(name = "date")
	public WebElement date ;
	
	@FindBy(id = "specialist")
	public WebElement specialist ;
	
	@FindBy(id = "doctor")
	public WebElement doctor ;
	
	@FindBy(id = "global_shift")
	public WebElement timingShift ;
	
	@FindBy(id = "shift_id")
	public WebElement slot ;
	
	@FindBy(css = "#slot_1")
	public WebElement AvailableSlot ;
	
	@FindBy(xpath = "//*[@id=\"message\"]")
	public WebElement patientMsg ;
	
	@FindBy(id = "formaddbtn")
	public WebElement formSubmit ;
	
	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div/p[1]")
	public WebElement FieldRequired ;
	
	@FindBy(xpath = "//aside[@id='alert2']/div/section/ul/li[1]//following-sibling::li[3]/a/span")
	public WebElement ipd ;
}
