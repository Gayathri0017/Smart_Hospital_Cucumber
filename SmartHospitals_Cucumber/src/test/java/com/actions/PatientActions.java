package com.actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.PatientDashboardPage;
import com.pages.PatientWorkflowPage;
import com.utils.ExcelReader;
import com.utils.HelperClass;

public class PatientActions {
	
	PatientWorkflowPage objPatientPage = null ;
	PatientDashboardPage objPDP = null ;
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));
	
	public PatientActions() {
		objPatientPage = new PatientWorkflowPage();
		objPDP = new PatientDashboardPage();
		PageFactory.initElements(HelperClass.getDriver(), objPatientPage);
		PageFactory.initElements(HelperClass.getDriver(), objPDP);
	}
	
	
	public void ClickUserLoginBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(objPatientPage.userLoginBtn));
		objPatientPage.userLoginBtn.click();
	}
	
	public void ClickSignInBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(objPatientPage.signInBtn));
		objPatientPage.signInBtn.click();
	}
	
	public void ClickProfile() {
		objPDP.profile.click();
	}
	
	public String getProfileRole() {
		wait.until(ExpectedConditions.visibilityOf(objPDP.verifyProfile));
		
		return objPDP.verifyProfile.getText();
	}
	
	public void SwitchTab() {
		Set<String> Allwindows = HelperClass.getDriver().getWindowHandles();
		Iterator<String> it = Allwindows.iterator();
		String mainWindow = it.next();
		String childWindow = it.next();
		HelperClass.getDriver().switchTo().window(childWindow);
	}
	
	public void BlankUsername() {
		wait.until(ExpectedConditions.visibilityOf(objPatientPage.email));
		objPatientPage.email.clear();
		objPatientPage.email.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	}
	
	public void BlankPassword() {		
		wait.until(ExpectedConditions.visibilityOf(objPatientPage.password));
		objPatientPage.password.clear();
	}
	
	public String getUserNameRequired() {
		wait.until(ExpectedConditions.visibilityOf(objPatientPage.usernameReq));
		return objPatientPage.usernameReq.getText();
	}
	
	public String getPasswordRequired() {
		return objPatientPage.passwordReq.getText();
	}
	
	public void ClickFormsubmit() {
		objPDP.formSubmit.click();
	}
	
	public void ClickMyAppointment() {
		objPDP.myAppointment.click();
	}
	
	public void ClickAddAppointment() {
		objPDP.addAppointment.click();
	}
	
	public void setDate(String date) {
		wait.until(ExpectedConditions.visibilityOf(objPDP.date));
	    if (date != null && !date.isEmpty()) {
	    	objPDP.date.clear();
	        objPDP.date.sendKeys(date);
	    } else {
	        objPDP.date.clear();
	    }

	}
	
	public void setSpecialist(String specialist) {
		wait.until(ExpectedConditions.visibilityOf(objPDP.specialist));
	    if (specialist != null && !specialist.isEmpty()) {
	        Select selectSpecialist = new Select(objPDP.specialist);
	        selectSpecialist.selectByVisibleText(specialist);
	    } else {
	        System.out.println("Specialist field is empty or null");
	    }
	}
	
	public void setDoctor(String doctor) {
		wait.until(ExpectedConditions.elementToBeClickable(objPDP.doctor));
		Select selectDoctor = new Select(objPDP.doctor);
		selectDoctor.selectByVisibleText(doctor);
	}
	
	public void setShift(String shift) {
		wait.until(ExpectedConditions.elementToBeClickable(objPDP.timingShift));
		Select selectTiming = new Select(objPDP.timingShift);
		selectTiming.selectByVisibleText(shift);
	}
	
	public void setTime(String slot) {
		wait.until(ExpectedConditions.visibilityOf(objPDP.slot));
		Select selectSlot = new Select(objPDP.slot);
		selectSlot.selectByVisibleText(slot);
	}
	
	public void setAvailableTime() {
		
		wait.until(ExpectedConditions.elementToBeClickable(objPDP.AvailableSlot));
		objPDP.AvailableSlot.click();
	}
	
	public void setMessage(String message) {
		if(message != null && !message.isEmpty()) {
			
			objPDP.patientMsg.sendKeys(message);
		}
		else{
			System.out.println("Message field is empty or null");
		}
	}
	
	public String getError() {
		wait.until(ExpectedConditions.visibilityOf(objPDP.FieldRequired));
		return objPDP.FieldRequired.getText();
	}
	public void AppointmentDetails() {
		Map<String , String> details = ExcelReader.getPatientAppointmentForm("C:\\Users\\Dhanusheswaran M\\git\\Smart_Hospital_Cucumber_Project\\SmartHospitals_Cucumber\\src\\test\\resources\\PatientAppointmentData.xlsx" , "Sheet1");

		objPDP.date.sendKeys(details.get("Date"));
		objPDP.date.sendKeys(Keys.CONTROL.ENTER+"a"+Keys.CONTROL.BACK_SPACE+details.get("Date"));
		
		System.out.println(details.get("Date"));
		
		String specialistName = details.get("Specialist");
		wait.until(ExpectedConditions.visibilityOf(objPDP.specialist));
		Select selectSpecialist = new Select(objPDP.specialist);
		List<WebElement> specialist = selectSpecialist.getOptions();
		for(WebElement Sname : specialist) {
			if(Sname.getText().contains(specialistName)) {
				Sname.click();
				System.out.println(Sname.getText());
				break;
			}
		}
		
		String doctorName = details.get("Doctor");
		wait.until(ExpectedConditions.visibilityOf(objPDP.doctor));
		Select selectDoctor = new Select(objPDP.doctor);
		List<WebElement> doctor = selectDoctor.getOptions();
		for(WebElement Dname : doctor) {
			if(Dname.getText().contains(doctorName)) {
				Dname.click();
				System.out.println(Dname.getText());
				break;
			}
		}
		
		String timing = details.get("Shift");
		wait.until(ExpectedConditions.visibilityOf(objPDP.timingShift));
		Select selectTiming = new Select(objPDP.timingShift);
		List<WebElement> time = selectTiming.getOptions();
		for(WebElement shift : time) {
			if(shift.getText().contains(timing)) {
				shift.click();
				System.out.println(shift.getText());
				break;
			}
		}
		
		String slot = details.get("Slot");
		wait.until(ExpectedConditions.visibilityOf(objPDP.slot));
		Select selectSlot = new Select(objPDP.slot);
		List<WebElement> slotTiming = selectSlot.getOptions();
		for(WebElement timeSlot : slotTiming) {
			if(timeSlot.getText().contains(slot)) {
				timeSlot.click();
				System.out.println(timeSlot.getText());
				break;
			}
		}
		

		objPDP.AvailableSlot.click();
		System.out.println(objPDP.AvailableSlot.getText());
		objPDP.patientMsg.sendKeys(details.get("Message"));
		System.out.println(details.get("Message"));
	}
}