package com.runner;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
@CucumberOptions(


     features = {"src\\test\\resources\\Features\\PatientLogin.feature",
    		 "src\\test\\resources\\Features\\PatientAppointment.feature",
    		 "src\\test\\resources\\Features\\PatientDetails.feature",
    		 "src\\test\\resources\\Features\\PatientPayment.feature",
    		 "src\\test\\resources\\Features\\PatientDischarge.feature",
    		 "src\\test\\resources\\Features\\StaffDirectory.feature"
    		 },
    glue = {"com.definitions", "com.utils"},
    plugin = {"pretty","json:target/cucumber-reports/reports.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
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

