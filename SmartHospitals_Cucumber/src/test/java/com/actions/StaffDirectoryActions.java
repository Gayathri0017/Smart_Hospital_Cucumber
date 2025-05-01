package com.actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.StaffDirectoryPage;
import com.utils.HelperClass;

public class StaffDirectoryActions {
	StaffDirectoryPage objSD = null ;
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));
	
	public StaffDirectoryActions() {
		objSD = new StaffDirectoryPage();
		PageFactory.initElements(HelperClass.getDriver(), objSD);
	}
	
	public void ClickHR() {
		wait.until(ExpectedConditions.visibilityOf(objSD.hr));
		objSD.hr.click();
	}
	
	public void ClickListView() {
		wait.until(ExpectedConditions.visibilityOf(objSD.listView));
		objSD.listView.click();
	}
	
	public void  getNameAndRole() {
		List <WebElement> name = objSD.name;
		List<WebElement> role = objSD.role;
		for(int i = 0 ; i < name.size() ; i++) {
			System.out.println("Name : "+name.get(i).getText()+", Role : "+role.get(i).getText());
		}
		
	}
	
//	public void getRole() {
//		List<WebElement> role = objSD.role;
//		for(WebElement r:role) {
//			System.out.println("Role : "+r.getText());
//		}
//	}
}
