package com.definitions;
import java.util.List;
import java.util.Map;

import com.actions.DoctorActions;
import com.actions.PrescriptionActions;
import com.utils.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class PrescriptionDefinition {
	DoctorActions doctor = new DoctorActions();
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
	@When("the doctor fills the prescription form with:")
	public void the_doctor_fills_the_prescription_form_with(io.cucumber.datatable.DataTable dataTable) throws InterruptedException { 
		Map<String, String> data = dataTable.asMaps().get(0);
		    pa.selectFindingCategory(data.get("Medicine Category"));
		    pa.selectMedicineCategory(data.get("Medicine"));
		    pa.selectMedicine(data.get("Dose"));
		    pa.selectDoseInterval(data.get("Dose Interval"));
		    pa.selectDoseDuration(data.get("Dose Duration"));
	}
	@Then("the system should show an error {string}")
	public void the_system_should_show_an_error(String string) {
	   pa.assertinvalid(string);
	}
	@When("the doctor clicks the edit option")
	public void the_doctor_clicks_the_edit_option() throws InterruptedException {
	    pa.edit();
	    Thread.sleep(1000);
	}
	@When("the doctor Clicks the View Prescription")
	public void the_doctor_clicks_the_view_prescription() throws InterruptedException{
		try {
		HelperClass.getDriver().navigate().refresh();
		Thread.sleep(5000);
	    pa.view();
		}catch(Exception e) {
			System.out.println("Prescrition not got added:"+e.getMessage());
		}
	}
	@Then("the previously added prescription should be visible")
	public void the_previously_added_prescription_should_be_visible() {
	    pa.assertPrescription();
	}
	@When("the doctor clicks the Edit button of the existing prescription")
	public void the_doctor_clicks_the_edit_button_of_the_existing_prescription() {
	    pa.edit();
	}
	@When("updates the prescription details:")
	public void updates_the_prescription_details(io.cucumber.datatable.DataTable dataTable) {
		  List<Map<String, String>> details = dataTable.asMaps(String.class, String.class);
		    for (Map<String, String> row : details) {
		        String doseInterval=row.get("Dose Interval");
		        String doseDuration=row.get("Dose Duration");
		        pa.selectDoseDuration(doseDuration);
		        pa.selectDoseInterval(doseDuration);
		    }
	}
	@When("clicks the Update button")
	public void clicks_the_update_button() {
	    pa.save();
	}
	@Then("the Prescription should be updated")
	public void the_prescription_should_be_updated() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
