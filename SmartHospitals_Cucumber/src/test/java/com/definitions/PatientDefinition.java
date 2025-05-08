package com.definitions;                                                                                        
                                                     

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;                                                                                       
                                                                                                                
import com.actions.PatientActions;                                                                              
import com.utils.HelperClass;                                                                                   
                                                                                                                
import io.cucumber.java.en.Given;                                                                               
import io.cucumber.java.en.Then;                                                                                
import io.cucumber.java.en.When;                                                                                
                                                                                                                
public class PatientDefinition {      
	private static final Logger log = LogManager.getLogger(PatientDefinition.class);
	PatientActions objPatientActions = new PatientActions();  
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));

	                                                                                                            
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
		try {
			Assert.assertTrue(objPatientActions.getProfileRole().contains("Patient"));  
			log.info("Assert gets passed in profile verification for patient");
		}catch(Exception e) {
			log.error("Assert gets failed in profile verification for patient");
			throw e;
		}
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
			try {
				Assert.assertTrue(objPatientActions.getUserNameRequired().contains(message.get("errormsg")));
				log.info("Assert gets passed in username required ");
			}catch (Exception e) {
				log.error("Assert gets failed in username required ");
				throw e;
			}
		}
		if(message.containsKey("Password field is required")) {
			try {
				Assert.assertTrue(objPatientActions.getPasswordRequired().contains(message.get("errormsg")));
				log.info("Assert gets passed in password required ");
			}catch (Exception e) {
				log.error("Assert gets failed in password required ");
				throw e;
			}
			
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
        

        	try {
        		
        		objPatientActions.setAvailableTime();
        	}
        	catch (Exception e){
        		System.out.println(e.getMessage());
        	}
            String message = details.get("Message");
            objPatientActions.setMessage(message);

        }


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
	try {
		Assert.assertTrue(objPatientActions.getError().contains(error));
		System.out.println(objPatientActions.getError());
	}catch (Exception e) {
		log.error("Assert gets failed in error message ");
		throw e;
	}
}
@Then("the User is able see the success message {string}")
public void the_user_is_able_see_the_success_message(String successMsg) {
	try {
		Assert.assertTrue(objPatientActions.getSuccessMsg().contains(successMsg));
		System.out.println(objPatientActions.getSuccessMsg());
	}catch (Exception e) {
		log.error("Assert gets failed in success message ");
		try {
			Assert.assertTrue(objPatientActions.getAppointmentnotAvail().contains("Appointment not available, Please try after some time."));
			System.out.println(objPatientActions.getAppointmentnotAvail());
		}
		catch(Exception ex) {
			log.error("Assert gets failed due to appointment booking");
			throw e;
		}
	}
}
                                                                                                                
                                                                                                                
}