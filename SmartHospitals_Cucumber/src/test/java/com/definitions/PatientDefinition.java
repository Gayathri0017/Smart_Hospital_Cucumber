
package com.definitions;                                                                                        
                                                                                                                
import java.util.List;
import java.util.Map;

import org.testng.Assert;                                                                                       
                                                                                                                
import com.actions.PatientActions;                                                                              
import com.utils.HelperClass;                                                                                   
                                                                                                                
import io.cucumber.java.en.Given;                                                                               
import io.cucumber.java.en.Then;                                                                                
import io.cucumber.java.en.When;                                                                                
                                                                                                                
public class PatientDefinition {                                                                                
	PatientActions objPatientActions = new PatientActions();                                                    
	                                                                                                            
	@Given("the User is on the Login Page")                                                            
	public void the_user_is_on_the_login_page() {     
		HelperClass.getDriver();
	}                                                                                                           
                                                                                                                
                                                                                                                
	@When("the User clicks the User Login")                                                                     
	public void the_user_clicks_the_user_login() {                                                              
		objPatientActions.ClickUserLoginBtn();                                                                  
		objPatientActions.SwitchTab();                                                                          
	}                                                                                                           
                                                                                                                
	@When("the User clicks the Sign In button")                                                                 
	public void the_user_clicks_the_sign_in_button() {                                                          
		objPatientActions.ClickSignInBtn();                                                                     
	}                                                                                                           
                                                                                                                
	@Then("the User is directed to the patient dashboard")                                                      
	public void the_user_is_directed_to_the_patient_dashboard() {                                               
		objPatientActions.ClickProfile();                                                                       
		Assert.assertTrue(objPatientActions.getProfileRole().contains("Patient"));                              
	}                                                                                                           
	                                                                                                            
                                                                                                                
@When("the User Provides invalid Username")                                                                    
public void the_user_provides_invalid_username() {                                                              
	objPatientActions.BlankUsername();                                                                          
}                                
@When("the User Provides invalid Password")
public void the_user_provides_invalid_password() {
	objPatientActions.BlankPassword();
}

                                                                                                                
@Then("the User able to see the errorMessage as {string}")                                                      
public void the_user_able_to_see_the_error_message_as(String error, io.cucumber.datatable.DataTable dataTable) {
	List<Map<String , String>> errormsg = dataTable.asMaps();
	for(Map<String , String> message:errormsg) {
		if(message.containsKey("Username field is required")) {			
			Assert.assertTrue(objPatientActions.getUserNameRequired().contains(message.get("errormsg")));
		}
		if(message.containsKey("Password field is required")) {
			Assert.assertTrue(objPatientActions.getPasswordRequired().contains(message.get("errormsg")));
			
		}
		
	}
}                                                                                                               
    
@Then("the User is able to click the my appointment button")
public void the_user_is_able_to_click_the_my_appointment_button() {
	objPatientActions.ClickMyAppointment();
}

@Then("the User is able to see the add appointment option")
public void the_user_is_able_to_see_the_add_appointment_option(){
	objPatientActions.ClickAddAppointment();
}


@Then("the User can fill the appointment")
public void the_user_can_fill_the_appointment(io.cucumber.datatable.DataTable dataTable) {
    List<Map<String, String>> form = dataTable.asMaps(String.class, String.class);
    for (Map<String, String> details : form) {
        String date = details.get("Date");
        objPatientActions.setDate(date);

        String specialist = details.get("Specialist");
        objPatientActions.setSpecialist(specialist);

        String doctor = details.get("Doctor");
        objPatientActions.setDoctor(doctor);

        String shift = details.get("Shift");
        objPatientActions.setShift(shift);

        String time = details.get("Timing");
        objPatientActions.setTime(time);

        String availableTiming = details.get("AvailableTiming");
        objPatientActions.setAvailableTime();

        String message = details.get("Message");
        objPatientActions.setMessage(message);
    }
    objPatientActions.ClickFormsubmit();
}

@Then("the User can fill the appointment form")
public void the_user_can_fill_the_appointment_form() {
	objPatientActions.AppointmentDetails();
	
}

@Then("the User should save the form for appointment")
public void the_user_should_save_the_form_for_appointment() {
	objPatientActions.ClickFormsubmit();
}

@Then("the User can able to see the error msg {string}")
public void the_user_can_able_to_see_the_error_msg(String error) {
	Assert.assertTrue(objPatientActions.getError().contains(error));
	System.out.println(objPatientActions.getError());
}

                                                                                                                
                                                                                                                
}                                                                                                               
