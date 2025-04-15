package com.actions;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.PatientDischargePage;
import com.utils.HelperClass;

public class PatientDischargeActions {
	PatientDischargePage objPDP = null ;
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));
	
	public PatientDischargeActions() {
		objPDP = new PatientDischargePage();
		PageFactory.initElements(HelperClass.getDriver(), objPDP);
	}
	
	public void ClickIPD() {
		wait.until(ExpectedConditions.visibilityOf(objPDP.ipd));
		objPDP.ipd.click();
	}
	
	public void ClickFirstPatient() {
		wait.until(ExpectedConditions.elementToBeClickable(objPDP.firstPatient));
		objPDP.firstPatient.click();
	}
	
	public void setCaseId(String id)  {
		wait.until(ExpectedConditions.elementToBeClickable(objPDP.searchField));
		objPDP.searchField.sendKeys(id+Keys.CONTROL.ENTER);
		
	}
	public String getPatientID() {
		wait.until(ExpectedConditions.visibilityOf(objPDP.dischargePatientName));
		return objPDP.dischargePatientName.getText();
	}
	public void ClickDischargeBtn() {
		wait.until(ExpectedConditions.visibilityOf(objPDP.dischargeIcon));
		objPDP.dischargeIcon.click();
	}
	
	public void setDischargeDate() {
		wait.until(ExpectedConditions.visibilityOf(objPDP.dischargeDate));
		objPDP.dischargeDate.click();
	}
	
	public void setDischargeStatus(String status) {
		wait.until(ExpectedConditions.visibilityOf(objPDP.dischargeStatus));
		objPDP.dischargeStatus.sendKeys(status);
	}
	
	public void ClickDischargeSaveBtn() {
		wait.until(ExpectedConditions.visibilityOf(objPDP.dischargeSaveBtn));
		objPDP.dischargeSaveBtn.click();
	}
	
	public String getError() {
		return objPDP.error.getText();
	}
}
