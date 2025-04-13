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
		objPatientPage.userLoginBtn.click();
	}
	
	public void ClickSignInBtn() {
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
		objPatientPage.email.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	}
	
	public void BlankPassword() {
		objPatientPage.password.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	}
	
	public String getUserNameRequired() {
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
		
//		String Availableslot = details.get("AvailableSlot");
//		Select selectAvailableSlot = new Select(objPDP.AvailableSlot);
//		List<WebElement> AvailableslotTiming = selectAvailableSlot.getOptions();
//		for(WebElement AvailtimeSlot : AvailableslotTiming) {
//			if(AvailtimeSlot.getText().contains(Availableslot)) {
//				AvailtimeSlot.click();
//				System.out.println(AvailtimeSlot.getText());
//				break;
//			}
//		}
		
		objPDP.AvailableSlot.click();
		System.out.println(objPDP.AvailableSlot.getText());
		objPDP.patientMsg.sendKeys(details.get("Message"));
		System.out.println(details.get("Message"));
	}
}

