package com.runner;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
<<<<<<< HEAD
    features = {"src\\test\\resources\\Features\\DoctorFeature.feature","src\\test\\resources\\Features\\SearchFeature.feature","src\\test\\resources\\Features\\PrescriptionFeature.feature"},
=======
    features = {"src/test/resources/Features/AccountantFeature.feature"},
>>>>>>> branch 'main' of https://github.com/Gayathri0017/Smart_Hospital_Cucumber.git
    glue = {"com.definitions", "com.utils"},
    plugin = {"pretty", "html:target/cucumber-reports.html" , "json:target/cucumber-reports.json"},
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