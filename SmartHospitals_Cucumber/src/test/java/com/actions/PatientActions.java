package com.actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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
        try {
            wait.until(ExpectedConditions.elementToBeClickable(objPatientPage.userLoginBtn));
            objPatientPage.userLoginBtn.click();
            log.info("User login button clicked");
        } catch (Exception e) {
            log.error("Error clicking user login button", e);
        }
    }

    public void ClickSignInBtn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(objPatientPage.signInBtn));
            objPatientPage.signInBtn.click();
            log.info("Sign-in button clicked");
        } catch (Exception e) {
            log.error("Error clicking sign-in button", e);
        }
    }

    public void ClickProfile() {
        try {
            objPDP.profile.click();
            log.info("profile clicked");
        } catch (Exception e) {
            log.error("Error clicking profile", e);
        }
    }

    public String getProfileRole() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPDP.verifyProfile));
            log.info("Verifying the profile");
            return objPDP.verifyProfile.getText();
        } catch (Exception e) {
            log.error("Error getting profile role", e);
            return null;
        }
    }

    public void SwitchTab() {
        try {
            Set<String> Allwindows = HelperClass.getDriver().getWindowHandles();
            Iterator<String> it = Allwindows.iterator();
            String mainWindow = it.next();
            String childWindow = it.next();
            HelperClass.getDriver().switchTo().window(childWindow);
            log.info("Driver window switched");
        } catch (Exception e) {
            log.error("Error switching driver window", e);
        }
    }

    public void BlankUsername() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPatientPage.email));
            objPatientPage.email.clear();
            objPatientPage.email.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
            log.info("Blank username provided");
        } catch (Exception e) {
            log.error("Error in the username passing", e);
        }
    }

    public void BlankPassword() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPatientPage.password));
            objPatientPage.password.clear();
            log.info("Blank password provided");
        } catch (Exception e) {
            log.error("Error in the password passing", e);
        }
    }

    public String getUserNameRequired() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPatientPage.usernameReq));
            log.info("Username required message retrieved");
            return objPatientPage.usernameReq.getText();
        } catch (Exception e) {
            log.error("Error getting in username required message", e);
            return null;
        }
    }

    public String getPasswordRequired() {
        try {
            log.info("Password required message retrieved");
            return objPatientPage.passwordReq.getText();
        } catch (Exception e) {
            log.error("Error getting in password required message", e);
            return null;
        }
    }

    public void ClickFormsubmit() {
        try {
            objPDP.formSubmit.click();
            log.info("Form submitted");
        } catch (Exception e) {
            log.error("Error in clicking form submit", e);
        }
    }

    public void ClickMyAppointment() {
        try {
            objPDP.myAppointment.click();
            log.info("My Appointment option clicked");
        } catch (Exception e) {
            log.error("My Appointment option clicking got failed", e);
        }
    }

    public void ClickAddAppointment() {
        try {
            objPDP.addAppointment.click();
            log.info("Adding the appointment");
        } catch (Exception e) {
            log.error("Adding the appointment got failed", e);
        }
    }

    public void setDate(String date) {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPDP.date));
            if (date != null && !date.isEmpty()) {
                objPDP.date.clear();
                objPDP.date.sendKeys(date);
            } else {
                objPDP.date.clear();
            }
            log.info("Date field provided");
        } catch (Exception e) {
            log.error("Error in setting the date", e);
        }
    }

    public void setSpecialist(String specialist) {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPDP.specialist));
            if (specialist != null && !specialist.isEmpty()) {
                Select selectSpecialist = new Select(objPDP.specialist);
                selectSpecialist.selectByVisibleText(specialist);
            } else {
                log.info("Specialist field is empty or null");
            }
            log.info("Specialist field provided");
        } catch (Exception e) {
            log.error("Error in setting the specialist", e);
        }
    }

    public void setDoctor(String doctor) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(objPDP.doctor));
            Select selectDoctor = new Select(objPDP.doctor);
            selectDoctor.selectByVisibleText(doctor);
            log.info("Doctor field provided");
        } catch (Exception e) {
            log.error("Error in setting the doctor", e);
        }
    }

    public void setShift(String shift) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(objPDP.timingShift));
            Select selectTiming = new Select(objPDP.timingShift);
            selectTiming.selectByVisibleText(shift);
            log.info("Timing shift field provided");
        } catch (Exception e) {
            log.error("Error in setting the timing shift", e);
        }
    }

    public void setTime(String slot) {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPDP.slot));
            Select selectSlot = new Select(objPDP.slot);
            selectSlot.selectByVisibleText(slot);
            log.info("Slot provided");
        } catch (Exception e) {
            log.error("Error in setting the slot", e);
        }
    }

    public void setAvailableTime() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPDP.AvailableSlot));
            wait.until(ExpectedConditions.elementToBeClickable(objPDP.AvailableSlot));
            objPDP.AvailableSlot.click();
            log.info("Available time provided");
        } catch (Exception e) {
            log.error("Error in setting the available time", e);
        }
    }

    public void setMessage(String message) {
        try {
            if (message != null && !message.isEmpty()) {
                objPDP.patientMsg.sendKeys(message);
            } else {
                log.info("Message field is empty or null");
            }
        } catch (Exception e) {
            log.error("Error in setting the message", e);
        }
    }

    public String getError() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPDP.FieldRequired));
            log.info("Field required error message retrieved");
            return objPDP.FieldRequired.getText();
        } catch (Exception e) {
            log.error("Error in getting error message", e);
            return null;
        }
    }

    public void AppointmentDetails() {
        try {
            Map<String, String> details = ExcelReader.getPatientAppointmentForm("src/test/resources/PatientAppointmentData.xlsx", "Sheet1");

            wait.until(ExpectedConditions.elementToBeClickable(objPDP.date));
            objPDP.date.sendKeys(details.get("Date"));
            objPDP.date.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE + details.get("Date"));
            log.info("Date field provided from Excel\nDate:" + details.get("Date"));

            String specialistName = details.get("Specialist");
            wait.until(ExpectedConditions.visibilityOf(objPDP.specialist));
            Select selectSpecialist = new Select(objPDP.specialist);
            List<WebElement> specialist = selectSpecialist.getOptions();
            for (WebElement Sname : specialist) {
                if (Sname.getText().contains(specialistName)) {
                    Sname.click();
                    log.info("Specialist selected from dropdown : " + Sname.getText());
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
                    log.info("Doctor selected from dropdown : " + Dname.getText());
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
                    log.info("Timing shift selected from dropdown : " + shift.getText());
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
                    log.info("Slot selected from dropdown : " + timeSlot.getText());
                    break;
                }
            }

            wait.until(ExpectedConditions.alertIsPresent());
            HelperClass.getDriver().switchTo().alert().accept();

            wait.until(ExpectedConditions.elementToBeClickable(objPDP.AvailableSlot));
            objPDP.AvailableSlot.click();
            log.info("Available slot clicked");
            objPDP.patientMsg.sendKeys(details.get("Message"));
            log.info("Message field provided from Excel : " + details.get("Message"));
        } catch (NoSuchElementException e) {
            log.error("Element not found", e);
        } catch (StaleElementReferenceException e) {
            log.error("Stale element reference", e);
        } catch (Exception e) {
            log.error("Error in AppointmentDetails", e);
        }
    }
}