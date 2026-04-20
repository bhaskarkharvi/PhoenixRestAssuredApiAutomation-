package com.phoenix.api.tests;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.Constants.Role;
import com.api.utils.SpecUtils;

import io.restassured.module.jsv.JsonSchemaValidator;

public class FDCountAPItest {
	
	//RestAssured
	@Test(description = "Verify Count API success response", groups = {"api","regression","smoke"})
	public void verifyCountAPIresponse_OK() {
		
					given()
					.spec(SpecUtils.requestSpecWithHeader(Role.FD))
	
					.when()
					.get("dashboard/count")
					.then()
					.spec((SpecUtils.responseSpec_OK(200))
					.body("message", Matchers.equalToIgnoringCase("Success"))

					
					.body("data", Matchers.notNullValue())
					.body("data.size()", Matchers.equalTo(3))
					.body("data.count",Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)))
					.body("data.label",Matchers.everyItem(Matchers.not(Matchers.blankOrNullString())))
					
					.body("data.label",Matchers.containsInAnyOrder("Pending for delivery","Pending for FST assignment","Created today"))
					
					.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/fdCountAPIResponse.json")));

	}
	@Test(description = "Verify Count API unathozrd access ", groups = {"api","regression","smoke"})
	public void invalidAuthTokenTest_401() {
		System.out.println("Invalid Auth Token test");
		given()
		.spec(SpecUtils.requestSpec())
		.when()
		.get("dashboard/count")
		.then()
		.spec(SpecUtils.responseSpec_Text(401))
		;
	}

}
