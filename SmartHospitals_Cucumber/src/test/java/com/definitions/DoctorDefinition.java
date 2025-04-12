package com.definitions;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import com.actions.DoctorActions;
import com.utils.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class DoctorDefinition {
	DoctorActions doctor=new DoctorActions();
	@Given("Doctor is logged in to the Smart Hospital system")
	public void doctor_is_logged_in_to_the_smart_hospital_system() throws InterruptedException {
	    doctor.login();
	    Thread.sleep(3000);
	    doctor.english();
	    Thread.sleep(3000);
	}
	@Given("the User navigate to the appointment section")
	public void the_user_navigate_to_the_appointment_section() {
	    doctor.appointment();
	}
	@When("Doctor clicks the Add Appointment button")
	public void doctor_clicks_the_add_appointment_button() {
	    doctor.addAppointment();
	}
	@When("Doctor clicks on New Patient button")
	public void doctor_clicks_on_new_patient_button(){
	    doctor.addPatient();
	}
	@When("Doctor fills in patient details")
	public void doctor_fills_in_patient_details() {
	    doctor.addPatientDetails();
	}
	@When("Doctor clicks the save button")
	public void doctor_clicks_the_save_button() throws InterruptedException {
	   doctor.save();
	   Thread.sleep(3000);
	}
	@Then("Patient should be added successfully")
	public void patient_should_be_added_successfully() {
	   //doctor.assertPatient();
	}
	@When("Doctor fills in appointment details")
	public void doctor_fills_in_appointment_details() {
	   doctor.addAppointmentDetails();
	}
	@When("Doctor clicks on save button")
	public void doctor_clicks_on_save_button() {
	   doctor.saveApp();
	}
	@Then("Appointment should be created successfully")
	public void appointment_should_be_created_successfully() {
		doctor.addedPatient();
	}
	@When("Doctor fills Expired time for appointment")
	public void doctor_fills_expired_time_for_appointment() {
	    doctor.addAppointmentDetails1();
	}
	@Then("Appointment creation should fail with {string} message")
	public void appointment_creation_should_fail_with_message(String string) throws InterruptedException{
		try {
		    Alert alert = HelperClass.getDriver().switchTo().alert();
		    String alertMsg = alert.getText();
		    Assert.assertEquals(string, alertMsg);
		    alert.accept();
		} catch (NoAlertPresentException e) {
		    System.out.println(e.getMessage());
		}
	}
	@When("Doctor leaves the Name field empty in patient details")
	public void doctor_leaves_the_name_field_empty_in_patient_details() {
	    doctor.addPatientDetails1();
	}
	@Then("Patient creation should fail with {string} message")
	public void patient_creation_should_fail_with_message(String string) {
	   doctor.nameRequired(string);
	}
	@When("Doctor leaves the Year field empty in patient details")
	public void doctor_leaves_the_year_field_empty_in_patient_details() {
	   doctor.addPatientDetails2();
	}
	@Then("Patient creation should fail and show {string} message")
	public void patient_creation_should_fail_and_show_message(String string) {
		doctor.nameRequired(string);
	}
	@When("Doctor leaves the Month field empty in patient details")
	public void doctor_leaves_the_month_field_empty_in_patient_details() {
	    doctor.addPatientDetails3();
	}
	@Then("Patient creation should fail and shows {string} message")
	public void patient_creation_should_fail_and_shows_message(String string) {
		doctor.nameRequired(string);
	}
	@When("Doctor leaves the Day field empty in patient details")
	public void doctor_leaves_the_day_field_empty_in_patient_details() {
	   doctor.addPatientDetails4();
	}
	@Then("Patient creation should fails and shows {string} message")
	public void patient_creation_should_fails_and_shows_message(String string) {
		doctor.nameRequired(string);
	}
}
