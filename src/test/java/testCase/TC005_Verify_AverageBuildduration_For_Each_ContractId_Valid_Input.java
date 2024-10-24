package testCase;

import construct_POJO_Utility.CreatePayLoad;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import testBase.BaseTestCaseClass;
import java.util.*;

import org.testng.annotations.Test;

public class TC005_Verify_AverageBuildduration_For_Each_ContractId_Valid_Input extends BaseTestCaseClass {
//This Test case is to validate with the Valid Input String parameters that User should able to find the 
	// CustomerId as distinct for each ContractID
	// It means CustomerID should not be duplicated but contractID may be duplicated

	CreatePayLoad createpayload = null;
	JsonPath js = null;

	@Test
	public void verifyDistinctCustIDMappedToContractID() {
		createpayload = new CreatePayLoad();
		String responsePayload = createpayload.createJsonCustomer().toString();

		js = new JsonPath(responsePayload);
		
        //US_EAST
		String geoZoneValueUS_EAST = js.getString("geozone[0]");
		String BuilDurationValueUS_EAST = js.getString("buildduration[0]").replace("s", "");
		int buildDuration = Integer.parseInt(BuilDurationValueUS_EAST);
		System.out.println("Average Build Duration for US_EAST" + geoZoneValueUS_EAST + " : " + BuilDurationValueUS_EAST);
		Assert.assertEquals(buildDuration, 3445);
		
		//US_WEST
		String geoZoneUS_WEST = js.getString("geozone[1]");
		String BuilDurationValueUS_WEST1 = js.getString("buildduration[1]").replace("s", "");
		int buildDuration_US_West_1 = Integer.parseInt(BuilDurationValueUS_WEST1);
		String BuilDurationValueUS_WEST2 = js.getString("buildduration[3]").replace("s", "");
		int buildDuration_US_West_2 = Integer.parseInt(BuilDurationValueUS_WEST2);
		int avg_BuildDuration_US_West = (buildDuration_US_West_1 + buildDuration_US_West_2)/2;
		System.out.println("Average Build Duration for US_WEST" + geoZoneUS_WEST + " : " + avg_BuildDuration_US_West);
		Assert.assertEquals(avg_BuildDuration_US_West, 2216);
		
		//EA_WEST
		String geoZoneEU_WEST = js.getString("geozone[1]");
		String BuilDurationValueEU_WESTT1 = js.getString("buildduration[2]").replace("s", "");
		int buildDuration_EU_WEST_1 = Integer.parseInt(BuilDurationValueEU_WESTT1);
		String BuilDurationValueEU_WEST2 = js.getString("buildduration[4]").replace("s", "");
		int buildDuration_EU_WEST = Integer.parseInt(BuilDurationValueEU_WEST2);
		int avg_BuildDuration_EU_WEST = (buildDuration_EU_WEST_1 + buildDuration_EU_WEST)/2;
		System.out.println("Average Build Duration for EU_WEST" + geoZoneEU_WEST + " : " + avg_BuildDuration_EU_WEST);
		Assert.assertEquals(avg_BuildDuration_EU_WEST, 4222);
		
		// Hence we can put Assertion check for each GeoZoneID howmany CustomerID
		// uniquley spotted
		// for GeoZone us_east -> 1 Unique CustomerID
		// for GeoZone us_west -> 2 unique CustomerID
		// for GeoZone eu_west -> 2 unique CustomerID

	}

}
