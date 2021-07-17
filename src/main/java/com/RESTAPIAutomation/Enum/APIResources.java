package com.RESTAPIAutomation.Enum;

public enum APIResources {

	
	 AddBookAPI("/api/v1/Books"),
	 UpdateBookAPI("/api/v1/Books"),
	 GetBookAPI("/api/v1/Books"),
	 DeleteBookAPI("/api/v1/Books");
	
	
	private String Resources;
	
	APIResources(String Resources)
	{
		this.Resources=Resources;
	}
	
	
	public String getResources()
	{
		return Resources;
	}
	
	
}
