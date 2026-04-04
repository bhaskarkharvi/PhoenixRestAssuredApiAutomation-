package com.api.utils;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import com.phoenix.api.pojo.loginUserDetails;

import Constants.Role;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AuthTokenProvider {
	

//WAP to generate token from login and extract, then return token for other classess.
public static String getToken(Role role) {
	//RestAssured
	loginUserDetails userCredential=null;
	if(role==Role.FD) {
		userCredential= new loginUserDetails("iamfd", "password");
	}
	else if (role==Role.SUP) {
		
		userCredential= new loginUserDetails("sup", "password");
	}
	else if (role==Role.ENG) {
		userCredential= new loginUserDetails("eng", "password");
	}
	else if (role==Role.QC) {
		userCredential= new loginUserDetails("qc", "password");
	}
				String authToken= given()
				.baseUri(ConfigManager14.getProprty("BASE_URI"))
				.body(userCredential)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.post("login")
				.then()
				.log()
				.ifValidationFails()
				.statusCode(200)
				.body("message",equalToIgnoringCase("success"))
				.extract()
				.jsonPath()
				.getString("data.token");
				System.out.println();
				System.out.println("*********************token*************************");
				System.out.println("token generated= " +authToken);
				return authToken;
}
}
