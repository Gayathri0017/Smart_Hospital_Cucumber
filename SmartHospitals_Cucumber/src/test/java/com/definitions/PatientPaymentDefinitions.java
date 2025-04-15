package com.definitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.PatientPaymentPageActions;
import com.utils.HelperClass;

import io.cucumber.java.en.Then;

public class PatientPaymentDefinitions {
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));
	PatientPaymentPageActions objPPPA = new PatientPaymentPageActions();  
	@Then("the User clicks Ipd button")
	public void the_user_clicks_ipd_button() {
		objPPPA.ClickIpd();
	}

	@Then("the User clicks payment option")
	public void the_user_clicks_payment_option() {
		objPPPA.ClickPayment();
		objPPPA.ClickMakePayment();
		Assert.assertTrue(objPPPA.getPaymentText().contains("Payment Amount ($)"));
		System.out.println(objPPPA.getPaymentAmount());
		objPPPA.ClickAddPaymentBtn();
//		objPPPA.ClickpayNowBtn();
//		HelperClass.getDriver().switchTo().frame("__privateStripeFrame5024");
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("__privateStripeFrame5024"));
	}
	
	@Then("the User provide the invalid card details")
	public void the_user_provide_the_invalid_card_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		Thread.sleep(5000);
	    List<Map<String , String>> cardDetails = dataTable.asMaps(String.class , String.class);
	    for(Map<String , String> details:cardDetails) {
	    	objPPPA.setCountry(details.get("Country"));
	    	objPPPA.setCardNumber(details.get("CardNumber"));
	    	objPPPA.setCardExpiryNumber(details.get("ExpiryDate"));
	    	objPPPA.setCvv(details.get("CVV"));
	    }
	    objPPPA.ClickpayNowBtn();
	}
	
	@Then("the User doesnt provide the any card details")
	public void the_user_doesnt_provide_the_any_card_details() {
		objPPPA.ClickpayNowBtn();
	}

	@Then("the User can able to see the error message {string}")
	public void the_user_can_able_to_see_the_error_message(String error) {
		Assert.assertTrue(objPPPA.getInvalidNumberTxt().contains(error));
		System.out.println(objPPPA.getInvalidNumberTxt());
	}



}
