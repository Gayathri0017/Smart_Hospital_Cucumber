package com.runner;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
    features = {"src\\test\\resources\\Features\\AccountantFeatureExpenses.feature"},
    glue = {"com.definitions", "com.utils"},
    tags="@ValidInput",
    plugin = {"pretty", "html:target/cucumber-reports.html" , "json:target/cucumber-reports.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",},
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
