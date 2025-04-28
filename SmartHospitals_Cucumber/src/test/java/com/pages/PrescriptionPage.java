package com.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class PrescriptionPage {
	@FindBy(xpath="//ul[@class=\"sidebar-menu verttop\"]/li[4]")
	public WebElement opd;
	@FindBy(xpath="//*[@id=\"DataTables_Table_1\"]/tbody/tr[1]/td[9]/div/a[2]")
	public WebElement addPrescription;
	@FindBy(xpath="(//input[@class=\"select2-search__field\"])[1]")
	public WebElement catogory;
	@FindBy(xpath="//a[@class=\"btn btn-info add-record addplus-xs\"]")
	public WebElement addMedicine;
	@FindBy(xpath="(//span[@class=\"select2-selection__arrow\"])[5]")
	public WebElement medicineCat;
	@FindBy(xpath="(//span[@class=\"select2-selection__arrow\"])[6]")
	public WebElement medicineName;
	@FindBy(xpath="(//span[@class=\"select2-selection__arrow\"])[7]")
	public WebElement dose;
	@FindBy(xpath="(//span[@class=\"select2-selection__arrow\"])[8]")
	public WebElement doseInterval;
	@FindBy(xpath="(//span[@class=\"select2-selection__arrow\"])[9]")
	public WebElement doseDuration;
	@FindBy(xpath="(//button[@class=\"btn btn-info\"])[2]")
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
	@FindBy(xpath="//*[@id=\"DataTables_Table_1\"]/tbody/tr[8]/td[9]/div/a[2]")
	public WebElement view;
	@FindBy(xpath="//*[@id=\"DataTables_Table_1\"]/tbody/tr[1]/td[9]/div/a[4]")
	public WebElement show;
	@FindBy(xpath="//a[@class=\"delete_opd\"]")
	public WebElement delete;
	@FindBy(xpath="//h4[text()=\"Visit Details\"]")
	public WebElement showText;
	@FindBy(xpath="//*[@id=\"visitformedit\"]/div[1]/div/h4")
	public WebElement editText;
	@FindBy(xpath="//div[@class=\"white-space-nowrap\"]/a[3]")
	public WebElement manualP;
	@FindBy(xpath="(//h4[text()='Prescription'])[2]")
	public WebElement verifyManual;
}
