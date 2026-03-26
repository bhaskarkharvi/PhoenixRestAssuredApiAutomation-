package com.phoenix.api.tests;

import org.hamcrest.Matchers;
import org.joda.time.Instant;
import org.testng.annotations.Test;

import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager14;
import com.api.utils.DateTimeUtil;
import com.api.utils.SpecUtils;
import com.phoenix.api.refactoring.records.CreateJobPayload;
import com.phoenix.api.refactoring.records.Customer;
import com.phoenix.api.refactoring.records.CustomerAddress;
import com.phoenix.api.refactoring.records.CustomerProduct;
import com.phoenix.api.refactoring.records.Problems;

import Constants.Model;
import Constants.OEM;
import Constants.Platform;
import Constants.Problem;
import Constants.Product;
import Constants.Role;
import Constants.Servicelocation;
import Constants.Warranty_Status;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

//import java.time.Instant;
//import java.time.temporal.ChronoUnit;  
import java.util.ArrayList;
import java.util.List;

public class CreateJobAPITest {
	
	@Test
	public void CreateJobAPITest() {
		
		
		System.out.println();
		System.out.println("______________________________________________________");
		
		//System.out.println(Instant.now().minus(10,ChronoUnit.DAYS)); minus(lon) error
		
		System.out.println("______________________________________________________");
		
		Customer customer = new Customer("B", "K", "9986998134", "", "bk@gmail.com", "");
		CustomerAddress customerAddress= new CustomerAddress("774", "South road 774", "Tyne wear square774", "Blueline circle", "Bhtkl", "576390", "Contry", "AP");
		CustomerProduct customerProduct = new CustomerProduct(DateTimeUtil.getTimeWithDaysAgo(10), "27624085806562", "27624085808532","27624085808532", 
				DateTimeUtil.getTimeWithDaysAgo(10),
				Product.NEXUS_2.getCode(), Model.GALLEXY.getCode());
		
		Problems problems= new Problems(Problem.OVERHEATING.getCode(), "Overheating");
		List<Problems> problemList=new ArrayList<Problems>();
		//Problems[] problemArray= new Problems[1];
		//problemArray[0]=problems;
		problemList.add(problems);
		
		
		CreateJobPayload creatJobPayload= new CreateJobPayload(Servicelocation.SERVICE_LOCATION_A.getCode(), Platform.FRONTDESK.getCode(), Warranty_Status.IN_WARRANTY.getCode(), OEM.GOOGLE.getCode(), customer, customerAddress, customerProduct, problemList) ; 
		
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
