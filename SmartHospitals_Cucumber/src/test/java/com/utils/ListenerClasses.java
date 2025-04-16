package com.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClasses implements ITestListener{
	private static final Logger log = LogManager.getLogger(ListenerClasses.class);
	public void onTestFailure(ITestResult result) {
		CapturingFailure(HelperClass.getDriver(),result.getName());
	}

	private void CapturingFailure(WebDriver driver, String ScreenshotName) {
		TakesScreenshot ts = (TakesScreenshot)HelperClass.getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String directory = System.getProperty("user.dir") + "/Screenshots/";
		
		String path = directory + ScreenshotName + ".png";
		
		File tgt = new File(path);
		try {
			FileUtils.copyFile(src, tgt);
			log.info("Screenshot tooked for failure :"+ScreenshotName);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
