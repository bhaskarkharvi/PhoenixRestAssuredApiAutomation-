package com.phoenix.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.testng.annotations.Test;

import com.Constants.Role;
import com.api.utils.SpecUtils;

import io.restassured.module.jsv.JsonSchemaValidator;

public class FdUserDetailsAPITest {
	
	@Test(description = "FD user detail success test",groups = {"api","regression","smoke"})
	public void fdUserDetailsAPISuccessTest_OK()  {
	//	loginUserDetails loginDetails= new loginUserDetails("iamfd", "password");
		given()
		//.spec(SpecUtils.requestSpec(loginDetails) - mistake- instead of header called this
		//need to create a method to handle header path in SpecUtils.java
		.spec(SpecUtils.requestSpecWithHeader(Role.FD))
		.when()
		.get("userdetails")
		.then()
		.spec(SpecUtils.responseSpec_OK(200))
		.body("message", equalToIgnoringCase("success"))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/fdUserDetailsResponseSchema.json"));
	}
	@Test(description = "FD user detail un authorized(401) test",groups = {"api","regression","smoke"})
	public void fdUserDetailsAPIfailureTest_401()  {
			given()
			.spec(SpecUtils.requestSpecWithHeader(Role.FD))
			.when()
			.get("userdetails")
			.then()
			.spec(SpecUtils.responseSpec_Text(401));
			//.body("404")
			//.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/fdUserDetailsResponseSchema.json"));
		}

}
