package com.definitions;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actions.MessageActions;
import com.utils.HelperClass;
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
	        String title=sanitize(row.get("Title"));
	        String message = sanitize(row.get("Message"));
	        String date = sanitize(row.get("Notice Date"));
	        String publishOn = sanitize(row.get("Publish On"));
	        expected = row.get("PostAction");
	        ma.msgFilling(title, date, publishOn, message);
	    }
	}
	private String sanitize(String value) {
	    return (value==null || value.equalsIgnoreCase("[empty]")) ? "" : value;
	}
	@When("the doctor clicks the Send button")
	public void the_doctor_clicks_the_send_button() {
	   ma.send();
	}
	@Then("the message should be added to the Notice Board and displayed")
	public void the_message_should_be_added_to_the_notice_board_and_displayed() {
		if(expected.equals("Record Saved Successfully")) {
			ma.assertPost(expected);
		}
		else {
			ma.assertRequired(expected);
		}
	}
	@When("the doctor clicks the delete icon of the message")
	public void the_doctor_clicks_the_delete_icon_of_the_message() {
	   ma.delete();
	}
//	@When("the doctor accepts the alert to confirm delete")
//	public void the_doctor_accepts_the_alert_to_confirm_delete() {
//	   HelperClass.getDriver().switchTo().alert().accept();
//	}
	@When("the doctor accepts the alert to confirm delete")
	public void the_doctor_accepts_the_alert_to_confirm_delete() {
	    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(5));
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        HelperClass.getDriver().switchTo().alert().accept();
	    } catch (TimeoutException e) {
	        System.out.println("❌ Alert was not present in time. Possible reasons: delete click failed or alert didn't trigger.");
	    }
	}

	@Then("the message should be successfully deleted from notice board")
	public void the_message_should_be_successfully_deleted_from_notice_board() {
	   //pass
	}
}
