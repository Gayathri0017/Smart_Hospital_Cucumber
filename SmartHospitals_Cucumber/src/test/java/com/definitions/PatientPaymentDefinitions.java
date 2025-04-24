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
		try {
			objPPPA.ClickPayment();
			objPPPA.ClickMakePayment();
			System.out.println(objPPPA.getPaymentAmount());
			objPPPA.ClickAddPaymentBtn();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Then("the User provide the card details")
	public void the_user_provide_the_card_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		objPPPA.switchFrame();
		try {
			
		    List<Map<String , String>> cardDetails = dataTable.asMaps(String.class , String.class);
		    for(Map<String , String> details:cardDetails) {
		    	objPPPA.setCardNumber(details.get("CardNumber"));
		    	objPPPA.setCardExpiryNumber(details.get("ExpiryDate"));
		    	objPPPA.setCvv(details.get("CVV"));
		    	objPPPA.setCountry(details.get("Country"));
		    }
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	    
	}
	
	@Then("the User doesnt provide the any card details")
	public void the_user_doesnt_provide_the_any_card_details() {
		objPPPA.ClickpayNowBtn();
	}
	
	@Then("the User clicks pay now button")
	public void the_user_clicks_pay_now_button() throws InterruptedException {
		HelperClass.getDriver().switchTo().defaultContent();
		objPPPA.ClickpayNowBtn();
	}

	@Then("the User can able to see the error message {string}")
	public void the_user_can_able_to_see_the_error_message(String error) {
		try {
			if(error.contains("Your card number is invalid.")) {
				System.out.println(objPPPA.getInvalidTxt());
				Assert.assertTrue(objPPPA.getInvalidTxt().contains(error));
			}
			if(error.contains("Your card’s expiration year is in the past.")) {
				System.out.println(objPPPA.getInvalidTxt());
				Assert.assertTrue(objPPPA.getInvalidTxt().contains(error));
			}
			if(error.contains("Your card’s security code is incomplete.")) {
				System.out.println(objPPPA.getInvalidTxt());
				Assert.assertTrue(objPPPA.getInvalidTxt().contains(error));
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	

@Then("the User can able to see the success message {string}")
public void the_user_can_able_to_see_the_success_message(String msg) {
	Assert.assertTrue(objPPPA.getPayementSuccessText().contains(msg));
	System.out.println(objPPPA.getPayementSuccessText());
}

}
