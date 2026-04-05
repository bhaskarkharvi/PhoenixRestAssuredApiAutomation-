package com.phoenix.api.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.utils.SpecUtils;
import com.phoenix.api.pojo.loginUserDetails;

import io.restassured.module.jsv.JsonSchemaValidator;

public class FdLoginAPITest {
	
	loginUserDetails loginDetails;
	@BeforeMethod(description = "Login API Payload")
	public void setUp() {
		
		 loginDetails= new loginUserDetails("iamfd", "password");
	}
	//ConfigManager configManager= new ConfigManager();--> Dont create object. Directly access from static
	//loginUserDetails loginDetails= new loginUserDetails("iamfd", "password");//This is payload
	//create a method setup()  and call before test
	
	
	@Test(description = "Toverify FD user able to login",groups = {"api", "regression", "smoke"})
	public void fdLoginAPITest() throws IOException {
		given()
		.spec(SpecUtils.requestSpec(loginDetails))
		//.body(loginDetails)
		.when()
		.post("login") 
		.then().spec(SpecUtils.responseSpec_OK(200))
		.body("message", Matchers.equalToIgnoringCase("Success"))
		.and()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/fdLoginResponseSchema.json"))

		;
	}

}
///PhoenixRestAssuredAPIAutomation/src/test/resources/responseSchema/fdLoginResponseSchema.json
