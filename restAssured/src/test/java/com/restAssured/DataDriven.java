package com.restAssured;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriven {

	//Data inside method itself(hardcoding)

	/*	@Test 
	void registerNewUser()
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1"; 
		RequestSpecification httpRequest = 	RestAssured.given();

		JSONObject requestParams = new JSONObject(); 
		requestParams.put("name","fname"); 
		requestParams.put("salary", "100000"); 
		requestParams.put("age","30");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		Response res = httpRequest.request(Method.POST,"/create");

		System.out.println(res.asString()); 

	}*/

	//With Data provider,and hard coding.

	/*@Test(dataProvider = "dataSupplier")
	void registerNewUser(String name, String salary, String age)
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1"; 
		RequestSpecification httpRequest = 	RestAssured.given();

		JSONObject requestParams = new JSONObject(); 
		requestParams.put("name",name); 
		requestParams.put("salary", salary); 
		requestParams.put("age",age);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		Response res = httpRequest.request(Method.POST,"/create");

		System.out.println(res.asString()); 

	}

	@DataProvider(name= "dataSupplier")
		String [][] provideData() {
		String [][] data = {{"name1","10000","15"},{"name2","20000","25"},{"name3","30000","35"}};
		return data;
	}*/

	//With excel and dataprovider

	@Test(dataProvider = "dataSupplier")
	void registerNewUser(String name, String salary, String age)
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1"; 
		RequestSpecification httpRequest = 	RestAssured.given();

		JSONObject requestParams = new JSONObject(); 
		requestParams.put("name",name); 
		requestParams.put("salary", salary); 
		requestParams.put("age",age);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		Response res = httpRequest.request(Method.POST,"/create");

		System.out.println(res.asString()); 

	}

	@DataProvider(name= "dataSupplier")
	String [][] provideData() throws IOException {
		String path = System.getProperty("user.dir")+"/InputData.xlsx";
		int rowCount = ExcelRead.rowCount(path, "Sheet1");
		int columnCount = ExcelRead.columCount(path,"Sheet1",1);
		String [][] data = new String[rowCount][columnCount];

		for(int row =1;row<=rowCount;row++) {
			for( int column =0; column<columnCount;column++) {
				data[row -1][column] = ExcelRead.fethCellData(path, "Sheet1", rowCount, columnCount);
			}
		}
		return data;
	}
}
