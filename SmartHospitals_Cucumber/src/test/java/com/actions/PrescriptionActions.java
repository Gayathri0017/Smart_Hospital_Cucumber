package com.actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.pages.PrescriptionPage;
import com.utils.HelperClass;
public class PrescriptionActions{
public PrescriptionPage pp=null;
DoctorActions da=new DoctorActions();
private static final Logger log=LogManager.getLogger(PrescriptionActions.class);
public PrescriptionActions() {
	this.pp=new PrescriptionPage();
	PageFactory.initElements(HelperClass.getDriver(),pp);
}
WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
public void selectFindingCategory(String s) {
    wait.until(ExpectedConditions.elementToBeClickable(pp.medicineCat)).click();
    wait.until(ExpectedConditions.visibilityOf(pp.search)).sendKeys(s);
    pp.search.sendKeys(Keys.ENTER);
    log.info("Finding category selected="+s);
}
public void selectMedicineCategory(String s) {
    wait.until(ExpectedConditions.elementToBeClickable(pp.medicineName)).click();
    wait.until(ExpectedConditions.visibilityOf(pp.search)).sendKeys(s);
    pp.search.sendKeys(Keys.ENTER);
    log.info("Medicine category selected="+s);
}
public void selectMedicine(String s) {
    try {
        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(pp.dose));
        dropdown.click();
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOf(pp.search));
        searchBox.clear();
        searchBox.sendKeys(s);
        searchBox.sendKeys(Keys.ENTER);
        log.info("Medicine selected="+s);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void selectDoseInterval(String s) {
    wait.until(ExpectedConditions.elementToBeClickable(pp.doseInterval)).click();
    wait.until(ExpectedConditions.visibilityOf(pp.search)).sendKeys(s);
    pp.search.sendKeys(Keys.ENTER);
    log.info("Dose interval selected="+s);
}
public void selectDoseDuration(String s) {
    wait.until(ExpectedConditions.elementToBeClickable(pp.doseDuration)).click();
    wait.until(ExpectedConditions.visibilityOf(pp.search)).sendKeys(s);
    pp.search.sendKeys(Keys.ENTER);
    log.info("Dose duration selected="+s);
}
public void OPDSection() {
	clickMethod(pp.opd);
	log.info("Navigated to OPD section");
}
public void addPres(){
	clickMethod(pp.addPrescription);
	log.info("Clicked Add Prescription");
}
public void assertPP() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(pp.text));
	String ex="Add Prescription";
	String act=pp.text.getText();
	Assert.assertEquals(ex, act);
//	pp.addMedicine.click();
//	Thread.sleep(1000);
}
public void save(){
	clickMethod(pp.save);
	log.info("Clicked Save");
}
public void edit() {
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(pp.edit));
	clickMethod(pp.edit);
}
WebDriverWait w= new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
JavascriptExecutor js=(JavascriptExecutor) HelperClass.getDriver();
public void clickMethod(WebElement ele) {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();
    } catch (ElementClickInterceptedException e) {
        js.executeScript("arguments[0].click();", ele);
    } catch (Exception e) {
        System.out.println("Click failed: " + e.getMessage());
    }
}
public void sendKeysMethod(WebElement ele, String text) {
    try {
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.sendKeys(text);
    } catch (Exception e) {
        System.out.println("SendKeys failed: " + e.getMessage());
    }
}
public void assertinvalid(String ex) {
	try {
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(pp.errorMsg));
	String act=pp.errorMsg.getText();
	System.out.println("Expected: " + ex);
	System.out.println("Actual: " + act);
	Assert.assertTrue(act.contains(ex));
	}catch(Exception e) {
		Assert.fail(e.getMessage());
	}
}
public void assertPrescription(){
	WebDriverWait wait=new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(pp.textPres));
	String act=pp.textPres.getText();
	String ex="Prescription";
	System.out.println("Expected: " + ex);
	System.out.println("Actual: " + act);
	Assert.assertTrue(act.contains(ex));
}
public void view() {
	String patientName = "Gaurav Shrivastava";
	WebElement viewBtn = HelperClass.getDriver().findElement(By.xpath("//table[@id='DataTables_Table_1']//tr[td[contains(text(),'" + patientName + "')]]//a[contains(@title, 'View Prescription')]"));
	viewBtn.click();
	log.info("Clicked View");
}
public void show() {
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(pp.show));
	clickMethod(pp.show);
}
public void assertShow(String ex) {
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(pp.showText));
	String act=pp.showText.getText();
	Assert.assertEquals(ex,act);
}
public void delete(){
	clickMethod(pp.delete);
	log.info("Clicked Delete");
}
public void assertEdit(String ex) {
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(pp.editText));
	String act=pp.editText.getText();
	Assert.assertEquals(ex,act);
}
public void editClick() {
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(pp.edit));
	clickMethod(pp.edit);
}
}
