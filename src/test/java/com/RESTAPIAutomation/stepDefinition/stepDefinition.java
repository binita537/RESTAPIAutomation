package com.RESTAPIAutomation.stepDefinition;

import org.junit.Assert;

import org.junit.runner.RunWith;

import com.RESTAPIAutomation.Enum.APIResources;
import com.RESTAPIAutomation.TestData.TestData;
import com.RESTAPIAutomation.Utilities.CommonUtilities;  


import static  io.restassured.RestAssured.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class stepDefinition {
	
	
	
CommonUtilities commonUtilities= new CommonUtilities();
	
	
	RequestSpecification Request;
	    
    Response response;
    static String  ActualId;
    
    int actaulStatuscode;
    
    TestData testData=new TestData();
    
    @Given("Add Books Payloads")
    public void add_books_payloads() throws Throwable {
    	Request=given().spec(commonUtilities.createRequestSpecification()).body(testData.AddBooksData()); 
    }
    @When("User hit {string} Payload with {string} Request")
    public void user_hit_payload_with_request(String APIName ,String HttpMethod) throws Throwable {
    	APIResources resources=APIResources.valueOf(APIName);    	   
  	   System.out.println(resources.getResources());
  	
  	
  	
  	if(HttpMethod.equalsIgnoreCase("POST"))
  	{    	
  	  response=Request.when().post(resources.getResources());
  			  
  	}
  	else if(HttpMethod.equalsIgnoreCase("GET"))
  	{ 
  		response=Request.when().get(resources.getResources());
  	}
  	else if(HttpMethod.equalsIgnoreCase("Delete"))
  	{ 
  		response=Request.when().delete(resources.getResources());
  	}
  	else if(HttpMethod.equalsIgnoreCase("Update"))
  	{ 
  		response=Request.when().put(resources.getResources());
  	}
  	else if(HttpMethod.equalsIgnoreCase("Patch"))
  	{ 
  		response=Request.when().patch(resources.getResources());
  	}
  	
  	
  	response.then().spec(commonUtilities.createResponseSpecification()).extract().response();
  	
    }
    @Then("Books added successfully with status code {int}")
    public void books_added_successfully_with_status_code(int ExpectedResponseCode) {
     actaulStatuscode=response.statusCode();
    	
    	Assert.assertEquals(ExpectedResponseCode, actaulStatuscode);
    }
    @Then("Verify the response should have {string}")
    public void verify_the_response_should_have(String id) {
    	ActualId=commonUtilities.getValueFromResponseJsonPath(response, id);
		Assert.assertEquals(200, ActualId);
    }

    
    /*
    
	@Given("^Add Books Payloads$")
	public void add_Books_Payloads() throws Throwable {

		Request=given().spec(commonUtilities.createRequestSpecification()).body(testData.AddBooksData()); 
	}

	@When("^User hit \"([^\"]*)\" Payload with \"([^\"]*)\" Request$")
	public void user_hit_Payload_with_Request(String APIName ,String HttpMethod) throws Throwable {
		APIResources resources=APIResources.valueOf(APIName);    	   
 	   System.out.println(resources.getResources());
 	
 	
 	
 	if(HttpMethod.equalsIgnoreCase("POST"))
 	{    	
 	  response=Request.when().post(resources.getResources());
 			  
 	}
 	else if(HttpMethod.equalsIgnoreCase("GET"))
 	{ 
 		response=Request.when().get(resources.getResources());
 	}
 	else if(HttpMethod.equalsIgnoreCase("Delete"))
 	{ 
 		response=Request.when().delete(resources.getResources());
 	}
 	else if(HttpMethod.equalsIgnoreCase("Update"))
 	{ 
 		response=Request.when().put(resources.getResources());
 	}
 	else if(HttpMethod.equalsIgnoreCase("Patch"))
 	{ 
 		response=Request.when().patch(resources.getResources());
 	}
 	
 	
 	response.then().spec(commonUtilities.createResponseSpecification()).extract().response();
 	
	}

	@Then("^Books added successfully with status code (\\d+)$")
	public void books_added_successfully_with_status_code(int ExpectedResponseCode) throws Throwable {
actaulStatuscode=response.statusCode();
    	
    	Assert.assertEquals(ExpectedResponseCode, actaulStatuscode);
	}

	@Then("^Verify the response should have \"([^\"]*)\"$")
	public void verify_the_response_should_have(String id) throws Throwable {
		ActualId=commonUtilities.getValueFromResponseJsonPath(response, id);
		Assert.assertEquals(200, ActualId);
	}*/
}



