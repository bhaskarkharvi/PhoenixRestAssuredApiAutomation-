package com.phoenix.api.tests;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

//import static com.api.utils.ConfigManager.*;
import static com.api.utils.ConfigManager14.*;

import com.api.utils.SpecUtils;
import com.phoenix.api.pojo.loginUserDetails;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class FdLoginAPITest {
	//ConfigManager configManager= new ConfigManager();--> Dont create object. Directly access from static
	loginUserDetails loginDetails= new loginUserDetails("iamfd", "password");//Pojo- Model class
	@Test
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
