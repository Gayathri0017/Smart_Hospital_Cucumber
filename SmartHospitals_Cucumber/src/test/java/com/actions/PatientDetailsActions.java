package com.actions;

import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.PatientDashboardPage;
import com.utils.HelperClass;

public class PatientDetailsActions {
	
	PatientDashboardPage objPDP = null ;
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
	
	public PatientDetailsActions() {
		objPDP = new PatientDashboardPage();
		PageFactory.initElements(HelperClass.getDriver(), objPDP);
	}
	
	public String getPatientId() {
		return objPDP.patientid.getText();
	}
	
	public String getMaritalStatus() {
		return objPDP.patientMaritalStatus.getText();
	}
	
	public String getEmail() {
		return objPDP.patientAddress.getText();
	}
	
	public String getAge() {
		return objPDP.patientAge.getText();
	}
	
	public String getGender() {
		return objPDP.patientGender.getText();
	}
	
	public String getPhone() {
		return objPDP.patientPhone.getText();
	}
	
	public String getAddress() {
		return objPDP.patientAddress.getText();
		
		
	}
	
	public String getGuardianName() {
		return objPDP.patientGuardianName.getText();
	}
}