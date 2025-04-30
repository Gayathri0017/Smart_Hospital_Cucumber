package com.runner;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
@CucumberOptions(

    features = {"src\\test\\resources\\Features\\transactionReportDownlode.feature"},
    glue = {"com.definitions", "com.utils"},
    plugin = {"pretty", "json:target/cucumber-reports/reports.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    monochrome = true,
    dryRun = false
)
public class RunnerClass extends AbstractTestNGCucumberTests {
	    @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();   
	  }
}

