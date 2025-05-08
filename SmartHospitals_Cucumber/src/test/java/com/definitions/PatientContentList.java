package com.definitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actions.PatientActions;
import com.utils.HelperClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientContentList {
	
	private static final Logger log = LogManager.getLogger(PatientDefinition.class);
	PatientActions objPatientActions = new PatientActions();  
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));
	
	@When("the User is able to click the download center option")
	public void the_user_is_able_to_click_the_download_center_option() {
		objPatientActions.clickDownloadCenter();
		log.info("Download Center is clicked ");
	}

	@Then("the User is able to visible the content list for {string}")
	public void the_user_is_able_to_visible_the_content_list_for(String content) {
		objPatientActions.ContentList(content);
		log.info("content passed successfully :%s",content);
	}
}
