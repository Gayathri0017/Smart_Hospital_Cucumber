package com.actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.PatientDischargePage;
import com.utils.HelperClass;

public class PatientDischargeActions {
    private static final Logger log = LogManager.getLogger(PatientDischargeActions.class);
    PatientDischargePage objPDP = null;
    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
    
    public PatientDischargeActions() {
        objPDP = new PatientDischargePage();
        PageFactory.initElements(HelperClass.getDriver(), objPDP);
    }
    
    public void ClickIPD() {
        try {
           wait.until(ExpectedConditions.visibilityOf(objPDP.ipd));
           objPDP.ipd.click();
           log.info("IPD button clicked");
        } catch (Exception e) {
           log.error("Failed to click IPD button", e);
        }
    }
    
    public void ClickFirstPatient() {	// clicking the first patient that we have searched by the id
        try {
           wait.until(ExpectedConditions.elementToBeClickable(objPDP.firstPatient));
           objPDP.firstPatient.click();
           log.info("First patient record clicked");
        } catch (Exception e) {
           log.error("Failed to click first patient record", e);
        }
    }
    
    public void setCaseId(String id) {		// providing the case id of the patient to discharge 
        try {
           wait.until(ExpectedConditions.elementToBeClickable(objPDP.searchField));
           objPDP.searchField.sendKeys(id + Keys.CONTROL + "a" + Keys.BACK_SPACE + Keys.ENTER);
           log.info("Case ID passsed : ", id);
        } catch (Exception e) {
           log.error("Failed to set case ID : ", e);
        }
    }
    
    public String getPatientID() {		// returning the patient id for ensuring the patient has discharged
        try {
           wait.until(ExpectedConditions.visibilityOf(objPDP.dischargePatientName));
           String patientId = objPDP.dischargePatientName.getText();
           log.info("Retrieved patient ID: ", patientId);
           return patientId;
        } catch (Exception e) {
           log.error("Failed to get patient ID : ", e);
           return null;
        }
    }
    
    public void ClickDischargeBtn() {
        try {
           wait.until(ExpectedConditions.visibilityOf(objPDP.dischargeIcon));
           objPDP.dischargeIcon.click();
           log.info("Discharge button clicked");
        } catch (Exception e) {
           log.error("Failed to click discharge button : ", e);
        }
    }
    
    public void setDischargeDate() {
        try {
           wait.until(ExpectedConditions.visibilityOf(objPDP.dischargeDate));
           objPDP.dischargeDate.click();
           log.info("Discharge date field clicked");
        } catch (Exception e) {
           log.error("Failed to click discharge date field : ", e);
        }
    }
    
    public void setDischargeStatus(String status) {		// providing the discharge status as normal or death or referal
        try {
           wait.until(ExpectedConditions.visibilityOf(objPDP.dischargeStatus));
           objPDP.dischargeStatus.sendKeys(status);
           log.info("Discharge status set to: {}", status);
        } catch (Exception e) {
           log.error("Failed to set discharge status : ", e);
        }
    }
    
    public void ClickDischargeSaveBtn() {
        try {
           wait.until(ExpectedConditions.visibilityOf(objPDP.dischargeSaveBtn));
           objPDP.dischargeSaveBtn.click();
           log.info("Discharge save button clicked");
        } catch (Exception e) {
           log.error("Failed to click discharge save button : ", e);
        }
    }
    
    public String getError() {		// getting the error message as required field       
           return objPDP.error.getText();
        
    }
    public String getNoDataAvail() {
    	return objPDP.NodataAvailable.getText();
    }
    public boolean getNoDataAvailIsDisplayed() {
    	return objPDP.NodataAvailable.isDisplayed();
    }
}