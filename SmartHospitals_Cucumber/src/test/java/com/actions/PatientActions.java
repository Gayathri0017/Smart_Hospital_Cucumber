package com.actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.PatientWorkflowPage;
import com.utils.HelperClass;

public class PatientActions {
	
	PatientWorkflowPage objPatientPage = null ;
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));
	
	public PatientActions() {
		objPatientPage = new PatientWorkflowPage();
		PageFactory.initElements(HelperClass.getDriver(), objPatientPage);
	}
	
	public void ClickUserLoginBtn() {
		objPatientPage.userLoginBtn.click();
	}
	
	public void ClickSignInBtn() {
		objPatientPage.signInBtn.click();
	}
	
	public void ClickProfile() {
		objPatientPage.profile.click();
	}
	
	public String getProfileRole() {
		wait.until(ExpectedConditions.visibilityOf(objPatientPage.verifyProfile));
		
		return objPatientPage.verifyProfile.getText();
	}
	
	public void SwitchTab() {
		Set<String> Allwindows = HelperClass.getDriver().getWindowHandles();
		Iterator<String> it = Allwindows.iterator();
		String mainWindow = it.next();
		String childWindow = it.next();
		HelperClass.getDriver().switchTo().window(childWindow);
	}
	
	public void BlankUsername() {
		objPatientPage.email.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	}
	
	public void BlankPassword() {
		objPatientPage.password.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	}
	
	public String getUserNameRequired() {
		return objPatientPage.usernameReq.getText();
	}
	
	public String getPasswordRequired() {
		return objPatientPage.passwordReq.getText();
	}
}
