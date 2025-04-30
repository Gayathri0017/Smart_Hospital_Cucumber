package com.definitions;
import java.util.List;
import java.util.Map;

import com.actions.MessageActions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class MessageDefinition {
	MessageActions ma=new MessageActions();
	String expected=null;
	@When("the doctor navigates to the Messaging section")
	public void the_doctor_navigates_to_the_messaging_section() {
	   ma.msgPage();
	}
	@When("the doctor clicks the Post New Message")
	public void the_doctor_clicks_the_post_new_message() {
	    ma.post();
	}
	@When("the doctor fills the required fields:")
	public void the_doctor_fills_the_required_fields(io.cucumber.datatable.DataTable dataTable) {
		 List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
		    for (Map<String, String> row : rows) {
		        String title=row.get("Title");
		        String message=row.get("Message");
		        String date=row.get("Notice Date");
		        String publishOn=row.get("Publish On");
		        expected=row.get("PostAction");
		        ma.msgFilling(title,date,publishOn,message);
		 }
	}
	@When("the doctor clicks the Send button")
	public void the_doctor_clicks_the_send_button() {
	   ma.send();
	}
	@Then("the message should be added to the Notice Board and displayed")
	public void the_message_should_be_added_to_the_notice_board_and_displayed() {
	    ma.assertPost(expected);
	}
}
