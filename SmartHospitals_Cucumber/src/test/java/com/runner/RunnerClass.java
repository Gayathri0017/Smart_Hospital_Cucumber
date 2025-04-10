package com.runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src\\test\\resources\\Features",
    glue = {"com.definitions", "com.utils"},
    plugin = {"pretty", "html:target/cucumber-reports.html"}
    )
public class RunnerClass extends AbstractTestNGCucumberTests {
}
