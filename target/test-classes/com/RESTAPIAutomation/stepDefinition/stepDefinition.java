package com.RESTAPIAutomation.stepDefinition;

import static io.restassured.RestAssured.given;

import org.junit.runner.RunWith;

import com.RESTAPIAutomation.TestData.TestData;
import com.RESTAPIAutomation.Utilities.CommonUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

@RunWith(Cucumber.class)
public class stepDefinition {
	
CommonUtilities commonUtilities= new CommonUtilities();
	
	RequestSpecification requestSpecification;
	RequestSpecification Request;
    ResponseSpecification responseSpecification;
    Response response;
    
    TestData testData=new TestData();

    @Given("Add Books Payloads")
    public void add_books_payloads() throws Throwable {


		requestSpecification=commonUtilities.createRequestSpecification();
		responseSpecification=commonUtilities.createResponseSpecification();
		
		Request=given().spec(requestSpecification).body(testData.AddBooksData()); 
	    
    }

    @When("User hit {string} Payload with Post Request")
    public void user_hit_payload_with_post_request(String string) throws Throwable {
    	  response=Request.when().post("/api/v1/Books").then().spec(responseSpecification).extract().response();
  		
    }

    @Then("Books added successfully with status code {int}")
    public void books_added_successfully_with_status_code(Integer int1) throws Throwable {

		 int StatusCode=response.getStatusCode();
		 if(StatusCode==200)
		 {
			System.out.println("Assert True"); 
		 }
		 else
		 {
			 System.out.println("Assert False "); 
		 }
		
		
		
		
    }

    @Then("Verify the response should have {string}")
    public void verify_the_response_should_have(String Key) throws Throwable {

		String ResponseInString=response.asString();
		JsonPath jsonpath=new JsonPath(ResponseInString);
		int id =jsonpath.getInt(Key);
		
		System.out.println(id);
		
    }


}
