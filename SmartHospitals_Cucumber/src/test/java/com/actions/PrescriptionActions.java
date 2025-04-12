package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pages.PrescriptionPage;
import com.utils.HelperClass;

public class PrescriptionActions{
public PrescriptionPage pp=null;
public PrescriptionActions() {
	this.pp=new PrescriptionPage();
	PageFactory.initElements(HelperClass.getDriver(),pp);
}
public void selectFindingCategory(String s) throws InterruptedException {
	Thread.sleep(1000);
	clickMethod(pp.medicineCat);
	Thread.sleep(1000);
	//WebElement ele= HelperClass.getDriver().findElement(By.xpath("(//input[@class=\"select2-search__field\"])[6]"));
	sendKeysMethod(pp.search,s);
	pp.search.sendKeys(Keys.ENTER);
}
public void selectMedicineCategory(String s) throws InterruptedException {
	clickMethod(pp.medicineName);
	Thread.sleep(1000);
	sendKeysMethod(pp.search,s);
	pp.search.sendKeys(Keys.ENTER);
}
public void selectMedicine(String s) throws InterruptedException {
	clickMethod(pp.dose);
	Thread.sleep(1000);
	sendKeysMethod(pp.search,s);
	pp.search.sendKeys(Keys.ENTER);
}
public void selectDoseInterval(String s) throws InterruptedException {
	clickMethod(pp.doseInterval);
	Thread.sleep(1000);
	sendKeysMethod(pp.search,s);
	pp.search.sendKeys(Keys.ENTER);
}
public void selectDoseDuration(String s) throws InterruptedException {
	clickMethod(pp.doseDuration);
	Thread.sleep(1000);
	sendKeysMethod(pp.search,s);
	pp.search.sendKeys(Keys.ENTER);
}
public void OPDSection() {
	clickMethod(pp.opd);
}
public void addPres() {
	clickMethod(pp.addPrescription);
}
public void assertPP() throws InterruptedException {
	String ex="Add Prescription";
	String act=pp.text.getText();
	Assert.assertEquals(ex, act);
//	pp.addMedicine.click();
//	Thread.sleep(1000);
}
public void save() {
	clickMethod(pp.save);
}
public void clickMethod(WebElement ele) {
	ele.click();
}
public void sendKeysMethod(WebElement ele,String text) {
	ele.sendKeys(text);
}
}
