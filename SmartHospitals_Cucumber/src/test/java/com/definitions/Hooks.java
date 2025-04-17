package com.definitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.utils.HelperClass;
public class Hooks{
    @Before
    public static void setUp() {
        HelperClass.getDriver();
        HelperClass.getDriver().navigate().refresh();
    }
    @After
    public static void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            // Take screenshot if scenario fails
        	File srcFile = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
        	File destFile = new File("screenshots/" + scenario.getName() + ".png");
        	FileUtils.copyFile(srcFile, destFile);
        }
        HelperClass.quitDriver();
    }
}