
package com.definitions;                                                                                        
                                                                                                                
import java.util.List;                                                                                          
                                                                                                                
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
	}                                                                                                           
                                                                                                                
	@When("the User clicks the Sign In button")                                                                 
	public void the_user_clicks_the_sign_in_button() {                                                          
		objPatientActions.SwitchTab();                                                                          
		objPatientActions.ClickSignInBtn();                                                                     
	}                                                                                                           
                                                                                                                
	@Then("the User is directed to the patient dashboard")                                                      
	public void the_user_is_directed_to_the_patient_dashboard() {                                               
		objPatientActions.ClickProfile();                                                                       
//		HelperClass.getDriver().switchTo().alert().accept();                                                    
		                                                                                                        
		Assert.assertTrue(objPatientActions.getProfileRole().contains("Patient"));                              
	}                                                                                                           
	                                                                                                            
                                                                                                                
@Given("the User Provides invalid Username")                                                                    
public void the_user_provides_invalid_username() {                                                              
	objPatientActions.BlankPassword();                                                                          
}                                                                                                               
                                                                                                                
@Then("the User able to see the errorMessage as {string}")                                                      
public void the_user_able_to_see_the_error_message_as(String error, io.cucumber.datatable.DataTable dataTable) {
	List<List<String>> msg = dataTable.asLists();                                                               
	                                                                                                            
//	Assert.assertTrue(objPatientActions.getUserNameRequired().contains(error));                                 
}                                                                                                               
    
@Then("the User is able to click the my appointment button")
public void the_user_is_able_to_click_the_my_appointment_button() {
	objPatientActions.ClickMyAppointment();
}

@Then("the User is able to see the add appointment option")
public void the_user_is_able_to_see_the_add_appointment_option(){
	objPatientActions.ClickAddAppointment();
}

@Then("the User can fill the appointment form")
public void the_user_can_fill_the_appointment_form() {
	objPatientActions.AppointmentDetails();
}

@Then("the User should save the form for appointment")
public void the_user_should_save_the_form_for_appointment() {
	objPatientActions.ClickFormsubmit();
}


                                                                                                                
                                                                                                                
}                                                                                                               
