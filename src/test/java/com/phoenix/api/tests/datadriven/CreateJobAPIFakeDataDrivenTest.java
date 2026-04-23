package com.phoenix.api.tests.datadriven;

import static io.restassured.RestAssured.given;

//import java.time.Instant;
//import java.time.temporal.ChronoUnit;  
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Constants.Model;
import com.Constants.OEM;
import com.Constants.Platform;
import com.Constants.Problem;
import com.Constants.Product;
import com.Constants.Role;
import com.Constants.Servicelocation;
import com.Constants.Warranty_Status;
import com.api.request.model.CreateJobPayload;
import com.api.utils.DateTimeUtil;
import com.api.utils.FakeDataGenerator;
import com.api.utils.SpecUtils;
import com.github.javafaker.Faker;

import com.phoenix.api.refactoring.records.Customer;
import com.phoenix.api.refactoring.records.CustomerAddress;
import com.phoenix.api.refactoring.records.CustomerProduct;
import com.phoenix.api.refactoring.records.Problems;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPIFakeDataDrivenTest {
	
	//private CreateJobPayload createJobPayload;
	private final static  String COUNTRY ="India";

	
	@Test(description ="To Verify create job able to create 'In warranty flow' successfully with fake data"
			,groups={"api","csv","faker"},
			dataProviderClass = com.dataproviders.DataProviderUtils.class,
			dataProvider="CreateJobAPIFakerDataProvider" //passed faker data provider for create Job fromFakeDataGenerator class
			)
	
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
