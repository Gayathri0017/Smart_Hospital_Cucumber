package com.definitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.PatientPaymentPageActions;
import com.utils.HelperClass;

import io.cucumber.java.en.Then;

public class PatientPaymentDefinitions {
	private static final Logger log = LogManager.getLogger(PatientPaymentDefinitions.class);
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
			System.out.println(objPPPA.getPaymentAmount());
			objPPPA.ClickAddPaymentBtn();

		
	}
	
	@Then("the User provide the card details")
	public void the_user_provide_the_card_details(io.cucumber.datatable.DataTable dataTable){
		objPPPA.switchFrame();

			
		    List<Map<String , String>> cardDetails = dataTable.asMaps(String.class , String.class);
		    for(Map<String , String> details:cardDetails) {
		    	objPPPA.setCardNumber(details.get("CardNumber"));
		    	objPPPA.setCardExpiryNumber(details.get("ExpiryDate"));
		    	objPPPA.setCvv(details.get("CVV"));
		    	objPPPA.setCountry(details.get("Country"));
		    }

	    
	}
	
	@Then("the User doesnt provide the any card details")
	public void the_user_doesnt_provide_the_any_card_details() {
		objPPPA.ClickpayNowBtn();
	}
	
	@Then("the User clicks pay now button")
	public void the_user_clicks_pay_now_button() {
		HelperClass.getDriver().switchTo().defaultContent();
		objPPPA.ClickpayNowBtn();
	}

	@Then("the User can able to see the error message {string}")
	public void the_user_can_able_to_see_the_error_message(String error) {
			if(error.contains("Your card number is invalid.")) {
				try {
					System.out.println(objPPPA.getInvalidTxt());
					Assert.assertTrue(objPPPA.getInvalidTxt().contains(error));
					log.info("Assert gets passed in invalid card number ");
				}catch (Exception e) {
					log.error("Assert gets failed in invalid card number ");
					throw e;
				}
			}
			if(error.contains("Your card’s expiration year is in the past.")) {
				try {
					System.out.println(objPPPA.getInvalidTxt());
					Assert.assertTrue(objPPPA.getInvalidTxt().contains(error));
					log.info("Assert gets passed in invalid card expiry date ");
				}catch (Exception e) {
					log.error("Assert gets failed in invalid card expiry date ");
					throw e;
				}
			}
			if(error.contains("Your card’s security code is incomplete.")) {
				try {
					System.out.println(objPPPA.getInvalidTxt());
					Assert.assertTrue(objPPPA.getInvalidTxt().contains(error) || objPPPA.getInvalidTxt().contains("Your card number is incomplete."));
					log.info("Assert gets passed in invalid cvv number ");
				}catch (Exception e) {
					log.error("Assert gets failed in invalid cvv number ");
					throw e;
				}
			}
			if(error.contains("Your card number is incomplete.")) {
				try {
					System.out.println(objPPPA.getInvalidTxt());
					Assert.assertTrue(objPPPA.getInvalidTxt().contains(error));
					log.info("Assert gets passed in invalid card number ");
				}catch (Exception e) {
					log.error("Assert gets failed in invalid card number ");
					throw e;
				}
			}
	}
	

@Then("the User can able to see the success message {string}")
public void the_user_can_able_to_see_the_success_message(String msg) {
	try {
		Assert.assertTrue(objPPPA.getPayementSuccessText().contains(msg));
		System.out.println(objPPPA.getPayementSuccessText());
		log.info("Assert gets passed in succes for valid number ");
	}catch (Exception e) {
		log.error("Assert gets failed in succes for valid number ");
		throw e;
	}
	
}

}
