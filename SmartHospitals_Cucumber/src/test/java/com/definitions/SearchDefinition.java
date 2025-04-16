package com.definitions;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.SearchActions;
import com.utils.HelperClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class SearchDefinition {
	String name=null;
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
	@When("selects the patient and clicks {string}")
	public void selects_the_patient_and_clicks(String string) {
	   name=sa.getName();
	   sa.selectPatient();
	   sa.clickDelete();
	}
	@Then("the patient should no longer appear in the searched list")
	public void the_patient_should_no_longer_appear_in_the_searched_list() {
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.alertIsPresent());
	   HelperClass.getDriver().switchTo().alert().accept();
	   String afterdel=sa.getName();
	   sa.assertDel(name,afterdel);
	  
	}
}
