package com.definitions;
import com.actions.SearchActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class SearchDefinition {
	SearchActions sa=new SearchActions();
	@When("the Doctor enters {string} in the search bar")
	public void the_doctor_enters_in_the_search_bar(String string) {
	    sa.search(string);
	}
	@When("clicks the search button")
	public void clicks_the_search_button() {
	    sa.clickSrch();
	}
	@Then("the system should Show the {string}")
	public void the_system_should_show_the(String string) {
	   sa.assertSearch(string);
	}
}
