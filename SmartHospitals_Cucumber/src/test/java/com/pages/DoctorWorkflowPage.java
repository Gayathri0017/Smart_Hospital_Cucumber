package com.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class DoctorWorkflowPage {
	@FindBy(xpath="//i[@class=\"fa fa-user-md ispace\"]")
	public WebElement doctor;
	@FindBy(xpath="//button[@class=\"btn\"]")
	public WebElement signin;
	@FindBy(xpath="(//li[@class=\"treeview \"]//span)[2]")
	public WebElement appointment;
	@FindBy(xpath="//a[@class=\"btn btn-primary btn-sm addappointment\"]")
	public WebElement addAppointment;
	@FindBy(xpath="//a[@id=\"add\"]")
	public WebElement addpatient;
	@FindBy(xpath="//input[@id=\"name\"]")
	public WebElement pName;
	@FindBy(xpath="//input[@id=\"age_year\"]")
	public WebElement year;
	@FindBy(xpath="//input[@id=\"age_month\"]")
	public WebElement month;
	@FindBy(xpath="//input[@id=\"age_day\"]")
	public WebElement day;
	@FindBy(id="addformgender")
	public WebElement gender;
	@FindBy(xpath="//select[@name=\"blood_group\"]")
	public WebElement bloodGroup;
	@FindBy(xpath="//input[@id=\"file\"]")
	public WebElement uploadPhoto;
	@FindBy(xpath="//button[@id=\"formaddpabtn\"]")
	public WebElement saveBtn;
	
	@FindBy(xpath="//span[@id=\"select2-addpatient_id-container\"]")
	public WebElement nameAfterAdd;
	@FindBy(id="select2-doctorid-container")
	public WebElement document;
	@FindBy(xpath="//select[@id=\"global_shift\"]")
	public WebElement shift;
	@FindBy(id="appointment_status")
	public WebElement status;
	@FindBy(id="discount_percentage")
	public WebElement discount;
	@FindBy(xpath="//input[@id=\"datetimepicker\"]")
	public WebElement date;
	@FindBy(id="slot")
	public WebElement slot;
//	@FindBy(xpath="//button[@id=\"formaddbtn\"]")
//	public WebElement save;
	@FindBy(xpath="//button[@id=\"formaddbtn\"]")
	public WebElement savebtn;
	@FindBy(xpath="//select[@id=\"doctorid\"]")
	public WebElement doc;
	
	@FindBy(xpath="(//tr[@class=\"odd\"])[1]//a")
	public WebElement patient;
	@FindBy(xpath="//div[@class=\"toast-message\"]/p")
	public WebElement nameError;

	@FindBy(xpath="//div[@class=\"btn-group bootstrap-select language\"]")
	public WebElement lan;
	@FindBy(xpath="//ul[@class=\"dropdown-menu inner selectpicker\"]//li[5]")
	public WebElement eng;
	
	@FindBy(xpath="//input[@id=\"custom_fields[patient][11]\"]")
	public WebElement uhid;
}
