package com.phoenix.api.tests;

import org.testng.annotations.Test;

import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager14;
import com.phoenix.api.pojo.CreateJobPayload;
import com.phoenix.api.pojo.Customer;
import com.phoenix.api.pojo.CustomerAddress;
import com.phoenix.api.pojo.CustomerProduct;
import com.phoenix.api.pojo.Problems;

import Constants.Role;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateJobAPITest {
	
	@Test
	public void CreateJobAPITest() {
		
		Customer customer = new Customer("B", "K", "9986998134", "", "bk@gmail.com", "");
		CustomerAddress customerAddress= new CustomerAddress("74", "South road", "Tyne wear square", "Tyne Wear", "Byn", "876980", "India", "Karn");
		CustomerProduct customerProduct = new CustomerProduct("2025-08-19T18:30:00.000Z", "27624085806541", "27624085806544","27624085806544", "2025-08-19T18:30:00.000Z",  3, 3);
		Problems problems= new Problems(4, "Synch issue becoz of batery");
		
		Problems[] problemArray= new Problems[1];
		problemArray[0]=problems;
		CreateJobPayload creatJobPayload= new CreateJobPayload(0, 2, 1, 2, customer, customerAddress, customerProduct, problemArray) ; 
		
		given()
		.basePath(ConfigManager14.getProprty("BASE_URI"))
		.header("Authorization",AuthTokenProvider.getToken(Role.FD))
		.contentType(ContentType.JSON)
		.body(creatJobPayload)
				
		.when()
		.post("/job/create")
		.then()
		.log().all();
		
	}

}
