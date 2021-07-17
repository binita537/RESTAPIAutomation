package com.RESTAPIAutomation.TestData;

import com.RESTAPIAutomation.Payloads.AddBooksPayload;

public class TestData {
	
	
	
	public AddBooksPayload AddBooksData()
	{
		
		AddBooksPayload addbookpayload=new AddBooksPayload();
		
		addbookpayload.setId("100");
		addbookpayload.setTitle("title");
		addbookpayload.setDescription("Description");
		addbookpayload.setPageCount("200");
		addbookpayload.setExcerpt("excerpt");
		addbookpayload.setPublishDate("2021-09-04T08:23:25.162Z");  
		
		return addbookpayload;
		
		
	}
	public AddBooksPayload AddBooksData(String id,String title,String description,String Pagecount,String excerpt,String publishDate)
	{
		
		AddBooksPayload addbookpayload=new AddBooksPayload();
		
		addbookpayload.setId(id);
		addbookpayload.setTitle(title);
		addbookpayload.setDescription(description);
		addbookpayload.setPageCount(Pagecount);
		addbookpayload.setExcerpt(excerpt);
		addbookpayload.setPublishDate(publishDate);  
		
		return addbookpayload;
		
		
	}

}
