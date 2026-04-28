package com.phoenix.api.tests.datadriven;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.request.model.loginUserDetails;
import com.api.utils.SpecUtils;
import com.dataproviders.api.bean.UserBean;

import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginAPIExcelPoijiDataDrivenTest {
	

	@Test(description = "Toverify FD user able to login via Excel  Poiji data",groups = {"api", "regression", "datadriven"}
			,dataProviderClass=com.dataproviders.DataProviderUtils.class,
			dataProvider="loginAPIExcelPoijiDataProvider")//loginAPIDataProvider is method in DataProviderUtils.class
	//public void fdLoginAPITest(loginUserDetails loginDetails) {----> Have touse UserBean rather loginDetails
		public void fdLoginAPITest(UserBean userBean) {
		given()
		.spec(SpecUtils.requestSpec(userBean))//username and password -ConfigManager14 class
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
