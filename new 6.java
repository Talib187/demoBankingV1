package com.demoBankingV1.testCases;

import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.mongodb.diagnostics.logging.Logger;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest extends BaseClass {
	@Test
	public void getPost(ITestContext context) {

		logger.info("Base Url Initiated");
		
		RestAssured.baseURI = "https://reqres.in/";
		
		RequestSpecification postReq = RestAssured.given();		
		
		JSONObject requestParam = new JSONObject();
		
		// Response data
		requestParam.put("Name", "Talib");
		requestParam.put("Job", "Engineer Quality Control");
		
		postReq.header("Content-Type", "application/json");
		postReq.body(requestParam.toJSONString());   // will attach above data to the request.
		
        context.setAttribute("requestBody", requestParam.toJSONString());

		
		Response resp = postReq.request(Method.POST, "api/users/6");
		
		// print response in console.
				String resBody =  resp.getBody().asString();
				System.out.println("Response body is : "+resBody);
				 context.setAttribute("responseBody", resBody);
				System.out.println("End of Response body");
				
		       

				
				// Status code Validation
				int statusCode = resp.getStatusCode();
				System.out.println("Status code is: "+ statusCode);
				org.testng.Assert.assertEquals(statusCode, 201);
				
				// Status Line verification
				
				String statusLine = resp.getStatusLine();
				System.out.println("Status Line is: " +statusLine);
				org.testng.Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
				
				 String successCode = resp.jsonPath().get("SuccessCode");
				 System.out.println("Success code is: "+ successCode);
			//	 Assert.assertEquals(successCode, "OPERATION_SUCCESS");
				 
				 String name = resp.jsonPath().get("Job");
				 System.out.println(name);
				 
				 System.out.println("Response=>" + resp.prettyPrint());
	}
	
	
}
