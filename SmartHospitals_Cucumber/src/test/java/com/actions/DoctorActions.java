package com.actions;
import java.io.File;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.pages.DoctorWorkflowPage;
import com.utils.ExcelReader;
import com.utils.HelperClass;
public class DoctorActions{
DoctorWorkflowPage dp=null;
public DoctorActions(){
	this.dp=new DoctorWorkflowPage();
	PageFactory.initElements(HelperClass.getDriver(), dp);
}
public void login() {
	dp.doctor.click();
	dp.signin.click();
}
public void english() {
	dp.lan.click();
	dp.eng.click();
}
public void appointment() {
	clickMethod(dp.appointment);
}
public void addAppointment() {
	clickMethod(dp.addAppointment);
}
public void addPatient() {
	clickMethod(dp.addpatient);
}
ExcelReader reader = new ExcelReader("src\\test\\resources\\Book2.xlsx");
public void addPatientDetails() {
	String name=reader.getCellData("Sheet1", 0, 0);
	String gender= reader.getCellData("Sheet1", 0, 1);
	String year= reader.getCellData("Sheet1", 0, 2);
	String month= reader.getCellData("Sheet1", 0, 3);
	String day= reader.getCellData("Sheet1", 0,4);
	String bloodgrp= reader.getCellData("Sheet1", 0,5);
	sendKeysMethod(dp.pName,name);
	Select gen=new Select(dp.gender);
	gen.selectByVisibleText(gender);
	sendKeysMethod(dp.year,year);
	sendKeysMethod(dp.month,month);
	sendKeysMethod(dp.day,day);
	Select bg=new Select(dp.bloodGroup);
	bg.selectByVisibleText(bloodgrp);
	 String path="src\\test\\resources\\patient.jpg";
	 File file=new File(path);
	  String absolutePath = file.getAbsolutePath();
	    dp.uploadPhoto.sendKeys(absolutePath);
}
public void addPatientDetails1(){
	String name=reader.getCellData("Sheet1", 2, 0);
	String gender= reader.getCellData("Sheet1", 2, 1);
	String year= reader.getCellData("Sheet1", 2, 2);
	String month= reader.getCellData("Sheet1", 2, 3);
	String day= reader.getCellData("Sheet1", 2,4);
	sendKeysMethod(dp.pName,name);
	Select gen=new Select(dp.gender);
	gen.selectByVisibleText(gender);
	sendKeysMethod(dp.year,year);
	sendKeysMethod(dp.month,month);
	sendKeysMethod(dp.day,day);
}
public void addPatientDetails2(){
	String name=reader.getCellData("Sheet1", 3, 0);
	String gender= reader.getCellData("Sheet1", 3, 1);
	String year= reader.getCellData("Sheet1", 3, 2);
	String month= reader.getCellData("Sheet1", 3, 3);
	String day= reader.getCellData("Sheet1", 3,4);
	sendKeysMethod(dp.pName,name);
	Select gen=new Select(dp.gender);
	gen.selectByVisibleText(gender);
	sendKeysMethod(dp.year,year);
	sendKeysMethod(dp.month,month);
	sendKeysMethod(dp.day,day);
}
public void addPatientDetails3(){
	String name=reader.getCellData("Sheet1", 4, 0);
	String gender= reader.getCellData("Sheet1", 4, 1);
	String year= reader.getCellData("Sheet1", 4, 2);
	String month= reader.getCellData("Sheet1", 4, 3);
	String day= reader.getCellData("Sheet1", 4,4);
	sendKeysMethod(dp.pName,name);
	Select gen=new Select(dp.gender);
	gen.selectByVisibleText(gender);
	sendKeysMethod(dp.year,year);
	sendKeysMethod(dp.month,month);
	sendKeysMethod(dp.day,day);
}
public void addPatientDetails4(){
	String name=reader.getCellData("Sheet1", 5, 0);
	String gender= reader.getCellData("Sheet1", 5, 1);
	String year= reader.getCellData("Sheet1", 5, 2);
	String month= reader.getCellData("Sheet1", 5, 3);
	String day= reader.getCellData("Sheet1", 5,4);
	sendKeysMethod(dp.pName,name);
	Select gen=new Select(dp.gender);
	gen.selectByVisibleText(gender);
	sendKeysMethod(dp.year,year);
	sendKeysMethod(dp.month,month);
	sendKeysMethod(dp.day,day);
}
public void save(){
	clickMethod(dp.saveBtn);
}
public void assertPatient() {
	String name=reader.getCellData("Sheet1", 0, 0);
	String actual=dp.nameAfterAdd.getText();
	//Assert.assertEquals(name,actual);
	Assert.assertTrue(actual.contains(name));
}
public void addAppointmentDetails() {
	String doctor=reader.getCellData("Sheet1", 0, 6);
	String shift=reader.getCellData("Sheet1", 0, 7);
	//String date=reader.getCellData("Sheet1", 0, 9);
	String slot=reader.getCellData("Sheet1", 0, 9);
	String status=reader.getCellData("Sheet1", 0, 10);
	String dis=reader.getCellData("Sheet1", 0, 11);
	Select doc=new Select(dp.doc);
	//doc.selectByVisibleText(doctor);
	doc.selectByIndex(1);
	Select sft=new Select(dp.shift);
	sft.selectByVisibleText(shift);
	dp.date.click();
	dp.date.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	sendKeysMethod(dp.date,"05/10/2025  16:26:00");
	dp.date.sendKeys(Keys.ENTER);
	Select slt=new Select(dp.slot);
	slt.selectByVisibleText(slot);
	Select sts=new Select(dp.status);
	sts.selectByVisibleText(status);
	sendKeysMethod(dp.discount,dis);
}
public void addAppointmentDetails1() {
	String doctor=reader.getCellData("Sheet1", 1, 6);
	String shift=reader.getCellData("Sheet1", 1, 7);
	//String date=reader.getCellData("Sheet1", 1, 9);
	String slot=reader.getCellData("Sheet1", 1, 9);
	Select doc=new Select(dp.doc);
	//doc.selectByVisibleText(doctor);
	doc.selectByIndex(1);
	Select sft=new Select(dp.shift);
	sft.selectByVisibleText(shift);
	dp.date.click();
	dp.date.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	sendKeysMethod(dp.date,"04/06/2024 12:00 AM");
	dp.date.sendKeys(Keys.ENTER);
	Select slt=new Select(dp.slot);
	slt.selectByVisibleText(slot);
//	Select sts=new Select(dp.status);
//	sts.selectByVisibleText(status);
//	sendKeysMethod(dp.discount,dis);
}
public void addedPatient() {
	String ex=dp.patient.getText();
	String name=reader.getCellData("Sheet1", 0, 0);
	Assert.assertTrue(ex.contains(name));
}
public void nameRequired(String ex) {
	String ac=dp.nameError.getText();
	Assert.assertEquals(ex,ac);
}
public void saveApp() {
	clickMethod(dp.savebtn);
}

public void clickMethod(WebElement ele) {
	ele.click();
}
public void sendKeysMethod(WebElement ele,String str) {
	ele.sendKeys(str);
}
}
