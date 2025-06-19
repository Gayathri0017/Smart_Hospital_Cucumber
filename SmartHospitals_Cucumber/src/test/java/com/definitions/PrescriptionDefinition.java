package com.definitions;
import java.util.List;
import java.util.Map;
import com.actions.DoctorActions;
import com.actions.PrescriptionActions;
import com.utils.HelperClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class PrescriptionDefinition {
	DoctorActions doctor = new DoctorActions();
	PrescriptionActions pa=new PrescriptionActions();
	String name=null;
	@When("the Doctor Navigates to the OPD section")
	public void the_doctor_navigates_to_the_opd_section(){
	   pa.OPDSection();
	}
	@When("Clicks the Add Prescription")
	public void clicks_the_add_prescription(){
	    pa.addPres();
	}
	@Then("the doctor should navigate to the Prescription Page")
	public void the_doctor_should_navigate_to_the_prescription_page(){
	    pa.assertPP();
	}
	@When("the doctor Fill the valid Details:")
	public void the_doctor_fill_the_valid_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException{
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
	    //pass
	}
	@When("the doctor fills the prescription form with:")
	public void the_doctor_fills_the_prescription_form_with(io.cucumber.datatable.DataTable dataTable) throws InterruptedException{ 
		Map<String, String> data = dataTable.asMaps().get(0);
		    pa.selectFindingCategory(data.get("Medicine Category"));
		    pa.selectMedicineCategory(data.get("Medicine"));
		    pa.selectMedicine(data.get("Dose"));
		    pa.selectDoseInterval(data.get("Dose Interval"));
		    pa.selectDoseDuration(data.get("Dose Duration"));
	}
	@Then("the system should show an error {string}")
	public void the_system_should_show_an_error(String string){
	   pa.assertinvalid(string);
	}
	@When("the doctor clicks the edit option")
	public void the_doctor_clicks_the_edit_option(){
	    pa.edit();
	}
	@When("the doctor Clicks the View Prescription {string}")
	public void the_doctor_clicks_the_view_prescription(String string){
	   name=string;
	   pa.view(string);
	}
	@Then("the previously added prescription should be visible")
	public void the_previously_added_prescription_should_be_visible() {
	    pa.assertPrescription(name);
	}
	@Then("the doctor should see the <{string}>")
	public void the_doctor_should_see_the(String string) {
	    pa.assertShow(string);
	}
	@When("the doctor clicks delete option in visit details")
	public void the_doctor_clicks_delete_option_in_visit_details() {
	   try {
		   pa.delete();
		   HelperClass.getDriver().switchTo().alert().accept();
	   }catch(Exception e) {
		   System.out.println(e.getMessage());
	   }
	}
	@When("the doctor Clicks the Manual Prescription")
	public void the_doctor_clicks_the_manual_prescription() {
	    pa.viewPres();
	}
	@Then("the previously added manual prescription should be visible")
	public void the_previously_added_manual_prescription_should_be_visible() {
	    pa.assertManual();
	}

}
