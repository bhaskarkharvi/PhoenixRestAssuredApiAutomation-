package com.api.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.github.javafaker.Faker;


public class FakeDataGenerator {
	//Utility class for fake data
	
	private FakeDataGenerator() {};// As utility classit stopstocreate object oif this class
	
	private final static  String COUNTRY ="India";
	private static Locale locale= new Locale("en-INDIA");
	private static Faker faker = new Faker(locale);
	private static Random RANDOM= new Random();
	private final static  int MST_SERVICE_LOCATION_ID=0;
	private final static  int  MST_PLATFORM_ID  =2;
	private final static  int MST_WARRENTY_STATUS_ID=1;
	private final static  int MST_OEM_ID=1;
	private final static  int PRODUCT_ID= 1;
	private final static  int MST_MODEL_ID=1;
	//private final static int PROBLEM_ID = random.nextInt(27)+1;
	
	private final static int validProblemId[]= {1,2,3,4,5,6,7,8,9,10,11,12,15,16,17,19,20,22,24,26,27,28,29};
	
	public static CreateJobPayload generateFakeCreateJobData() {
		
		Customer customer=generateFakeCustomerData();
		 
		CustomerAddress customerAddress = generateFakeCustomerAddressData();
		
		CustomerProduct customerProduct= generateFakeCustomerProductData();
		
		List<Problems> problemsListData =  generateFakeProblemListData();
		
		CreateJobPayload createJobPayload = new CreateJobPayload(MST_SERVICE_LOCATION_ID, MST_PLATFORM_ID, MST_WARRENTY_STATUS_ID, MST_OEM_ID, customer, customerAddress, customerProduct, problemsListData);		
				return createJobPayload;
		
	}
	public static Iterator<CreateJobPayload> generateFakeCreateJobData(int count) {
		
		List<CreateJobPayload> payloadList= new ArrayList<CreateJobPayload>();
		for(int i=1;i<=count;i++) {
		
		Customer customer=generateFakeCustomerData();
		 
		CustomerAddress customerAddress = generateFakeCustomerAddressData();
		
		CustomerProduct customerProduct= generateFakeCustomerProductData();
		
		List<Problems> problemsListData =  generateFakeProblemListData();
		
		CreateJobPayload createJobPayload = new CreateJobPayload(MST_SERVICE_LOCATION_ID, MST_PLATFORM_ID, MST_WARRENTY_STATUS_ID, MST_OEM_ID, customer, customerAddress, customerProduct, problemsListData);		
		payloadList.add(createJobPayload);
		
		}
		
		return payloadList.iterator();// as there are many createDataPayload it has to be iterated and returned
		
	}
	private static Customer generateFakeCustomerData() {
		String firstName = faker.name().firstName();
		String lastName= faker.name().lastName();
		String mobileNumber= faker.numerify("9986######");
		String mobileNumberAlt= faker.numerify("7829######");
		String emailId = faker.internet().emailAddress();
		String emailIdAlt = faker.internet().emailAddress();
		
		Customer customer = new Customer(firstName, lastName, mobileNumber, mobileNumberAlt, emailIdAlt, emailId);
		
		return customer;
	}
	private static CustomerAddress generateFakeCustomerAddressData() {
		String flat_number= faker.address().buildingNumber();
		String apartment_name= faker.address().streetName();
		String street_name=faker.address().streetName();
		String landmark=faker.address().streetName();
		String area=faker.address().streetAddress();
		String pincode=faker.numerify("576###");
		//String country
		String state=faker.address().state();
		
		CustomerAddress customerAddress= new CustomerAddress(flat_number, apartment_name, street_name, landmark, area, pincode, COUNTRY, state);
		
		return customerAddress;
	}
	
	private static CustomerProduct generateFakeCustomerProductData() {
		String dop=DateTimeUtil.getTimeWithDaysAgo(10);
		String imeiSerialNumber=faker.numerify("8754###########");
		String imei2=faker.numerify("8754###########");
		String popurl=faker.internet().url();
		
		CustomerProduct customerProduct = new CustomerProduct(dop,
				imeiSerialNumber,
				imeiSerialNumber,
				imeiSerialNumber,
				popurl,
				 PRODUCT_ID,
				 MST_MODEL_ID
				);
		return customerProduct;
		
	}
		
	
		private static List<Problems> generateFakeProblemListData() {
			
			Problems problems;//Object/variable must be out side of for loop
			int problemIndex;
			String fakeRemark;
			List<Problems> problemList = new ArrayList<Problems>();
			int count = RANDOM.nextInt(2)+1;//Max 3 problesm can be added so, 0-3  can be as  2+1
			
			for(int i=1;i<=3;i++) {//Generating problem ID and adding it to list.
				
			 problemIndex = RANDOM.nextInt(validProblemId.length);
			 fakeRemark= faker.lorem().sentence(4);
			 problems = new Problems(validProblemId[problemIndex], fakeRemark);
			 problemList.add(problems);
			}
			return problemList;
		
		}

	


}
