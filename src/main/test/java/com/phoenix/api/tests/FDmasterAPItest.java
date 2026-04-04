package com.phoenix.api.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager14;
import com.api.utils.SpecUtils;

import Constants.Role;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class FDmasterAPItest {
	@Test(description = "Verify FD master details API output", groups = {"api","regression","smoke"})
	//RestAssured
	public void fdMasterDetailsTest() {
		
		given()
		.spec(SpecUtils.requestSpecWithHeader(Role.FD))
		.when()
		.post("master")
		.then()
		.spec(SpecUtils.responseSpec_OK(200))
		.body("message", Matchers.equalToIgnoringCase("Success"))
		.body("data",Matchers.notNullValue())
		//.body("data.size()", Matchers.equalTo(10))
		.body("data",Matchers.hasKey("mst_oem"))
		.body("data.mst_oem.size()",Matchers.greaterThanOrEqualTo(0))
		.body("data",Matchers.hasKey("mst_model"))
		.body("data.mst_oem.size()",Matchers.equalTo(2))
		
		.body("$",Matchers.hasKey("message"))
		.body("$",Matchers.hasKey("data"))
		
		.body("data.mst_oem.id", Matchers.everyItem(Matchers.notNullValue()))
		.body("data.mst_oem.name", Matchers.everyItem(Matchers.notNullValue()))

		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/FDmasterResponseSchema.json"));
		
	}
	@Test(description = "Verify FD master details unathorized output", groups = {"api","regression","smoke"})
	public void fdMasterAPItest401() {
		given()
		.spec(SpecUtils.requestSpecWithHeader(Role.FD))
		.when()
		.post("master")
		.then()
		.spec(SpecUtils.responseSpec_Text(401));
	}

}
