package com.phoenix.api.tests;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

//import static com.api.utils.ConfigManager.*;
import static com.api.utils.ConfigManager14.*;
import com.phoenix.api.pojo.loginUserDetails;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class fdLoginAPITest {
	//ConfigManager configManager= new ConfigManager();--> Dont create object. Directly access from static
	loginUserDetails fdLoginDetails= new loginUserDetails("iamfd", "password");//Pojo- Model class
	@Test
	public void fdLoginAPITest() throws IOException {
		given()
		//.baseUri("http://64.227.160.186:9000/v1")
		//.baseUri(configManager.getProprty("BASE_URI"))
		.baseUri(getProprty("BASE_URI"))//---> Accessing  static method fromConfigManager class
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(fdLoginDetails)
		
		.log().uri()
		.log().body()
		.log().method()
		.when()
		.post("login") 
		.then()
		.statusCode(200)
		.body("message", Matchers.equalToIgnoringCase("Success"))
		.time(Matchers.lessThan(2000L))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/fdLoginResponseSchema.json"))
		.log().all();
	}

}
///PhoenixRestAssuredAPIAutomation/src/test/resources/responseSchema/fdLoginResponseSchema.json
