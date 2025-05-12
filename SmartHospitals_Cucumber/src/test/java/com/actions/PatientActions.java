package com.actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));

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
            log.info("profile clicked");

    }

    public String getProfileRole() {// retriving the profile role

            wait.until(ExpectedConditions.visibilityOf(objPDP.verifyProfile));
            log.info("Verifying the profile");
            return objPDP.verifyProfile.getText();

    }

    public void SwitchTab() {	//switching new tab for the userlogin that is created during the instance 

            Set<String> allwindows = HelperClass.getDriver().getWindowHandles();
            Iterator<String> it = allwindows.iterator();
            String mainWindow = it.next();
            System.out.println(mainWindow);
            String childWindow = it.next();
            HelperClass.getDriver().switchTo().window(childWindow);
            log.info("Driver window switched");

    }

    public void BlankUsername() {

            wait.until(ExpectedConditions.visibilityOf(objPatientPage.email));
            objPatientPage.email.clear();
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

    public void setDate(String date) {		//inserting the date for the appointment

            wait.until(ExpectedConditions.visibilityOf(objPDP.date));
            wait.until(ExpectedConditions.elementToBeClickable(objPDP.date));
            if (date != null && !date.isEmpty()) {
                objPDP.date.click();
                objPDP.date.sendKeys(date);
            } else {
                objPDP.date.clear();
            }
            log.info("Date field provided");

    }


    public void setSpecialist(String specialist) {

            WebElement specialistDropdown = wait.until(ExpectedConditions.visibilityOf(objPDP.specialist));

            JavascriptExecutor js = (JavascriptExecutor)HelperClass.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", specialistDropdown);

            if (specialist != null && !specialist.isEmpty()) {// Select the specialist from the dropdown
                Select selectSpecialist = new Select(specialistDropdown);
                selectSpecialist.selectByVisibleText(specialist);
                log.info(String.format("Specialist field provided: %s", specialist));
            } else {
                log.info("Specialist field is empty or null");
            }

    }


    public void setDoctor(String doctor) {		//choosing the concern doctor for the appointment

            wait.until(ExpectedConditions.elementToBeClickable(objPDP.doctor));
            Select selectDoctor = new Select(objPDP.doctor);
            selectDoctor.selectByVisibleText(doctor);
            log.info("Doctor field provided");

    }

    public void setShift(String shift) {		// selecting the shift for the appointment

            wait.until(ExpectedConditions.elementToBeClickable(objPDP.timingShift));
            Select selectTiming = new Select(objPDP.timingShift);
            selectTiming.selectByVisibleText(shift);
            log.info("Timing shift field provided");

    }

    public void setTime(String slot) {		//selecting the slot timing 

            wait.until(ExpectedConditions.visibilityOf(objPDP.slot));
            objPDP.slot.click();
            Select selectSlot = new Select(objPDP.slot);
            selectSlot.selectByVisibleText(slot);
            log.info("Slot provided");
            objPDP.slot.click();

    }

    public void setAvailableTime() {		//choosing the available time for the doctor's shift

            wait.until(ExpectedConditions.visibilityOf(objPDP.availableSlot));
            wait.until(ExpectedConditions.elementToBeClickable(objPDP.availableSlot));
            Actions act = new Actions(HelperClass.getDriver());
            act.scrollToElement(objPDP.availableSlot).click();
            act.click(objPDP.availableSlot);
            log.info("Available time provided");
            

    }
    
    public void alert() {
    	if(wait.until(ExpectedConditions.alertIsPresent()) != null) {
        	
        	HelperClass.getDriver().switchTo().alert().accept();
        }
    }
    public void setMessage(String message) {		// providing the message as details of the patient condition

    	wait.until(ExpectedConditions.elementToBeClickable(objPDP.patientMsg));
    	Actions act = new Actions(HelperClass.getDriver());
    	act.scrollToElement(objPDP.patientMsg).click();
    	objPDP.patientMsg.click();
            if (message != null && !message.isEmpty()) {
                objPDP.patientMsg.sendKeys(message);
            } else {
                log.info("Message field is empty or null");
            }

    }

    public String getError() {		 // getting error message

            wait.until(ExpectedConditions.visibilityOf(objPDP.fieldRequired));
            log.info("Field required error message retrieved");
            return objPDP.fieldRequired.getText();

    }
    
    public String getSuccessMsg() {
    	return objPDP.successMsg.getText();
    }
    
    public String getAppointmentnotAvail() {
    	return objPDP.appointNotAvail.getText();
    }
    public void AppointmentDetails() {		// providing the appointment details from the excelreader class

            Map<String, String> details = ExcelReader.getPatientAppointmentForm("src/test/resources/PatientAppointmentData.xlsx", "Sheet1");
            
            wait.until(ExpectedConditions.visibilityOf(objPDP.date));
            wait.until(ExpectedConditions.elementToBeClickable(objPDP.date));
            if (details.get("Date") != null && !details.get("Date").isEmpty()) {
                objPDP.date.click();
                objPDP.date.sendKeys(details.get("Date"));
                log.info(String.format("Date field provided from Excel \n Date:%s", details.get("Date") ));
            } else {
                objPDP.date.clear();
            }
            log.info("Date field provided");
            String specialistName = details.get("Specialist");
            wait.until(ExpectedConditions.visibilityOf(objPDP.specialist));
            Select selectSpecialist = new Select(objPDP.specialist);
            List<WebElement> specialist = selectSpecialist.getOptions();
            for (WebElement Sname : specialist) {
                if (Sname.getText().contains(specialistName)) {
                    Sname.click();
                    log.info(String.format("Specialist selected from dropdown : %s " , Sname.getText()));
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
                    log.info("Doctor selected from dropdown : %s" , Dname.getText());
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
                    log.info("Timing shift selected from dropdown :%s " , shift.getText());
                    break;
                }
            }

            String slot = details.get("Slot");
            wait.until(ExpectedConditions.visibilityOf(objPDP.slot));
            objPDP.slot.click();
            Select selectSlot = new Select(objPDP.slot);
            List<WebElement> slotTiming = selectSlot.getOptions();
            for (WebElement timeSlot : slotTiming) {
                if (timeSlot.getText().contains(slot)) {
                    timeSlot.click();
                    objPDP.slot.click();
                    log.info("Slot selected from dropdown :%s" , timeSlot.getText());
                    break;
                }
            }
            
            if(details.get("Date") == null) {
            	alert();
            }
            
            try {
        		
            	wait.until(ExpectedConditions.visibilityOf(objPDP.availableSlot));
            	wait.until(ExpectedConditions.elementToBeClickable(objPDP.availableSlot));
        	}
        	catch (Exception e){
        		System.out.println(e.getMessage());
        	}
            objPDP.availableSlot.click();
            log.info("Available slot clicked");
            objPDP.patientMsg.sendKeys(details.get("Message"));
            log.info("Message field provided from Excel : %s" , details.get("Message"));

    }
    
    public void clickDownloadCenter() {
    	objPDP.downloadCenter.click();
    	
    }

    public void ContentList(String content) {
        List<WebElement> contentList = HelperClass.getDriver().findElements(By.xpath("//div[@id='DataTables_Table_0_wrapper']/table/tbody/tr/td[1]"));
        int i = 1;
        for (WebElement c : contentList) {
            if (c.getText().contains(content)) {
                List<WebElement> data = HelperClass.getDriver().findElements(By.xpath("//div[@id='DataTables_Table_0_wrapper']/table/tbody/tr[" + i + "]/td"));
                int j = 0;
                for (WebElement d : data) {
                    switch (j) {
                        case 0:
                            System.out.println("Title : " + d.getText());
                            break;
                        case 1:
                            System.out.println("Share Date : " + d.getText());
                            break;
                        case 2:
                            System.out.println("Valid upto : " + d.getText());
                            break;
                        case 3:
                            System.out.println("Shared By : " + d.getText());
                            break;
                        default:
                        	System.out.println("Try again");
                    }
                    j++;
                }
            }
            i++; 
        }
    }
}
