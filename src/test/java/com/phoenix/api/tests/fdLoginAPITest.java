package com.phoenix.api.tests;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.phoenix.api.pojo.loginUserDetails;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class fdLoginAPITest {
	
	loginUserDetails fdLoginDetails= new loginUserDetails("iamfd", "password");
	@Test
	public void fdLoginAPITest() {
		given()
		.baseUri("http://64.227.160.186:9000/v1")
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
