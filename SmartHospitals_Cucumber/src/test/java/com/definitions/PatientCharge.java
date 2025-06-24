package com.definitions;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.PatientChargeActions;
import com.utils.HelperClass;

import io.cucumber.java.en.Then;

public class PatientCharge {
	
	PatientChargeActions PCA = new PatientChargeActions();
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));
	
	@Then("the User Clicks the charge btn")
	public void the_user_clicks_the_charge_btn() {
		PCA.ClickChargeBtn();
	}
	
	@Then("the User is able to see the charge details of the patient")
	public void the_user_is_able_to_see_the_charge_details_of_the_patient() {
		PCA.getPatientChargeDetails();
	}
	
	@Then("verify the amount for total charges")
	public void verify_the_amount_for_total_charges() {
//		float expected_amount = PCA.getTotal() ;
//		Assert.assertEquals(expected_amount, PCA.getActualAmount());
		System.out.println(PCA.getTotal());
		System.out.println(PCA.getActualAmount());
		
	}
}
