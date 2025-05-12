package com.definitions;
import com.actions.VerifyLinksAction_Doctor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class VerifyLinksDef_Doctor {
	VerifyLinksAction_Doctor vl=new VerifyLinksAction_Doctor();
	@When("the user checks all the links on the page")
	public void the_user_checks_all_the_links_on_the_page() {
		vl.verifyLinks();
	}
	@Then("the user should see which links are broken and which are valid")
	public void the_user_should_see_which_links_are_broken_and_which_are_valid() {
		vl.getCount();
}
}