package com.actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.PatientDashboardPage;
import com.pages.PatientPaymentPage;
import com.utils.HelperClass;

public class PatientPaymentPageActions {
    private static final Logger log = LogManager.getLogger(PatientPaymentPageActions.class);
    PatientPaymentPage objPPP = null;
    PatientDashboardPage objPDP = null;
    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));

    public PatientPaymentPageActions() {
        objPPP = new PatientPaymentPage();
        objPDP = new PatientDashboardPage();
        PageFactory.initElements(HelperClass.getDriver(), objPPP);
        PageFactory.initElements(HelperClass.getDriver(), objPDP);
    }

    public void ClickIpd() {
            wait.until(ExpectedConditions.visibilityOf(objPDP.ipd));
            objPDP.ipd.click();
            log.info("IPD button clicked");

    }

    public void ClickPayment() {

            wait.until(ExpectedConditions.visibilityOf(objPPP.payment));
            objPPP.payment.click();
            log.info("Payment button clicked");

    }

    public void ClickMakePayment() {

            wait.until(ExpectedConditions.visibilityOf(objPPP.makePayment));
            objPPP.makePayment.click();
            log.info("Make payment button clicked");

    }

    public String getPaymentText() {		// get the amount text for asserting
        
            wait.until(ExpectedConditions.visibilityOf(objPPP.paymentText));
            String paymentText = objPPP.paymentText.getText();
            log.info("Payment text retrieved: ", paymentText);
            return paymentText;
        
    }

    public String getPaymentAmount() {		// get the amount that the patient have to pay
        
            wait.until(ExpectedConditions.visibilityOf(objPPP.amount));
            String amount = null;
            if (!objPPP.amount.getAttribute("value").equals("0")) {
                amount = objPPP.amount.getAttribute("value");
            }
            log.info("Payment amount retrieved: ", amount);
            return amount;
        
    }

    public void ClickAddPaymentBtn() {

            wait.until(ExpectedConditions.visibilityOf(objPPP.addPaymentBtn));
            objPPP.addPaymentBtn.click();
            log.info("Add payment button clicked");

    }

    public void ClickpayNowBtn() {

            WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
            WebElement payNowButton = wait.until(ExpectedConditions.elementToBeClickable(objPPP.payNowBtn));

            JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
             js.executeScript("arguments[0].click();", payNowButton);
             log.info("Pay now button clicked");

    }

    public void switchFrame() {		// switching the frame for entering the car details for the payment

            wait.until(ExpectedConditions.visibilityOf(objPPP.frame));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(objPPP.frame));
            log.info("Switched to frame");

    }

    public String getInvalidCardNumber() {		// get the invalid card number text
       
            wait.until(ExpectedConditions.visibilityOf(objPPP.invalidCardNumber));
            String invalidCardNumber = objPPP.invalidCardNumber.getText();
            log.info("Invalid card number text retrieved: ", invalidCardNumber);
            return invalidCardNumber;
        
    }

    public void setCountry(String country) {

            wait.until(ExpectedConditions.elementToBeClickable(objPPP.country));
            Select selectCountry = new Select(objPPP.country);
            selectCountry.selectByVisibleText(country);
            log.info("Country :", country);

    }

    public void setCardNumber(String cardnumber) {		

        	if(cardnumber.contains("4242424242424242")){
        		wait.until(ExpectedConditions.elementToBeClickable(objPPP.cardNumber));
        		Actions act = new Actions(HelperClass.getDriver());
                act.moveToElement(objPPP.cardNumber).click().perform();
                JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
                 js.executeScript("arguments[0].value = arguments[1];", objPPP.cardNumber, cardnumber);
                 log.info("Card number passed : ", cardnumber);
        	}
        	else {
        		log.error("Card number is invalid : "+cardnumber);
        	}

    }

    public void setCardExpiryNumber(String expiryNumber) {

            wait.until(ExpectedConditions.elementToBeClickable(objPPP.cardExpiryNumber));
            objPPP.cardExpiryNumber.sendKeys(expiryNumber);
            log.info("Card expiry number passed : ", expiryNumber);

    }

    public void setCvv(String cvv) {

            wait.until(ExpectedConditions.elementToBeClickable(objPPP.cvvNumber));
            objPPP.cvvNumber.clear();
            objPPP.cvvNumber.sendKeys(cvv);
            log.info("CVV passed : ", cvv);

    }

    public String getInvalidTxt() {		// getting the invalid number text
       
            wait.until(ExpectedConditions.visibilityOf(objPPP.invalidTxt));
            String invalidNumberTxt = objPPP.invalidTxt.getText();
            log.info("Invalid number text retrieved : ", invalidNumberTxt);
            return invalidNumberTxt;
        
    }

    public String getInvalidCardDate() {		// getting the invalid card date text
        
            wait.until(ExpectedConditions.visibilityOf(objPPP.invalidCardDate));
            String invalidCardDate = objPPP.invalidCardDate.getText();
            log.info("Invalid card date text retrieved : ", invalidCardDate);
            return invalidCardDate;
        
    }

    public String getInvalidCvv() {		// getting the invalid cvv text
        
            wait.until(ExpectedConditions.visibilityOf(objPPP.invalidCvv));
            String invalidCvv = objPPP.invalidCvv.getText();
            log.info("Invalid CVV text retrieved : ", invalidCvv);
            return invalidCvv;
        
    }

    public String getPayementSuccessText() {		//getting the payment success text message
       
            wait.until(ExpectedConditions.visibilityOf(objPPP.paymentSuccess));
            String paymentSuccessText = objPPP.paymentSuccess.getText();
            log.info("Payment success text retrieved : ", paymentSuccessText);
            return paymentSuccessText;
        
    }
}
