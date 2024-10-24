package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import construct_POJO_Utility.CreatePayLoad;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import testBase.BaseTestCaseClass;

public class TC002_VerifyCustomerData extends BaseTestCaseClass {
	// Here I am taking the existing Json Input payload to perform the validation as
	// I dont have the actual
	// Response Payload
	// Verify after post call in the response all the Json objects are coming as the
	// expected counts
	// as given in requirement, e.g: There should be total 5 CustomerID, 5
	// ContractID, 5 geoZone,5 projectcode
	// 5 teamcode and 5 buildduration
	CreatePayLoad createpayload = null;
	JsonPath js = null;

	@Test(priority = 0)
	public void verifyTotalCustomerFields() {
		createpayload = new CreatePayLoad();
		String responsePayload = createpayload.createJsonCustomer().toString();
		int ActualTotalCustomerID = 5;
		int ActualTotalContractID = 5;
		int ActualTotalgeozone = 5;
		int ActualTotalteamcode = 5;
		int ActualTotalprojectcode = 5;
		int ActualTotalbuildduration = 5;
		//System.out.println(responsePayload);
		js = new JsonPath(responsePayload);
		int totalCustomerId = js.getInt("customerId.size()");
		int totalContractId = js.getInt("contractId.size()");
		int totalgeozone = js.getInt("geozone.size()");
		int totalteamcode = js.getInt("teamcode.size()");
		int totalprojectcode = js.getInt("projectcode.size()");
		int totalbuildduration = js.getInt("buildduration.size()");
		Assert.assertEquals(totalCustomerId, ActualTotalCustomerID);
		Assert.assertEquals(totalContractId, ActualTotalContractID);
		Assert.assertEquals(totalgeozone, ActualTotalgeozone);
		Assert.assertEquals(totalteamcode, ActualTotalteamcode);
		Assert.assertEquals(totalprojectcode, ActualTotalprojectcode);
		Assert.assertEquals(totalbuildduration, ActualTotalbuildduration);
	
	}
	@Test(priority = 1)
	public void verifyCuatomerIdFieldValues() {
		createpayload = new CreatePayLoad();
		String responsePayload = createpayload.createJsonCustomer().toString();
		js = new JsonPath(responsePayload);
		int totalCustomerId = js.getInt("customerId.size()");
		for(int i = 0; i<totalCustomerId; i++) {
			String customerIdValues = js.getString("customerId["+i+"]");
			System.out.println(customerIdValues);
			
		}
		
	}
	@Test(priority = 2)
	public void verifyContractIdFieldValues() {
		createpayload = new CreatePayLoad();
		String responsePayload = createpayload.createJsonCustomer().toString();
		js = new JsonPath(responsePayload);
		int totalContractId = js.getInt("contractId.size()");
		for(int i = 0; i<totalContractId; i++) {
			String contractIdValues = js.getString("contractId["+i+"]");
			System.out.println(contractIdValues);
			
		}
		
	}
	@Test(priority = 3)
	public void verifygeoZoneFieldValues() {
		createpayload = new CreatePayLoad();
		String responsePayload = createpayload.createJsonCustomer().toString();
		js = new JsonPath(responsePayload);
		int totalgeozone = js.getInt("geozone.size()");
		for(int i = 0; i<totalgeozone; i++) {
			String totalgeozoneValues = js.getString("geozone["+i+"]");
			System.out.println(totalgeozoneValues);
			
		}
		
	}
	@Test(priority = 4)
	public void verifyteamcodeFieldValues() {
		createpayload = new CreatePayLoad();
		String responsePayload = createpayload.createJsonCustomer().toString();
		js = new JsonPath(responsePayload);
		int totalteamcode = js.getInt("teamcode.size()");
		for(int i = 0; i<totalteamcode; i++) {
			String teamcodeValues = js.getString("teamcode["+i+"]");
			System.out.println(teamcodeValues);
			
		}
		
	}
	@Test(priority = 5)
	public void verifyprojectCodeFieldValues() {
		createpayload = new CreatePayLoad();
		String responsePayload = createpayload.createJsonCustomer().toString();
		js = new JsonPath(responsePayload);
		int totalprojectcode = js.getInt("projectcode.size()");
		for(int i = 0; i<totalprojectcode; i++) {
			String projectcodeValues = js.getString("projectcode["+i+"]");
			System.out.println(projectcodeValues);
			
		}
		
	}
	@Test(priority = 6)
	public void verifybuilddurationFieldValues() {
		createpayload = new CreatePayLoad();
		String responsePayload = createpayload.createJsonCustomer().toString();
		js = new JsonPath(responsePayload);
		int totalbuildduration = js.getInt("buildduration.size()");
		for(int i = 0; i<totalbuildduration; i++) {
			String builddurationValues = js.getString("buildduration["+i+"]");
			System.out.println(builddurationValues);
			
		}
		
	}

}
