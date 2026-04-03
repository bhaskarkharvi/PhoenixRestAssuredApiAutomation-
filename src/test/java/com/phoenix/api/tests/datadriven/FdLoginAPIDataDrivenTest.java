package com.phoenix.api.tests.datadriven;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import static com.api.utils.ConfigManager.*;
import static com.api.utils.ConfigManager14.*;

import com.api.utils.SpecUtils;
import com.dataproviders.api.bean.UserPOJO;
import com.phoenix.api.pojo.loginUserDetails;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class FdLoginAPIDataDrivenTest {
	

	@Test(description = "Toverify FD user able to login",groups = {"api", "regression", "datadriven"}
			,dataProviderClass=com.dataproviders.DataProviderUtils.class,
			dataProvider="loginAPIDataProvider")//loginAPIDataProvider is method in DataProviderUtils.class
	public void fdLoginAPITest(UserPOJO userPOJO) {
		given()
		.spec(SpecUtils.requestSpec(userPOJO))
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
