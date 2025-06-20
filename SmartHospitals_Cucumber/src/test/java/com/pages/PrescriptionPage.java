package com.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class PrescriptionPage {
	@FindBy(xpath="//ul[@class=\"sidebar-menu verttop\"]/li[4]")
	public WebElement opd;
	@FindBy(xpath="//div[@class=\"white-space-nowrap\"]/a[2]")
	public WebElement addPrescription;
	@FindBy(xpath="(//input[@class=\"select2-search__field\"])[1]")
	public WebElement catogory;
	@FindBy(xpath="//a[@class='btn btn-info add-record addplus-xs']")
	public WebElement addMedicine;
//	(//span[@class="select2-selection__arrow"])[5]]
//	@FindBy(xpath="(//span[@class=\"select2-selection__arrow\"])[5]")
	@FindBy(xpath="(//span[@class='select2-selection__rendered'])[5]")
	public WebElement medicineCat;
//	@FindBy(xpath="(//span[@class=\"select2-selection__arrow\"])[6]")
	@FindBy(xpath="(//span[@class='select2-selection__rendered'])[6]")
	public WebElement medicineName;
//	@FindBy(xpath="(//span[@class=\"select2-selection__arrow\"])[7]")
	@FindBy(xpath="(//span[@class='select2-selection__rendered'])[7]")
	public WebElement dose;
//	@FindBy(xpath="(//span[@class=\"select2-selection__arrow\"])[8]")
	@FindBy(xpath="(//span[@class='select2-selection__rendered'])[8]")
	public WebElement doseInterval;
//	@FindBy(xpath="(//span[@class=\"select2-selection__arrow\"])[9]")
	@FindBy(xpath="(//span[@class='select2-selection__rendered'])[9]")
	public WebElement doseDuration;
	@FindBy(xpath="(//button[@class='btn btn-info'])[2]")
	public WebElement save;
	@FindBy(xpath="//input[@class=\"filestyle2 form-control\"]")
	public WebElement file;
	@FindBy(xpath="//h4[@id=\"prescription_title\"]")
	public WebElement text;
	@FindBy(xpath="(//input[@class=\"select2-search__field\"])[6]")
	public WebElement search;
	@FindBy(xpath="//div[@class=\"toast-message\"]//p")
	public WebElement errorMsg;
	@FindBy(xpath="//a[@class=\\\"delete_opd\\\"]/preceding-sibling::a")
	public WebElement edit;
	@FindBy(xpath="//h4[text()=\"Prescription\"]")
	public WebElement textPres;
	@FindBy(xpath="//div[@class=\"white-space-nowrap\"]/a[3]")
	public WebElement view;
	@FindBy(xpath="//a[@class=\"delete_opd\"]")
	public WebElement delete;
	@FindBy(xpath="//h4[text()=\"Visit Details\"]")
	public WebElement showText;
	@FindBy(xpath="//div[@class=\"white-space-nowrap\"]/a[3]")
	public WebElement manualP;
	@FindBy(xpath="(//h4[text()='Prescription'])[2]")
	public WebElement verifyManual;
	@FindBy(xpath="//table[@class=\"printablea4\"]//tr[2]/td[1]")
	public WebElement verifyView;
}
