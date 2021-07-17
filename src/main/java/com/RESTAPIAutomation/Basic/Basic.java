package com.RESTAPIAutomation.Basic;

import static  io.restassured.RestAssured.*;

import java.io.IOException;

import com.RESTAPIAutomation.Payloads.AddBooksPayload;
import com.RESTAPIAutomation.Utilities.CommonUtilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class Basic {
	
	
	
	
	
	public static void main(String args[]) throws IOException
	{
	
		
		CommonUtilities commonUtilities=new CommonUtilities();
	
		RestAssured.baseURI="https://fakerestapi.azurewebsites.net";  
		
		
		String payload="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
	
	
	
		AddBooksPayload addbookpayload=new AddBooksPayload();
	
		
		addbookpayload.setId("100");
		addbookpayload.setTitle("title");
		addbookpayload.setDescription("Description");
		addbookpayload.setPageCount("200");
		addbookpayload.setExcerpt("excerpt");
		addbookpayload.setPublishDate("2021-09-04T08:23:25.162Z"); 
		
		
		
		
		
		String Res=given().log().all().header("accept","text/plain").header("Content-Type","application/json").
		body(addbookpayload).
	    when().post("/api/v1/Books").
	    then().log().all().assertThat().statusCode(200).extract().response().asString();  
		
		
		
		RequestSpecification requestspacification= new RequestSpecBuilder().setBaseUri(commonUtilities.getPropertiesFromConfig("BaseUrl"))
				                          .setContentType(ContentType.TEXT)
				                          .setContentType(ContentType.JSON)
				                          .build(); 
		
		 ResponseSpecification responsespecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		
		 RequestSpecification Request=given().spec(requestspacification).body(payload); 
		    
		      Response  Response   =  Request.when().post("/api/v1/Books")
		      .then().spec(responsespecification).extract().response();
		
		
		
		
		      
		
		
		System.out.println(Res);  
		
		
		
		
		
		
		
		
		
	
	
	
	
	}
}