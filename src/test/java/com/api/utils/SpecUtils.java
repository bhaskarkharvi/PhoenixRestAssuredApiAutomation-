package com.api.utils;

import static io.restassured.http.ContentType.JSON;

import org.hamcrest.Matchers;

import com.Constants.Role;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecUtils {
	 
	//static method
	
	public static RequestSpecification requestSpec() {
		 RequestSpecification requestSpecification =  new RequestSpecBuilder()
				 .setBaseUri(ConfigManager14.getProprty("BASE_URI"))
				 .setContentType(JSON)
				 .setAccept(JSON)
				 .log(LogDetail.URI)
				 .log(LogDetail.HEADERS)
				 .log(LogDetail.METHOD)
				 .log(LogDetail.BODY)
				 .build();
		 			return requestSpecification;
	}			
	//Method Overloading
	public static RequestSpecification requestSpec(Object payload ) {
		 RequestSpecification requestSpecification =  new RequestSpecBuilder()
				 .setBaseUri(ConfigManager14.getProprty("BASE_URI"))
				 .setContentType(JSON)
				 .setAccept(JSON)
				 .setBody(payload)
				 .log(LogDetail.URI)
				 .log(LogDetail.HEADERS)
				 .log(LogDetail.METHOD)
				 .log(LogDetail.BODY)
				 .build();
		 			return requestSpecification;
	}	
	
	public static RequestSpecification requestSpecWithHeader(Role role) {
		RequestSpecification requestSpecification =  new RequestSpecBuilder()
				 .setBaseUri(ConfigManager14.getProprty("BASE_URI"))
				 .setContentType(JSON)
				 .setAccept(JSON)
				 .addHeader("Authorization", AuthTokenProvider.getToken(role))
				 .log(LogDetail.URI)
				 .log(LogDetail.HEADERS)
				 .log(LogDetail.METHOD)
				 .log(LogDetail.BODY)
				 .build();
		 			return requestSpecification;
		
	}
	public static RequestSpecification requestSpecWithHeader(Role role , Object payload) {
		RequestSpecification requestSpecification =  new RequestSpecBuilder()
				 .setBaseUri(ConfigManager14.getProprty("BASE_URI"))
				 .setContentType(JSON)
				 .setAccept(JSON)
				 .addHeader("Authorization", AuthTokenProvider.getToken(role))
				 .setBody(payload)
				 .log(LogDetail.URI)
				 .log(LogDetail.HEADERS)
				 .log(LogDetail.METHOD)
				 .log(LogDetail.BODY)
				 .build();
		 			return requestSpecification;
		
	}
	public static ResponseSpecification responseSpec_OK(int OKStatusCode) {
	ResponseSpecification responseSpecification	= new ResponseSpecBuilder()
		 .expectStatusCode(OKStatusCode)
		 .expectContentType(JSON)
		 .expectResponseTime(Matchers.lessThan(1500L))
		// .expectBody("message", Matchers.equalToIgnoringCase("Success"))
		 .log(LogDetail.ALL)
		 .build();
		return responseSpecification;
	}
	public static ResponseSpecification responseSpec_JSON(int JSONStatusCode) {
	ResponseSpecification responseSpecification	= new ResponseSpecBuilder()
		 .expectStatusCode(JSONStatusCode)
		 .expectContentType(JSON)
		 .expectResponseTime(Matchers.lessThan(1500L))
		// .expectBody("message", Matchers.equalToIgnoringCase("Success"))
		 .log(LogDetail.ALL)
		 .build();
		return responseSpecification;
	}
	public static ResponseSpecification responseSpec_Text(int FailStatusCode) {
	ResponseSpecification responseSpecification	= new ResponseSpecBuilder()
		 .expectStatusCode(FailStatusCode)
		// .expectContentType(JSON)
		 .expectResponseTime(Matchers.lessThan(1500L))
		// .expectBody("message", Matchers.equalToIgnoringCase("Success"))
		 .log(LogDetail.ALL)
		 .build();
		return responseSpecification;
	}
}
