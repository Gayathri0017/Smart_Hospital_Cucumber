package com.definitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actions.PatientDetailsActions;
import com.utils.HelperClass;

import io.cucumber.java.en.Then;

public class PatientDetailsDefinitions {
	
	private static final Logger log = LogManager.getLogger(PatientDetailsDefinitions.class);
	PatientDetailsActions objPDA = new PatientDetailsActions();  
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));
	@Then("the User can see the details of patient")
	public void the_user_can_see_the_details_of_patient() {
		System.out.println("Patient ID : "+objPDA.getPatientId());
		System.out.println("Marital Status : "+objPDA.getMaritalStatus());
		System.out.println("Email : "+objPDA.getEmail());
		System.out.println("Age : "+objPDA.getAge());
		System.out.println("Gender : "+objPDA.getGender());
		System.out.println("Phone : "+objPDA.getPhone());
		System.out.println("Address : "+objPDA.getAddress());
		System.out.println("Guardian Name : "+objPDA.getGuardianName());
	}

	
	
	
}