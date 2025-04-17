package com.actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));

    public PatientPaymentPageActions() {
        objPPP = new PatientPaymentPage();
        objPDP = new PatientDashboardPage();
        PageFactory.initElements(HelperClass.getDriver(), objPPP);
        PageFactory.initElements(HelperClass.getDriver(), objPDP);
    }

    public void ClickIpd() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPDP.ipd));
            objPDP.ipd.click();
            log.info("IPD button clicked");
        } catch (Exception e) {
            log.error("Failed to click IPD button : ", e);
        }
    }

    public void ClickPayment() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPPP.payment));
            objPPP.payment.click();
            log.info("Payment button clicked");
        } catch (Exception e) {
            log.error("Failed to click payment button : ", e);
        }
    }

    public void ClickMakePayment() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPPP.makePayment));
            objPPP.makePayment.click();
            log.info("Make payment button clicked");
        } catch (Exception e) {
            log.error("Failed to click make payment button : ", e);
        }
    }

    public String getPaymentText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPPP.paymentText));
            String paymentText = objPPP.paymentText.getText();
            log.info("Payment text retrieved: ", paymentText);
            return paymentText;
        } catch (Exception e) {
            log.error("Failed to get payment text : ", e);
            return null;
        }
    }

    public String getPaymentAmount() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPPP.amount));
            String amount = null;
            if (!objPPP.amount.getAttribute("value").equals("0")) {
                amount = objPPP.amount.getAttribute("value");
            }
            log.info("Payment amount retrieved: ", amount);
            return amount;
        } catch (Exception e) {
            log.error("Failed to get payment amount : ", e);
            return null;
        }
    }

    public void ClickAddPaymentBtn() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPPP.addPaymentBtn));
            objPPP.addPaymentBtn.click();
            log.info("Add payment button clicked");
        } catch (Exception e) {
            log.error("Failed to click add payment button : ", e);
        }
    }

    public void ClickpayNowBtn() {
        try {
            WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
            WebElement payNowButton = wait.until(ExpectedConditions.elementToBeClickable(objPPP.payNowBtn));

            JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
             js.executeScript("arguments[0].click();", payNowButton);
             log.info("Pay now button clicked");
        } catch (Exception e) {
            log.error("Failed to click pay now button : ", e);
        }
    }

    public void switchFrame() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPPP.frame));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(objPPP.frame));
            log.info("Switched to frame");
        } catch (Exception e) {
            log.error("Failed to switch frame : ", e);
        }
    }

    public String getInvalidCardNumber() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPPP.invalidCardNumber));
            String invalidCardNumber = objPPP.invalidCardNumber.getText();
            log.info("Invalid card number text retrieved: {}", invalidCardNumber);
            return invalidCardNumber;
        } catch (Exception e) {
            log.error("Failed to get invalid card number text : ", e);
            return null;
        }
    }

    public void setCountry(String country) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(objPPP.country));
            Select selectCountry = new Select(objPPP.country);
            selectCountry.selectByVisibleText(country);
            log.info("Country set to: {}", country);
        } catch (Exception e) {
            log.error("Failed to set country : ", e);
        }
    }

    public void setCardNumber(String cardnumber) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(objPPP.cardNumber));

            Actions act = new Actions(HelperClass.getDriver());
            act.moveToElement(objPPP.cardNumber).click().perform();
            JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
             js.executeScript("arguments[0].value = arguments[1];", objPPP.cardNumber, cardnumber);
             log.info("Card number passed : ", cardnumber);
        } catch (Exception e) {
            log.error("Failed to set card number : ", e);
        }
    }

    public void setCardExpiryNumber(String expiryNumber) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(objPPP.cardExpiryNumber));
            objPPP.cardExpiryNumber.sendKeys(expiryNumber);
            log.info("Card expiry number passed : ", expiryNumber);
        } catch (Exception e) {
            log.error("Failed to set card expiry number", e);
        }
    }

    public void setCvv(String cvv) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(objPPP.cvvNumber));
            objPPP.cvvNumber.clear();
            objPPP.cvvNumber.sendKeys(cvv);
            log.info("CVV passed : ", cvv);
        } catch (Exception e) {
            log.error("Failed to set CVV : ", e);
        }
    }

    public String getInvalidNumberTxt() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPPP.invalidNumberTxt));
            String invalidNumberTxt = objPPP.invalidNumberTxt.getText();
            log.info("Invalid number text retrieved : ", invalidNumberTxt);
            return invalidNumberTxt;
        } catch (Exception e) {
            log.error("Failed to get invalid number text : ", e);
            return null;
        }
    }

    public String getInvalidCardDate() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPPP.invalidCardDate));
            String invalidCardDate = objPPP.invalidCardDate.getText();
            log.info("Invalid card date text retrieved : ", invalidCardDate);
            return invalidCardDate;
        } catch (Exception e) {
            log.error("Failed to get invalid card date text : ", e);
            return null;
        }
    }

    public String getInvalidCvv() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPPP.invalidCvv));
            String invalidCvv = objPPP.invalidCvv.getText();
            log.info("Invalid CVV text retrieved : ", invalidCvv);
            return invalidCvv;
        } catch (Exception e) {
            log.error("Failed to get invalid CVV text : ", e);
            return null;
        }
    }

    public String getPayementSuccessText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(objPPP.paymentSuccess));
            String paymentSuccessText = objPPP.paymentSuccess.getText();
            log.info("Payment success text retrieved : ", paymentSuccessText);
            return paymentSuccessText;
        } catch (Exception e) {
            log.error("Failed to get payment success text : ", e);
            return null;
        }
    }
}