package com.restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002 {
	
	@Test
	void registerCustomer() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestparams = new JSONObject();
		requestparams.put("FirstName", "Neel1");
		requestparams.put("LastName", "Ram");
		requestparams.put("UserName", "NeelRam1");
		requestparams.put("Password", "Neel1234");
		requestparams.put("Email", "NeelR1am@gmail.com");
		
		request.header("Content-Type", "application/json");
		request.body(requestparams.toJSONString());
		
		Response response = request.request(Method.POST,"/register");
		
		System.out.println("response is"+ response.asString());
		
		System.err.println(response.getStatusCode());
		String sab = response.getBody().jsonPath().get("[0].FaultId");
		System.out.println(sab);
	}

}
