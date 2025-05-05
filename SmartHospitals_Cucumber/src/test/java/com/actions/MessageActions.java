package com.actions;
import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.MessagePage;
import com.utils.HelperClass;
public class MessageActions {
	MessagePage mp=null;
	public MessageActions() {
	    this.mp=new MessagePage();
	    PageFactory.initElements(HelperClass.getDriver(), mp);
	}
	public void msgPage() {
		clickMethod(mp.msg);
	}
	public void post() {
		clickMethod(mp.postNew);
	}
	public void msgFilling(String tit,String date,String postOn,String msg) {
		sendKeysMethod(mp.title,tit);
		sendKeysMethod(mp.date,date);
		sendKeysMethod(mp.publishDate,postOn);
		HelperClass.getDriver().switchTo().frame(0);
		sendKeysMethod(mp.content,msg);
		HelperClass.getDriver().switchTo().defaultContent();
	}
	public void send() {
		clickMethod(mp.sendBtn);
	}
	public void assertPost(String ex) {
		WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
		WebElement successAlert = wait.until(ExpectedConditions.visibilityOf(mp.success));
		String act=mp.success.getText();
		Assert.assertEquals(ex,act);
	}
	public void assertRequired(String exp) {
		WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
		WebElement successAlert= wait.until(ExpectedConditions.visibilityOf(mp.error));
		String act=mp.error.getText();
		Assert.assertEquals(exp,act);
	}
	public void delete() {
		clickMethod(mp.del);
	}
	public void clickMethod(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor) HelperClass.getDriver();
	    try {
	    	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(ele));
	        ele.click();
	    } catch (ElementClickInterceptedException e) {
	        js.executeScript("arguments[0].click();", ele);
	    } catch (Exception e) {
	        System.out.println("Click failed: " + e.getMessage());
	    }
	}
    public void sendKeysMethod(WebElement ele, String str) {
        ele.sendKeys(str);
    }
}
