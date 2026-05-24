package com.phoenix.api.tests.datadriven;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.Constants.Role;
import com.api.request.model.CreateJobPayload;
import com.api.request.model.loginUserDetails;
import com.api.utils.SpecUtils;
import com.dataproviders.api.bean.UserBean;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobApiDBdataDrivenTest {
	

	@Test(description = "Toverify FD user able to create job  using DB data",groups = {"api", "regression", "datadriven"}
			,dataProviderClass=com.dataproviders.DataProviderUtils.class,
			dataProvider="CreateJobAPIDBDataProvider")//loginAPIDataProvider is method in DataProviderUtils.class
	//public void fdLoginAPITest(loginUserDetails loginDetails) {----> Have touse UserBean rather loginDetails
	public void CreateJobAPITest(CreateJobPayload createJobPayload)  {
		given()
		.spec(SpecUtils.requestSpecWithHeader(Role.FD, createJobPayload))//username and password -ConfigManager14 class
		//.body(loginDetails)
		.when()
		.post("/job/create")
		.then()
		.spec(SpecUtils.responseSpec_OK(200))
		.body("message",Matchers.equalToIgnoringCase("Job created successfully. "))
		.body("data.mst_service_location_id", Matchers.equalTo(1))
		.body("data.job_number", Matchers.startsWith("JOB_"))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/createJobAPIresponse.json"));
	}

}
///PhoenixRestAssuredAPIAutomation/src/test/resources/responseSchema/fdLoginResponseSchema.json
