package com.actions;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.pages.SearchPage;
import com.utils.HelperClass;
public class SearchActions {
	SearchPage sp=null;
	Logger logger=LogManager.getLogger(SearchActions.class);
	public SearchActions() {
		this.sp=new SearchPage();
		PageFactory.initElements(HelperClass.getDriver(), sp);
	}
	public void search(String name) {
		logger.info("Entering search text: "+name);
		sendKeysMethod(sp.searchBar,name);
		logger.info("Searched the patient name");
	}
	public void clickSrch() {
		logger.info("Clicking search button");
		clickmethod(sp.searchBtn);
		logger.info("Clicked Search icon");
	}
	public void assertSearch(String exp) {
		if(exp.equals("No data available in table")) {
			WebDriverWait wait=new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(sp.error));
			String act=sp.error.getText();
			logger.info("Expected: "+exp+", Actual: "+act);
			Assert.assertTrue(act.contains(exp));
		}else {
			WebDriverWait wait=new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(sp.name));
			String act=sp.name.getText();
			logger.info("Expected: "+exp+", Actual: "+act);
			Assert.assertTrue(act.contains(exp));
		}
	}
	public String getName() {
		return sp.delName.getText();
	}
	public void selectPatient() {
		clickmethod(sp.chkBox);
	}
	public void assertDel(String ex,String act) {
		 Assert.assertEquals(ex,act);
	}
	public void clickDelete() {
		clickmethod(sp.delBtn);
	}
	public void sendKeysMethod(WebElement ele,String val) {
		ele.sendKeys(val);
	}
	public void clickmethod(WebElement ele) {
		ele.click();
	}
}

