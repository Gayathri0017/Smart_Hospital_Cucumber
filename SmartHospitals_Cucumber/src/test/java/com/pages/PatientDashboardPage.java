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
	
	@FindBy(xpath = "//aside[@id='alert2']/div/section/ul/li[1]//following-sibling::li[10]/a/span")
	public WebElement downloadCenter ;
	
	@FindBy(xpath = "(//div[@class='form-group'])[1]/input")
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
	public WebElement availableSlot ;
	
	@FindBy(xpath = "(//div[@class='form-group'])[7]/textarea")
	public WebElement patientMsg ;
	
	@FindBy(id = "formaddbtn")
	public WebElement formSubmit ;
	
	@FindBy(xpath = "//div[@id='toast-container']/div/div/p[1]")
	public WebElement fieldRequired ;
	
	@FindBy(xpath = "//aside[@id='alert2']/div/section/ul/li[1]//following-sibling::li[3]/a/span")
	public WebElement ipd ;
	
	@FindBy(xpath = "//div[@id='toast-container']/div/div")
	public WebElement successMsg ;
	
	@FindBy(css = "#myModal>div>div #formadd>div>div>.alert")
	public WebElement appointNotAvail ;
	
	@FindBy(xpath="//div[@class='wrapper']/div[1]/section/div/div[2]/preceding-sibling::div/div/div/div[1]/following-sibling::div/ul/li[1]/a")
	public WebElement patientid ;
	
	@FindBy(xpath="//div[@class='wrapper']/div[1]/section/div/div[2]/preceding-sibling::div/div/div/div[1]/following-sibling::div/ul/li[1]/following-sibling::li[1]/a")
	public WebElement patientMaritalStatus ;
	
	@FindBy(xpath="//div[@class='wrapper']/div[1]/section/div/div[2]/preceding-sibling::div/div/div/div[1]/following-sibling::div/ul/li[1]/following-sibling::li[2]/a")
	public WebElement patientEmail ;
	
	@FindBy(xpath="//div[@class='wrapper']/div[1]/section/div/div[2]/preceding-sibling::div/div/div/div[1]/following-sibling::div/ul/li[1]/following-sibling::li[3]/a")
	public WebElement patientAge ;
	
	@FindBy(xpath="//div[@class='wrapper']/div[1]/section/div/div[2]/preceding-sibling::div/div/div/div[1]/following-sibling::div/ul/li[1]/following-sibling::li[4]/a")
	public WebElement patientGender ;
	
	@FindBy(xpath="//div[@class='wrapper']/div[1]/section/div/div[2]/preceding-sibling::div/div/div/div[1]/following-sibling::div/ul/li[1]/following-sibling::li[5]/a")
	public WebElement patientPhone ;
	
	@FindBy(xpath="//div[@class='wrapper']/div[1]/section/div/div[2]/preceding-sibling::div/div/div/div[1]/following-sibling::div/ul/li[1]/following-sibling::li[6]/a")
	public WebElement patientAddress ;
	
	@FindBy(xpath="//div[@class='wrapper']/div[1]/section/div/div[2]/preceding-sibling::div/div/div/div[1]/following-sibling::div/ul/li[1]/following-sibling::li[7]/a")
	public WebElement patientGuardianName ;
}