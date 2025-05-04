package com.definitions;

import org.testng.Assert;

import com.actions.LoginActions;
import com.utils.HelperClass;
import io.cucumber.java.en.*;

public class LoginDefinition {
    private LoginActions loginActions;
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        HelperClass.getDriver().get("https://demo.smart-hospital.in/site/login");
        loginActions = new LoginActions();
    }
    @When("the user selects the role {string}")
    public void the_user_selects_the_role(String role) {
        loginActions.selectRole(role);
    }
@When("User leaves the {string} field empty")
public void user_leaves_the_field_empty(String string) {
   if(string.equalsIgnoreCase("username"))
   {
	   loginActions.enterUsername();
      
   }
   else if (string.equalsIgnoreCase("both"))
   {
	   loginActions.enterUsername();
       loginActions.enterPassword();
   }
   else
   {
       loginActions.enterPassword();
   }
	}
@When("the user clicks the Sign In button")
public void the_user_clicks_the_sign_in_button() {
    loginActions.clickSignIn();
}

@Then("the user should see the dashboard page for the {string} role")
public void the_user_should_see_the_dashboard_page_for_the_role(String role) {
    Assert.assertTrue(loginActions.isDashboardDisplayed(role));
}

@Then("User should see an error message")
public void user_should_see_an_error_message() {
    Assert.assertTrue(loginActions.isErrorDisplayed());
}
}
