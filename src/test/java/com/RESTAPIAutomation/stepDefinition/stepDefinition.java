package com.RESTAPIAutomation.stepDefinition;

import static io.restassured.RestAssured.given;




import org.junit.Assert;
import org.junit.runner.RunWith;

import com.RESTAPIAutomation.Enum.APIResources;
import com.RESTAPIAutomation.TestData.TestData;
import com.RESTAPIAutomation.Utilities.CommonUtilities;

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
    
    

    @When("User hit {string} Payload with {String} Request")
    public void user_hit_payload_with_post_request(String APIName ,String HttpMethod) throws Throwable {
    	
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
    public void books_added_successfully_with_status_code(int ExpectedResponseCode) throws Throwable {

    	actaulStatuscode=response.statusCode();
    	
    	Assert.assertEquals(ExpectedResponseCode, actaulStatuscode);     
		
    }
    


    @And("Verify the response should have  {String} is equal to  {String}")
    public void verify_the_response_should_have_something_is_equal_to_something(String id, String ExpectedId) throws Throwable {
     {
    	ActualId=commonUtilities.getValueFromResponseJsonPath(response, id);
		Assert.assertEquals(ExpectedId, ActualId);
     }
		

		
    }
    
    @Given("Add Books Payloads with {String} {String} {String} {String} {String} {String} ")
    public void add_books_payloads_with_something_something_something_something_something_something(String id, String title, String description, String pagecount, String excerpt, String publishdate) throws Throwable {
  
    	Request=given().spec(commonUtilities.createRequestSpecification()).body(testData.AddBooksData(id,title,description,pagecount,excerpt,publishdate));
    	
    }

}



