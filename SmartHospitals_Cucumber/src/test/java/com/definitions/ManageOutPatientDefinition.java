package com.definitions;

import com.actions.ManageOutPatientActions;
import com.utils.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageOutPatientDefinition {
	ManageOutPatientActions ma=new ManageOutPatientActions();
	@When("the doctor clicks on the OPD - Out Patient section")
	public void the_doctor_clicks_on_the_opd_out_patient_section() {
	   ma.clickOpd();
	}
	@When("the doctor searches for the patient by name <{string}>")
	public void the_doctor_searches_for_the_patient_by_name(String string) throws InterruptedException {
	   ma.search(string);
	}
	@When("the doctor clicks on Move to IPD")
	public void the_doctor_clicks_on_move_to_ipd() {
	   ma.clickIpd();
	}
	@When("the doctor enter the <{string}> and <{string}>")
	public void the_doctor_enter_the_and(String string, String string2) throws InterruptedException {
	    ma.sendBedDetails(string, string2);
	}
	@Then("the doctor can the see the <{string}>")
	public void the_doctor_can_the_see_the(String string) throws InterruptedException {
	   ma.assertMove(string);
	}


}
