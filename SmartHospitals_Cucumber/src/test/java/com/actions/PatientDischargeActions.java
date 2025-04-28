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
    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));
    
    public PatientDischargeActions() {
        objPDP = new PatientDischargePage();
        PageFactory.initElements(HelperClass.getDriver(), objPDP);
    }
    
    public void ClickIPD() {

           wait.until(ExpectedConditions.visibilityOf(objPDP.ipd));
           objPDP.ipd.click();
           log.info("IPD button clicked");

    }
    
    public void ClickFirstPatient() {	// clicking the first patient that we have searched by the id

    	   
           wait.until(ExpectedConditions.visibilityOf(objPDP.firstPatient));
           objPDP.firstPatient.click();
           log.info("First patient record clicked");

    }
    
    public void setCaseId(String id) throws InterruptedException {		// providing the case id of the patient to discharge 

           wait.until(ExpectedConditions.elementToBeClickable(objPDP.searchField));
           objPDP.searchField.sendKeys(id );
//           Thread.sleep(3000);
           log.info("Case ID passsed : ", id);

    }
    
    public String getPatientID() {		// returning the patient id for ensuring the patient has discharged

           wait.until(ExpectedConditions.visibilityOf(objPDP.dischargePatientName));
           String patientId = objPDP.dischargePatientName.getText();
           log.info("Retrieved patient ID: ", patientId);
           return patientId;

    }
    
    public void ClickDischargeBtn() {

           wait.until(ExpectedConditions.visibilityOf(objPDP.dischargeIcon));
           objPDP.dischargeIcon.click();
           log.info("Discharge button clicked");

    }
    
    public void setDischargeDate() {

           wait.until(ExpectedConditions.visibilityOf(objPDP.dischargeDate));
           objPDP.dischargeDate.click();
           log.info("Discharge date field clicked");

    }
    
    public void setDischargeStatus(String status) {		// providing the discharge status as normal or death or referal

           wait.until(ExpectedConditions.visibilityOf(objPDP.dischargeStatus));
           objPDP.dischargeStatus.sendKeys(status);
           log.info("Discharge status set to: {}", status);

    }
    
    public void ClickDischargeSaveBtn() {

           wait.until(ExpectedConditions.visibilityOf(objPDP.dischargeSaveBtn));
           objPDP.dischargeSaveBtn.click();
           log.info("Discharge save button clicked");

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