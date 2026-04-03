package com.phoenix.api.tests.datadriven;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static com.api.utils.AuthTokenProvider.*;

import com.api.utils.ConfigManager;
import com.api.utils.SpecUtils;
import com.phoenix.api.pojo.loginUserDetails;

import Constants.Role;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
//import static com.api.utils.ConfigManager.*; -- Java 14 arrow fn is introduced
import static com.api.utils.ConfigManager14.*;

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
