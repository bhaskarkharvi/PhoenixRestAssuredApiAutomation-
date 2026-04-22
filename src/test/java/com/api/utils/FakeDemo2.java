package com.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.github.javafaker.Faker;

public class FakeDemo2 {
	private final static  String COUNTRY ="India";
	public static void main(String[] args) {
		Locale locale= new Locale("en-INDIA");
		Faker faker = new Faker(locale);
		String firstName = faker.name().firstName();
		String lastName= faker.name().lastName();
		String mobileNumber= faker.numerify("9986######");
		String mobileNumberAlt= faker.numerify("7829######");
		String emailId = faker.internet().emailAddress();
		String emailIdAlt = faker.internet().emailAddress();
		
		Customer customer = new Customer(firstName, lastName, mobileNumber, mobileNumberAlt, emailIdAlt, emailId);
		System.out.println(customer);
		
		String flat_number= faker.address().buildingNumber();
		String apartment_name= faker.address().streetName();
		String street_name=faker.address().streetName();
		String landmark=faker.address().streetName();
		String area=faker.address().streetAddress();
		String pincode=faker.numerify("576###");
		//String country
		String state=faker.address().state();
		
		CustomerAddress customerAddress= new CustomerAddress(flat_number, apartment_name, street_name, landmark, area, pincode, COUNTRY, state);
		
		System.out.println(customerAddress);
	
		String dop=DateTimeUtil.getTimeWithDaysAgo(10);
		String imeiSerialNumber=faker.numerify("8754###########");
		String imei2=faker.numerify("8754###########");
		String popurl=faker.internet().url();
		int productId= 1;
		int mstModelId=1;
		
		CustomerProduct customerProduct = new CustomerProduct(dop,
				imeiSerialNumber,
				imeiSerialNumber,
				imeiSerialNumber,
				popurl,
				 productId,
				 mstModelId
				);
	System.out.println(customerProduct);
	
	Random random= new Random();
	int problemId = random.nextInt(27)+1;
	String fakeRemark= faker.lorem().sentence(4);
	Problems problems = new Problems(problemId, fakeRemark);
	
	ArrayList<Problems> problemList = new ArrayList<Problems>();
	problemList.add(problems);
	System.out.println(problems);
	
	int mst_service_location_id=0;
	int mst_platform_id =2; 
	int mst_warrenty_status_id=1;
	int mst_oem_id=1;
	
	CreateJobPayload createJobPayload = new CreateJobPayload(mst_service_location_id,  mst_platform_id,  mst_warrenty_status_id,
			 mst_oem_id,  customer,  customerAddress,  customerProduct,
			 problemList);
	
	System.out.println("==================================================================");
	
	System.out.println(createJobPayload);
	}

}
