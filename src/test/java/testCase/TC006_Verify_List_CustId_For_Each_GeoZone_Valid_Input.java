package testCase;

import construct_POJO_Utility.CreatePayLoad;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import testBase.BaseTestCaseClass;
import java.util.*;

import org.testng.annotations.Test;

public class TC006_Verify_List_CustId_For_Each_GeoZone_Valid_Input extends BaseTestCaseClass{
//This Test case is to validate with the Valid Input String parameters that User should able to find the 
	//CustomerId as distinct for each ContractID
	//It means CustomerID should not be duplicated but contractID may be duplicated
	
	CreatePayLoad createpayload = null;
	JsonPath js = null;
	@Test
	public void verifyDistinctCustIDMappedToContractID() {
		createpayload = new CreatePayLoad();
		String responsePayload = createpayload.createJsonCustomer().toString();
		String geoZoneValue = null;
		String customerIdValue = null;
		js = new JsonPath(responsePayload);
		//1st find all the contractID
		int totalgeoZone = js.getInt("contractId.size()");
		int totalCustomerId = js.getInt("customerId.size()");
		System.out.println("Print all the unique CustomerIds for each ContractId");
		for(int i = 0; i<totalgeoZone ; i++) {
			geoZoneValue = js.getString("contractId["+i+"]");
			customerIdValue = js.getString("customerId["+i+"]");
			System.out.println(geoZoneValue + " : " + customerIdValue);
	
		}
		//Hence we can put Assertion check for each ContractID howmany CustomerID uniquley spotted
		// for ContractID 2345 -> 3 Unique CustomerID
		//for ContractID 2346 -> 2 unique CustomerID
		
		
		
		
	}

}
