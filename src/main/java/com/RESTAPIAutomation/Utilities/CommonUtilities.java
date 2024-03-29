package com.RESTAPIAutomation.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CommonUtilities {
	
	
	
	
	
	 static String ConfigPropertiesFilePath=System.getProperty("user.dir")+"//src//resources//com//RESTAPIAutomation//Data//Config.properties";
	
	 public static RequestSpecification requestspacification;
	 static ResponseSpecification  responsespecification;
	
	
	
	public static  String  getPropertiesFromConfig(String Key) throws IOException
	{
		
		Properties prob=new Properties();
		FileInputStream fis=new FileInputStream(ConfigPropertiesFilePath);		
		prob.load(fis);		 
		return prob.getProperty(Key);	
		
	}   
	
	
	public static RequestSpecification createRequestSpecification() throws Exception
	{
		
		if(requestspacification==null)
		{
		PrintStream printstream=new PrintStream(new FileOutputStream("Logging.txt"));
	 requestspacification= new RequestSpecBuilder().setBaseUri("https://fakerestapi.azurewebsites.net")
			                                           .addFilter(RequestLoggingFilter.logRequestTo(printstream))
			                                           .addFilter(ResponseLoggingFilter.logResponseTo(printstream))
                                                       .setContentType(ContentType.TEXT)
                                                       .setContentType(ContentType.JSON)           
                                                       .build(); 
	 return  requestspacification;
		}
		
		return  requestspacification;
		
	}
	
	
	
	
	public static ResponseSpecification createResponseSpecification() throws Exception
	{
		return responsespecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		
		
	}
	
	
	
	public  static String  getValueFromResponseJsonPath(Response response,String Key)
	{
		
		JsonPath jsonpath=new JsonPath(response.asString());
		
		return  jsonpath.get(Key).toString();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
