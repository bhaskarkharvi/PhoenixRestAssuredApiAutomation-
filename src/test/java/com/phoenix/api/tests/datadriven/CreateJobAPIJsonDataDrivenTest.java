package com.phoenix.api.tests.datadriven;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.Constants.Role;
import com.api.request.model.CreateJobPayload;
import com.api.utils.SpecUtils;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPIJsonDataDrivenTest {
	
	//CreateJobPayload creatJobPayload;
		
	@Test(description ="To Verify create job able to create 'In warranty flow' successfully",
			groups={"api","regression","datadriven"}
	,dataProviderClass=com.dataproviders.DataProviderUtils.class
			,dataProvider="createJobAPIJSONDataProvider")
	
	public void CreateJobAPITest(CreateJobPayload createJobPayload) {
				
		given()
		.spec(SpecUtils.requestSpecWithHeader(Role.FD, createJobPayload))
		//.body(creatJobPayload)
				
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
