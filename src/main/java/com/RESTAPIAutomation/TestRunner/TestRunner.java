package com.RESTAPIAutomation.TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src//main//java//com//RESTAPIAutomation//Features",
                 glue= "stepDefinition",
                
                 plugin="json:target/jsonReports/cucumber-report.json"
                 )
public class TestRunner {

}

//C:/User s/Lenovo/eclipse-workspace/RESTAPIAutomation/src/main/java/com/RESTAPIAutomation/stepDefinition