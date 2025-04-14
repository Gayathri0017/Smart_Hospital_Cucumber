package com.actions;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.pages.SearchPage;
import com.utils.HelperClass;
public class SearchActions {
SearchPage sp=null;
public SearchActions() {
	this.sp=new SearchPage();
	PageFactory.initElements(HelperClass.getDriver(), sp);
}
public void search(String name) {
	sendKeysMethod(sp.searchBar,name);
}
public void clickSrch() {
	clickmethod(sp.searchBtn);
}
public void assertSearch(String exp) {
	if(exp.equals("No data available in table")) {
		WebDriverWait wait=new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(sp.error));
	    String act=sp.error.getText();
	    Assert.assertTrue(act.contains(exp));  
	}else {
		WebDriverWait wait=new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(sp.name));
	    String act=sp.name.getText();
	    Assert.assertTrue(act.contains(exp));
	}
}
public void sendKeysMethod(WebElement ele,String val) {
	ele.sendKeys(val);
}
public void clickmethod(WebElement ele) {
	ele.click();
}
}
