package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import construct_POJO_Utility.CreatePayLoad;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTestCaseClass {
	RequestSpecification request = null;
	CreatePayLoad createpayload = null;
	Response response = null;
	
	/* This Method is to validate that if the POST Method call successfully triggered
	 * And the response should be captured to a Variable which can be used for validating
	 * the test cases later in Test Case Package
	 */
	
	
	public Response setUpPostCall()  {
		createpayload = new CreatePayLoad();
		request = RestAssured.given();
		//Specify URL
		request.baseUri("url");
		//specify content-type
		request.contentType(ContentType.JSON);
		//Specify payload in body
		request.body(createpayload.createJsonCustomer());
		//Trigger Post  Request
		response = request.post("path");
		return response;
	}

	
	public void tearDown() {
		
	}

}
