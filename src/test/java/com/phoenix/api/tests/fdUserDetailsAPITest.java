package com.phoenix.api.tests;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.utils.ConfigManager;
import com.phoenix.api.pojo.loginUserDetails;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
//import static com.api.utils.ConfigManager.*; -- Java 14 arrow fn is introduced
import static com.api.utils.ConfigManager14.*;
@Test
public class fdUserDetailsAPITest {
	// RestAssured
	//ConfigManager configManager= new ConfigManager();--Accessing  static method from ConfigManager class
	Header authToken= new Header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE3Njg5NzAyODJ9.QGGWq9PKYt1vHfzQ63RW9CyfoC95u0Qt0U7gVzAcdnk");
	loginUserDetails userCredential= new loginUserDetails("iamfd", "password");
	public void fdUserDetailsAPITest()  {
		int userID= given()
		//.baseUri("http://64.227.160.186:9000/v1")
		.baseUri(getProprty("BASE_URI"))
				//---> Accessed static method from ConfigManager class
			//Remove- ConfigManager by Static import of package com.api.utils.ConfigManager*.
		
		//.baseUri(ConfigManager.getProprty("BASE_URI"))
		
		.and()
		.contentType(ContentType.JSON)//--> as this request contains get, body gas data in JSON format
		.accept(ContentType.JSON)
		.header(authToken)
		.body(userCredential)
		.when()
		.get("userdetails")//end point name
		.then()
		.statusCode(200)
		.body("message",Matchers.equalToIgnoringCase("Success"))
		.time(Matchers.lessThan(3000L))
		.body("data.id",Matchers.equalTo(4))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/fdUserDetailsResponseSchema.json"))
		.log().all()
		.extract()
		.jsonPath().getInt("data.id");
		System.out.println("User ID = " +userID);
		}

}
