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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PatientActions {
	PatientWorkflowPage objPatientPage=null;
	PatientDashboardPage objPDP=null;
	WebDriverWait wait=new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));
	private static final Logger logger=LogManager.getLogger(PatientActions.class);
	public PatientActions() {
		objPatientPage=new PatientWorkflowPage();
		objPDP=new PatientDashboardPage();
		PageFactory.initElements(HelperClass.getDriver(), objPatientPage);
		PageFactory.initElements(HelperClass.getDriver(), objPDP);
	}
	public void ClickUserLoginBtn() {
		logger.info("Clicking user login button");
		objPatientPage.userLoginBtn.click();
	}
	public void ClickSignInBtn() {
		logger.info("Clicking sign in button");
		objPatientPage.signInBtn.click();
	}
	public void ClickProfile() {
		logger.info("Clicking profile");
		objPDP.profile.click();
	}
	public String getProfileRole() {
		wait.until(ExpectedConditions.visibilityOf(objPDP.verifyProfile));
		String role=objPDP.verifyProfile.getText();
		return role;
	}
	public void SwitchTab() {
		Set<String> Allwindows=HelperClass.getDriver().getWindowHandles();
		Iterator<String> it=Allwindows.iterator();
		String mainWindow=it.next();
		String childWindow=it.next();
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
		String message=objPatientPage.usernameReq.getText();
		logger.info("Username required message: "+message);
		return message;
	}
	public String getPasswordRequired() {
		String message=objPatientPage.passwordReq.getText();
		logger.info("Password required message: "+message);
		return message;
	}
	public void ClickFormsubmit() {
		logger.info("Clicking form submit button");
		objPDP.formSubmit.click();
	}
	public void ClickMyAppointment() {
		logger.info("Clicking 'My Appointment'");
		objPDP.myAppointment.click();
	}
	public void ClickAddAppointment() {
		logger.info("Clicking 'Add Appointment'");
		objPDP.addAppointment.click();
	}
	public void setDate(String date) {
		wait.until(ExpectedConditions.visibilityOf(objPDP.date));
		if(date!=null && !date.isEmpty()) {
			objPDP.date.clear();
			objPDP.date.sendKeys(date);
			logger.info("Date set to: "+date);
		} else {
			objPDP.date.clear();
			logger.warn("Date field is empty or null");
		}
	}
	public void setSpecialist(String specialist) {
		wait.until(ExpectedConditions.visibilityOf(objPDP.specialist));
		if(specialist!=null && !specialist.isEmpty()) {
			Select selectSpecialist=new Select(objPDP.specialist);
			selectSpecialist.selectByVisibleText(specialist);
			logger.info("Specialist selected: "+specialist);
		} else {
			logger.warn("Specialist field is empty or null");
		}
	}
	public void setDoctor(String doctor) {
		wait.until(ExpectedConditions.visibilityOf(objPDP.doctor));
		Select selectDoctor=new Select(objPDP.doctor);
		selectDoctor.selectByVisibleText(doctor);
		logger.info("Doctor selected: "+doctor);
	}
	public void setShift(String shift) {
		wait.until(ExpectedConditions.visibilityOf(objPDP.timingShift));
		Select selectTiming=new Select(objPDP.timingShift);
		selectTiming.selectByVisibleText(shift);
		logger.info("Shift selected: "+shift);
	}
	public void setTime(String slot) {
		wait.until(ExpectedConditions.visibilityOf(objPDP.slot));
		Select selectSlot=new Select(objPDP.slot);
		selectSlot.selectByVisibleText(slot);
		logger.info("Slot selected: "+slot);
	}
	public void setAvailableTime() {
		wait.until(ExpectedConditions.visibilityOf(objPDP.AvailableSlot));
		objPDP.AvailableSlot.click();
		logger.info("Available time clicked: "+objPDP.AvailableSlot.getText());
	}
	public void setMessage(String message) {
		if(message!=null && !message.isEmpty()) {
			objPDP.patientMsg.sendKeys(message);
			logger.info("Message entered: "+message);
		} else {
			logger.warn("Message field is empty or null");
		}
	}
	public String getError() {
		wait.until(ExpectedConditions.visibilityOf(objPDP.FieldRequired));
		String error=objPDP.FieldRequired.getText();
		logger.info("Form validation error: "+error);
		return error;
	}
	public void AppointmentDetails() {
		logger.info("Reading appointment details from Excel");
		Map<String,String> details=ExcelReader.getPatientAppointmentForm("src\\test\\resources\\PatientAppointmentData.xlsx","Sheet1");

		objPDP.date.sendKeys(details.get("Date"));
		objPDP.date.sendKeys(Keys.CONTROL.ENTER+"a"+Keys.CONTROL.BACK_SPACE+details.get("Date"));
		logger.info("Date: "+details.get("Date"));

		String specialistName=details.get("Specialist");
		wait.until(ExpectedConditions.visibilityOf(objPDP.specialist));
		Select selectSpecialist=new Select(objPDP.specialist);
		List<WebElement> specialist=selectSpecialist.getOptions();
		for(WebElement Sname:specialist) {
			if(Sname.getText().contains(specialistName)) {
				Sname.click();
				logger.info("Specialist found and selected: "+Sname.getText());
				break;
			}
		}

		String doctorName=details.get("Doctor");
		wait.until(ExpectedConditions.visibilityOf(objPDP.doctor));
		Select selectDoctor=new Select(objPDP.doctor);
		List<WebElement> doctor=selectDoctor.getOptions();
		for(WebElement Dname:doctor) {
			if(Dname.getText().contains(doctorName)) {
				Dname.click();
				logger.info("Doctor selected: "+Dname.getText());
				break;
			}
		}
		String timing=details.get("Shift");
		wait.until(ExpectedConditions.visibilityOf(objPDP.timingShift));
		Select selectTiming=new Select(objPDP.timingShift);
		List<WebElement> time=selectTiming.getOptions();
		for(WebElement shift:time) {
			if(shift.getText().contains(timing)) {
				shift.click();
				logger.info("Timing shift selected: "+shift.getText());
				break;
			}
		}
		String slot=details.get("Slot");
		wait.until(ExpectedConditions.visibilityOf(objPDP.slot));
		Select selectSlot=new Select(objPDP.slot);
		List<WebElement> slotTiming=selectSlot.getOptions();
		for(WebElement timeSlot:slotTiming) {
			if(timeSlot.getText().contains(slot)) {
				timeSlot.click();
				logger.info("Slot selected: "+timeSlot.getText());
				break;
			}
		}
		objPDP.AvailableSlot.click();
		logger.info("Available slot clicked: "+objPDP.AvailableSlot.getText());
		objPDP.patientMsg.sendKeys(details.get("Message"));
		logger.info("Message: "+details.get("Message"));
	}
}
