package com.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utils.HelperClass;

public class CommonActions {

	public void ClickFun(WebElement element) {
		JavascriptExecutor js =  (JavascriptExecutor)HelperClass.getDriver();
		js.executeScript("arguments[0].click()", element);
	}
}
