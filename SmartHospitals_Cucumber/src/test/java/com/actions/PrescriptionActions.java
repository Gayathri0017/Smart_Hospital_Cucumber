package com.actions;

import java.time.Duration;

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
public PrescriptionActions() {
	this.pp=new PrescriptionPage();
	PageFactory.initElements(HelperClass.getDriver(),pp);
}
WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
public void selectFindingCategory(String s) {
    wait.until(ExpectedConditions.elementToBeClickable(pp.medicineCat)).click();
    wait.until(ExpectedConditions.visibilityOf(pp.search)).sendKeys(s);
    pp.search.sendKeys(Keys.ENTER);
}
public void selectMedicineCategory(String s) {
    wait.until(ExpectedConditions.elementToBeClickable(pp.medicineName)).click();
    wait.until(ExpectedConditions.visibilityOf(pp.search)).sendKeys(s);
    pp.search.sendKeys(Keys.ENTER);
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
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void selectDoseInterval(String s) {
    wait.until(ExpectedConditions.elementToBeClickable(pp.doseInterval)).click();
    wait.until(ExpectedConditions.visibilityOf(pp.search)).sendKeys(s);
    pp.search.sendKeys(Keys.ENTER);
}
public void selectDoseDuration(String s) {
    wait.until(ExpectedConditions.elementToBeClickable(pp.doseDuration)).click();
    wait.until(ExpectedConditions.visibilityOf(pp.search)).sendKeys(s);
    pp.search.sendKeys(Keys.ENTER);
}
public void OPDSection() {
	clickMethod(pp.opd);
}
public void addPres(){
	clickMethod(pp.addPrescription);
}
public void assertPP() throws InterruptedException {
	String ex="Add Prescription";
	String act=pp.text.getText();
	Assert.assertEquals(ex, act);
//	pp.addMedicine.click();
//	Thread.sleep(1000);
}
public void save(){
	clickMethod(pp.save);
}
public void edit() {
	clickMethod(pp.edit);
}
WebDriverWait w= new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();

public void clickMethod(WebElement ele) {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();
    } catch (ElementClickInterceptedException e) {
        // Fallback to JavaScript click
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
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(pp.errorMsg));
	String act=pp.errorMsg.getText();
	System.out.println("Expected: " + ex);
	System.out.println("Actual: " + act);
	Assert.assertTrue(act.contains(ex));
}
}
