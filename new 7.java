package com.demoBankingV1.testCases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.demoBankingV1.utilities.Reporting;
import com.demoBankingV1.utilities.XLUtils;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(Reporting.class)
public class PostRequest {
	@Test
	public void getPost(ITestContext context) throws JSONException, IOException {
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification postReq = RestAssured.given();
		String path = "C:\\Users\\mtali\\eclipse-workspace\\demExtentReport\\src\\test\\java\\API_Testing\\RequestPayload.json";
		String postBody = readJson(path);
		
		String excelPath = "C:\\Users\\mtali\\eclipse-workspace\\demExtentReport\\src\\test\\java\\API_Testing\\JsonExcelData.xlsx";
		
		postReq.header("Content-Type", "application/json");

		JSONObject jsonObj = new JSONObject(postBody);
		jsonObj.put("name", XLUtils.getCellData(excelPath, "Sheet1", 0, 0));
		
		String modifiedJson = jsonObj.toString();
		
		postReq.body(modifiedJson);
		
		Response resp = postReq.request(Method.POST, "api/users/6");
		String resBody = resp.getBody().asString();
		System.out.println("Response body is : " + resBody);
		System.out.println("End of Response body");

		Headers resHeader = resp.getHeaders();

		// Set request and response body as attributes in test context
		context.setAttribute("requestBody", postBody);
		context.setAttribute("responseBody", resBody);
		context.setAttribute("responseHeader", resHeader);
	}

	private String readJson(String path) {
		try {
			return new String(Files.readAllBytes(Paths.get(path)));
		} catch (Exception e) {
			throw new RuntimeException("Error reading JSON file", e);
		}
	}
}
