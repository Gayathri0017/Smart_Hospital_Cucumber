package com.definitions;

import com.actions.StaffDirectoryActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StaffDirectoryDefinition {
	StaffDirectoryActions objSDA = new StaffDirectoryActions() ;
	@Given("the Doctor clicks the human resource button")
	public void the_doctor_clicks_the_human_resource_button() {
		objSDA.ClickHR();
	}

	@When("the Doctor clicks the list view")
	public void the_doctor_clicks_the_list_view() {
		objSDA.ClickListView();
	}

	@Then("the Doctor can able to visible the staff available")
	public void the_doctor_can_able_to_visible_the_staff_available() {
		objSDA.getNameAndRole();
	}

}
