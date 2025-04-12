package com.definitions;

import java.util.List;
import java.util.Map;

import com.actions.PrescriptionActions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PrescriptionDefinition {
	PrescriptionActions pa=new PrescriptionActions();
	@When("the Doctor Navigates to the OPD section")
	public void the_doctor_navigates_to_the_opd_section() throws InterruptedException {
	   pa.OPDSection();
	   Thread.sleep(1000);
	}
	@When("Clicks the Add Prescription")
	public void clicks_the_add_prescription() throws InterruptedException {
	    pa.addPres();
	    Thread.sleep(1000);
	}
	@Then("the doctor should navigate to the Prescription Page")
	public void the_doctor_should_navigate_to_the_prescription_page() throws InterruptedException {
	    pa.assertPP();
	}
	@When("the doctor Fill the valid Details:")
	public void the_doctor_fill_the_valid_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
	    Map<String, String> row = rows.get(0);
	    pa.selectFindingCategory(row.get("Finding Category"));
	    pa.selectMedicineCategory(row.get("Medicine Category"));
	    pa.selectMedicine(row.get("Medicine"));
	    pa.selectDoseInterval(row.get("Dose Interval"));
	    pa.selectDoseDuration(row.get("Dose Duration"));
	}
	@When("Clicks Save button")
	public void clicks_save_button() {
	   pa.save();
	}
	@Then("the Prescription should be added in OPD Section")
	public void the_prescription_should_be_added_in_opd_section() {
	    
	}
}
