package com.phoenix.api.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager14;
import com.api.utils.SpecUtils;
import com.phoenix.api.refactoring.records.CreateJobPayload;
import com.phoenix.api.refactoring.records.Customer;
import com.phoenix.api.refactoring.records.CustomerAddress;
import com.phoenix.api.refactoring.records.CustomerProduct;
import com.phoenix.api.refactoring.records.Problems;

import Constants.Role;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class CreateJobAPITest {
	
	@Test
	public void CreateJobAPITest() {
		
		Customer customer = new Customer("B", "K", "9986998134", "", "bk@gmail.com", "");
		CustomerAddress customerAddress= new CustomerAddress("774", "South road 774", "Tyne wear square774", "Blueline circle", "Bhtkl", "576390", "Contry", "AP");
		CustomerProduct customerProduct = new CustomerProduct("2025-08-19T18:30:00.000Z", "27624085806592", "27624085808590","27624085808590", "2025-08-19T18:30:00.000Z",  3, 3);
		
		Problems problems= new Problems(4, "Synch issue becoz of batery");
		List<Problems> problemList=new ArrayList<Problems>();
		//Problems[] problemArray= new Problems[1];
		//problemArray[0]=problems;
		problemList.add(problems);
		
		
		CreateJobPayload creatJobPayload= new CreateJobPayload(0, 2, 1, 2, customer, customerAddress, customerProduct, problemList) ; 
		
		given()
		.spec(SpecUtils.requestSpecWithHeader(Role.FD, creatJobPayload))
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
