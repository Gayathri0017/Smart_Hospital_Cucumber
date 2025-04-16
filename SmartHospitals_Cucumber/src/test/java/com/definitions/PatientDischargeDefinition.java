package com.definitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.actions.PatientDischargeActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientDischargeDefinition {
	PatientDischargeActions objPDA = new PatientDischargeActions() ;
	
	@Given("the Doctor Navigates to the IPD section")
	public void the_doctor_navigates_to_the_ipd_section() {
		objPDA.ClickIPD();
	}

	@When("the Doctor clicks the ipdNo")
	public void the_doctor_clicks_the_ipd_no() {
//		System.out.println("This patient is discharged:" +objPDA.getPatientID());
		objPDA.ClickFirstPatient();
	}
	

@When("the Doctor clicks the discharge button")
public void the_doctor_clicks_the_discharge_button() {
	objPDA.ClickDischargeBtn();
}

@Then("the Doctor provides the discharge details")
public void the_doctor_provides_the_discharge_details(io.cucumber.datatable.DataTable dataTable) {
    List<Map<String , String>> form = dataTable.asMaps(String.class , String.class);
    for(Map<String , String > discharge : form) {
    	objPDA.setDischargeDate();
    	objPDA.setDischargeStatus(discharge.get("DischargeStatus"));
    }
    
    
}

@Then("the Doctor provides only discharge status {string}")
public void the_doctor_provides_only_discharge_status(String status) {
	objPDA.setDischargeStatus(status);
}

@Then("the Doctor provides only discharge date")
public void the_doctor_provides_only_discharge_date() {
	objPDA.setDischargeDate();
}

@Then("the Doctor able to see the error {string}")
public void the_doctor_able_to_see_the_error(String error) {
	System.out.println("----------------"+objPDA.getError());
	Assert.assertTrue(objPDA.getError().contains(error));
}


@When("the Doctor provides the case Id in search field")
public void the_doctor_provides_the_case_id_in_search_field(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
    List<Map<String , String>> caseiD = dataTable.asMaps(String.class , String.class);
    for(Map<String , String> Id : caseiD) {
    	objPDA.setCaseId(Id.get("caseID"));
    	objPDA.ClickFirstPatient();
        objPDA.ClickDischargeBtn();
    }
    
}



@Then("the Doctor should save the Discharge status")
public void the_doctor_should_save_the_discharge_status() {
	objPDA.ClickDischargeSaveBtn();
	System.out.println("-------------discharged the patient : "+objPDA.getPatientID());
}




}
