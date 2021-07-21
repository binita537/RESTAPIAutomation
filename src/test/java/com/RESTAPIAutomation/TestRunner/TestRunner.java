package com.RESTAPIAutomation.TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src//main//java//com//RESTAPIAutomation//Features",
                 glue= {"com/RESTAPIAutomation/stepDefinition"},
                 
                 plugin="json:target/jsonReports/cucumber-reporting.json"
                
                 
                 )
public class TestRunner{

	  
	
}

