package testCase;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import Utility.RandomDataGeneration;

import io.restassured.response.Response;
import testBase.BaseTestCaseClass;

public class TC001_VerifyStatus extends BaseTestCaseClass {
	
    //Verify after post call Status code is 200
	
	public void verifyAccountRegistration(){
		int statusCode = 200;
		Response resp = setUpPostCall();
		int actualStatusCode = resp.statusCode();
		Assert.assertEquals(actualStatusCode, statusCode, "Check the status code");
		
	}

}
