package com.restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//test case 1
public class TC001 {

	@Test
	void weatherStatus() {

		//RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification request = RestAssured.given();

		Response response = request.request(Method.GET, "/Mudhol");

		String body = response.asString();
		System.out.println(body);
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);

		//Indidual headers
		//String Header1 = response.contentType();
		//System.out.println(Header1);

		//String Header2 = response.header("Content-Type");
		//System.out.println(Header2);

		//System.out.println(response.header("Host-Header"));
		
		//all headers
		System.out.println(response.getHeaders());
				//System.out.println(response.headers());
		
		for(Header header : response.headers()) {
			
			System.out.println("Key is "+ header.getName() +" value is "+ header.getValue());
			
		}
		
		//response attributes
		JsonPath jsonPath = response.jsonPath();
		String abc = jsonPath.get("Temperature");
		System.out.println(abc);
		
	}
}
