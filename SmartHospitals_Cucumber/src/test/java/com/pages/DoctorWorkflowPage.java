package com.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class DoctorWorkflowPage {
	@FindBy(xpath="//i[@class=\"fa fa-user-md ispace\"]")
	public WebElement doctor;
	@FindBy(xpath="//button[@class=\"btn\"]")
	public WebElement signin;
	@FindBy(xpath="(//li[@class=\"treeview \"]//child::span)[2]")
	public WebElement appointment;
	@FindBy(xpath="(//a[@class=\"btn btn-primary btn-sm\"]/preceding-sibling::a)[1]")
	public WebElement addAppointment;
	@FindBy(xpath="//div/child::a[@id=\"add\"]")
	public WebElement addpatient;
	@FindBy(xpath="//div[@class=\"form-group\"]/child::input[@id=\"name\"]")
	public WebElement pName;
	@FindBy(xpath="//input[@id=\"age_month\"]/preceding-sibling::input")
	public WebElement year;
	@FindBy(xpath="//input[@id=\"age_day\"]/preceding-sibling::input[1]")
	public WebElement month;
	@FindBy(xpath="//input[@id=\"age_month\"]/following::input")
	public WebElement day;
	@FindBy(xpath="//div[@class=\"form-group\"]/child::select[@id=\"addformgender\"]")
	public WebElement gender;
	@FindBy(xpath="//div[@class=\"form-group\"]/child::select[@name=\"blood_group\"]")
	public WebElement bloodGroup;
	@FindBy(xpath="//input[@id=\"age_day\"]/following::input[1]")
	public WebElement uploadPhoto;
	@FindBy(xpath="//div[@class=\"pull-right\"]/child::button[@id=\"formaddpabtn\"]")
	public WebElement saveBtn;
	
	@FindBy(xpath="//span[@class=\"select2-selection select2-selection--single\"]/child::span")
	public WebElement nameAfterAdd;
	@FindBy(id="select2-doctorid-container")
	public WebElement document;
	@FindBy(xpath="//select[@id=\"global_shift\"]")
	public WebElement shift;
	@FindBy(id="appointment_status")
	public WebElement status;
	@FindBy(id="discount_percentage")
	public WebElement discount;
	@FindBy(xpath="(//div[@class=\"col-md-3\"]/preceding-sibling::div[@class=\"col-sm-3\"])[4]/div/input")
	public WebElement date;
	@FindBy(id="(//div[@class=\"col-md-3\"]/child::div)[1]/select")
	public WebElement slot;
	@FindBy(xpath="//button[@id=\"formaddbtn\"]")
	public WebElement savebtn;
	@FindBy(xpath="(//div[@class=\"col-sm-3\"]/child::div)[1]/div/select")
	public WebElement doc;
	@FindBy(xpath="(//span[@class=\"selection\"]/child::span)[4]")
	public WebElement priority;
	@FindBy(xpath="//input[@class=\"select2-search__field\"]")
	public WebElement ip;
	
	@FindBy(xpath="(//tr[@class=\"odd\"])[1]//a")
	public WebElement patient;
	@FindBy(xpath="//div[@class=\"toast-message\"]/p")
	public WebElement nameError;
	@FindBy(xpath="//div[@class=\"toast-message\"]/p")
	public WebElement successmsg;
	

	@FindBy(xpath="//div[@class=\"btn-group bootstrap-select language\"]")
	public WebElement lan;
	@FindBy(xpath="//ul[@class=\"dropdown-menu inner selectpicker\"]//li[5]")
	public WebElement eng;
	
	@FindBy(xpath="//input[@id=\"custom_fields[patient][11]\"]")
	public WebElement uhid;
}
