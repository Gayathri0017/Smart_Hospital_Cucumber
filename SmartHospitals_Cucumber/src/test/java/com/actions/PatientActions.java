package com.actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger log = LogManager.getLogger(PatientActions.class);
    PatientWorkflowPage objPatientPage = null;
    PatientDashboardPage objPDP = null;
    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));

    public PatientActions() {
        objPatientPage = new PatientWorkflowPage();
        objPDP = new PatientDashboardPage();
        PageFactory.initElements(HelperClass.getDriver(), objPatientPage);
        PageFactory.initElements(HelperClass.getDriver(), objPDP);
    }

    public void ClickUserLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(objPatientPage.userLoginBtn));
        objPatientPage.userLoginBtn.click();
        log.info("User login button clicked");
    }

    public void ClickSignInBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(objPatientPage.signInBtn));
        objPatientPage.signInBtn.click();
        log.info("Sign-in button clicked");
    }

    public void ClickProfile() {
        objPDP.profile.click();
        log.info("Profile clicked");
    }

    public String getProfileRole() {
        wait.until(ExpectedConditions.visibilityOf(objPDP.verifyProfile));
        log.info("Verifying the profile");
        return objPDP.verifyProfile.getText();
    }

    public void SwitchTab() {
        Set<String> Allwindows = HelperClass.getDriver().getWindowHandles();
        Iterator<String> it = Allwindows.iterator();
        String mainWindow = it.next();
        String childWindow = it.next();
        HelperClass.getDriver().switchTo().window(childWindow);
        log.info("Driver window switched");
    }

    public void BlankUsername() {
        wait.until(ExpectedConditions.visibilityOf(objPatientPage.email));
        objPatientPage.email.clear();
        objPatientPage.email.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        log.info("Blank username provided");
    }

    public void BlankPassword() {
        wait.until(ExpectedConditions.visibilityOf(objPatientPage.password));
        objPatientPage.password.clear();
        log.info("Blank password provided");
    }

    public String getUserNameRequired() {
        wait.until(ExpectedConditions.visibilityOf(objPatientPage.usernameReq));
        log.info("Username required message retrieved");
        return objPatientPage.usernameReq.getText();
    }

    public String getPasswordRequired() {
        log.info("Password required message retrieved");
        return objPatientPage.passwordReq.getText();
    }

    public void ClickFormsubmit() {
        objPDP.formSubmit.click();
        log.info("Form submitted");
    }

    public void ClickMyAppointment() {
        objPDP.myAppointment.click();
        log.info("My Appointment option clicked");
    }

    public void ClickAddAppointment() {
        objPDP.addAppointment.click();
        log.info("Adding the appointment");
    }

    public void setDate(String date) {
        wait.until(ExpectedConditions.visibilityOf(objPDP.date));
        if (date != null && !date.isEmpty()) {
            objPDP.date.clear();
            objPDP.date.sendKeys(date);
        } else {
            objPDP.date.clear();
        }
        log.info("Date field provided");
    }

    public void setSpecialist(String specialist) {
        wait.until(ExpectedConditions.visibilityOf(objPDP.specialist));
        if (specialist != null && !specialist.isEmpty()) {
            Select selectSpecialist = new Select(objPDP.specialist);
            selectSpecialist.selectByVisibleText(specialist);
        } else {
            log.info("Specialist field is empty or null");
        }
        log.info("Specialist field provided");
    }

    public void setDoctor(String doctor) {
        wait.until(ExpectedConditions.elementToBeClickable(objPDP.doctor));
        Select selectDoctor = new Select(objPDP.doctor);
        selectDoctor.selectByVisibleText(doctor);
        log.info("Doctor field provided");
    }

    public void setShift(String shift) {
        wait.until(ExpectedConditions.elementToBeClickable(objPDP.timingShift));
        Select selectTiming = new Select(objPDP.timingShift);
        selectTiming.selectByVisibleText(shift);
        log.info("Timing shift field provided");
    }

    public void setTime(String slot) {
        wait.until(ExpectedConditions.visibilityOf(objPDP.slot));
        Select selectSlot = new Select(objPDP.slot);
        selectSlot.selectByVisibleText(slot);
        log.info("Slot provided");
    }

    public void setAvailableTime() {
        wait.until(ExpectedConditions.visibilityOf(objPDP.AvailableSlot));
        wait.until(ExpectedConditions.elementToBeClickable(objPDP.AvailableSlot));
        objPDP.AvailableSlot.click();
        log.info("Available time provided");
    }

    public void setMessage(String message) {
        if (message != null && !message.isEmpty()) {
            objPDP.patientMsg.sendKeys(message);
        } else {
            log.info("Message field is empty or null");
        }
    }

    public String getError() {
        wait.until(ExpectedConditions.visibilityOf(objPDP.FieldRequired));
        log.info("Field required error message retrieved");
        return objPDP.FieldRequired.getText();
    }

    public void AppointmentDetails() {
        Map<String, String> details = ExcelReader.getPatientAppointmentForm("src\\test\\resources\\PatientAppointmentData.xlsx", "Sheet1");
        
        wait.until(ExpectedConditions.elementToBeClickable(objPDP.date));
        objPDP.date.sendKeys(details.get("Date"));
        objPDP.date.sendKeys(Keys.CONTROL.ENTER + "a" + Keys.CONTROL + Keys.BACK_SPACE + details.get("Date"));
        log.info("Date field provided from Excel\nDate:"+details.get("Date"));

        String specialistName = details.get("Specialist");
        wait.until(ExpectedConditions.visibilityOf(objPDP.specialist));
        Select selectSpecialist = new Select(objPDP.specialist);
        List<WebElement> specialist = selectSpecialist.getOptions();
        for (WebElement Sname : specialist) {
            if (Sname.getText().contains(specialistName)) {
                Sname.click();
                log.info("Specialist selected from dropdown : "+Sname.getText());
                break;
            }
        }

        String doctorName = details.get("Doctor");
        wait.until(ExpectedConditions.visibilityOf(objPDP.doctor));
        Select selectDoctor = new Select(objPDP.doctor);
        List<WebElement> doctor = selectDoctor.getOptions();
        for (WebElement Dname : doctor) {
            if (Dname.getText().contains(doctorName)) {
                Dname.click();
                log.info("Doctor selected from dropdown : "+Dname.getText());
                break;
            }
        }

        String timing = details.get("Shift");
        wait.until(ExpectedConditions.visibilityOf(objPDP.timingShift));
        Select selectTiming = new Select(objPDP.timingShift);
        List<WebElement> time = selectTiming.getOptions();
        for (WebElement shift : time) {
            if (shift.getText().contains(timing)) {
                shift.click();
                log.info("Timing shift selected from dropdown : "+shift.getText());
                break;
            }
        }

        String slot = details.get("Slot");
        wait.until(ExpectedConditions.visibilityOf(objPDP.slot));
        Select selectSlot = new Select(objPDP.slot);
        List<WebElement> slotTiming = selectSlot.getOptions();
        for (WebElement timeSlot : slotTiming) {
            if (timeSlot.getText().contains(slot)) {
                timeSlot.click();
                log.info("Slot selected from dropdown : "+timeSlot.getText());
                break;
            }
        }
        wait.until(ExpectedConditions.alertIsPresent());
        HelperClass.getDriver().switchTo().alert().accept();
        
        wait.until(ExpectedConditions.elementToBeClickable(objPDP.AvailableSlot));
        objPDP.AvailableSlot.click();
        log.info("Available slot clicked");
        objPDP.patientMsg.sendKeys(details.get("Message"));
        log.info("Message field provided from Excel : "+details.get("Message"));
    }
}