package com.actions;

import java.time.Duration;

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
	
	PatientPaymentPage objPPP = null ;
	PatientDashboardPage objPDP = null ;
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));
	
	public PatientPaymentPageActions() {
		objPPP = new PatientPaymentPage();
		objPDP = new PatientDashboardPage();
		PageFactory.initElements(HelperClass.getDriver(), objPPP);
		PageFactory.initElements(HelperClass.getDriver(), objPDP);
	}
	
	public void ClickIpd() {
		wait.until(ExpectedConditions.visibilityOf(objPDP.ipd));
		objPDP.ipd.click();	
	}
	
	public void ClickPayment() {
		wait.until(ExpectedConditions.visibilityOf(objPPP.payment));
		objPPP.payment.click();
	}
	
	public void ClickMakePayment() {
		wait.until(ExpectedConditions.visibilityOf(objPPP.makePayment));
		objPPP.makePayment.click();
	}
	
	public String getPaymentText() {
		wait.until(ExpectedConditions.visibilityOf(objPPP.paymentText));
		return objPPP.paymentText.getText();
	}
	
	public String getPaymentAmount() {
		wait.until(ExpectedConditions.visibilityOf(objPPP.amount));
		return objPPP.amount.getAttribute("value");
	}
	
	public void ClickAddPaymentBtn() {
		wait.until(ExpectedConditions.visibilityOf(objPPP.addPaymentBtn));
		objPPP.addPaymentBtn.click();
	}
	
	public void ClickpayNowBtn() {
		wait.until(ExpectedConditions.visibilityOf(objPPP.payNowBtn));
		objPPP.payNowBtn.click();
	}
	
	public void setCountry(String country) {
		wait.until(ExpectedConditions.elementToBeClickable(objPPP.country));
		Select selectCountry = new Select(objPPP.country);
		selectCountry.selectByIndex(2);
		
//		 WebElement countryElement = objPPP.country;
//	        wait.until(ExpectedConditions.elementToBeClickable(countryElement));
//	        ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].value = arguments[1];", countryElement, country);
//	}
	
//	public void setCardNumber(String cardnumber) {
//		wait.until(ExpectedConditions.visibilityOf(objPPP.cardNumber));
//		objPPP.cardNumber.click();
//		objPPP.cardNumber.toString();
////		objPPP.cardNumber.clear();
//		objPPP.cardNumber.sendKeys(cardnumber);
	}
	public void setCardNumber(String cardnumber) {
//	    wait.until(ExpectedConditions.elementToBeClickable(objPPP.cardNumber));
	    
	    Actions act = new Actions(HelperClass.getDriver());
	    act.moveToElement(objPPP.cardNumber).click().perform();
	    JavascriptExecutor js = (JavascriptExecutor)HelperClass.getDriver();
	    js.executeScript("arguments[0].value = arguments[1];", objPPP.cardNumber, cardnumber);
	}
	
	public void setCardExpiryNumber(String expiryNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(objPPP.cardExpiryNumber));
		objPPP.cardExpiryNumber.sendKeys(expiryNumber);
	}
	
	public void setCvv(String cvv) {
		wait.until(ExpectedConditions.elementToBeClickable(objPPP.cvvNumber));
		objPPP.cvvNumber.sendKeys(cvv);
	}
	
	public String getInvalidNumberTxt() {
		wait.until(ExpectedConditions.visibilityOf(objPPP.invalidNumberTxt));
		return objPPP.invalidNumberTxt.getText();
	}
	
	public String getInvalidCardDate() {
		wait.until(ExpectedConditions.visibilityOf(objPPP.invalidCardDate));
		return objPPP.invalidCardDate.getText();
	}
	
	public String getInvalidCvv() {
		wait.until(ExpectedConditions.visibilityOf(objPPP.invalidCvv));
		return objPPP.invalidCvv.getText();
	}
}
