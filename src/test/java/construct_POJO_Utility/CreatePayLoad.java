package construct_POJO_Utility;

import org.testng.annotations.Test;
import java.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreatePayLoad {
	static ReadData readdata;
	SetCustomerPojo customerpojo1;
	SetCustomerPojo customerpojo2;
	SetCustomerPojo customerpojo3;
	SetCustomerPojo customerpojo4;
	SetCustomerPojo customerpojo5;

	public String createJsonCustomer() {
		customerpojo1 = new SetCustomerPojo();
		customerpojo2 = new SetCustomerPojo();
		customerpojo3 = new SetCustomerPojo();
		customerpojo4 = new SetCustomerPojo();
		customerpojo5 = new SetCustomerPojo();
		String customerjsonPayload = null;

		String setValidData[] = ReadData.getDataFromSource();

		// Creating 1st Customer Data
		customerpojo1.setcustomerId(setValidData[0].trim());
		customerpojo1.setcontractId(setValidData[1].trim());
		customerpojo1.setGeozone(setValidData[2].trim());
		customerpojo1.setTeamcode(setValidData[3].trim());
		customerpojo1.setProjectcode(setValidData[4].trim());
		customerpojo1.setBuildduration(setValidData[5].trim());

		// creating 2nd customer data
		customerpojo2.setcustomerId(setValidData[6].trim());
		customerpojo2.setcontractId(setValidData[7].trim());
		customerpojo2.setGeozone(setValidData[8].trim());
		customerpojo2.setTeamcode(setValidData[9].trim());
		customerpojo2.setProjectcode(setValidData[10].trim());
		customerpojo2.setBuildduration(setValidData[11].trim());

		// creating 3rd customer data
		customerpojo3.setcustomerId(setValidData[12].trim());
		customerpojo3.setcontractId(setValidData[13].trim());
		customerpojo3.setGeozone(setValidData[14].trim());
		customerpojo3.setTeamcode(setValidData[15].trim());
		customerpojo3.setProjectcode(setValidData[16].trim());
		customerpojo3.setBuildduration(setValidData[17].trim());

		// Creating 4th customer data
		customerpojo4.setcustomerId(setValidData[18].trim());
		customerpojo4.setcontractId(setValidData[19].trim());
		customerpojo4.setGeozone(setValidData[20].trim());
		customerpojo4.setTeamcode(setValidData[21].trim());
		customerpojo4.setProjectcode(setValidData[22].trim());
		customerpojo4.setBuildduration(setValidData[23].trim());

		// creating 5th customer data
		customerpojo5.setcustomerId(setValidData[24].trim());
		customerpojo5.setcontractId(setValidData[25].trim());
		customerpojo5.setGeozone(setValidData[26].trim());
		customerpojo5.setTeamcode(setValidData[27].trim());
		customerpojo5.setProjectcode(setValidData[28].trim());
		customerpojo5.setBuildduration(setValidData[29].trim());

		// creating the list of all customer data
		List<SetCustomerPojo> listOfCustomerData = new ArrayList<SetCustomerPojo>();
		listOfCustomerData.add(customerpojo1);
		listOfCustomerData.add(customerpojo2);
		listOfCustomerData.add(customerpojo3);
		listOfCustomerData.add(customerpojo4);
		listOfCustomerData.add(customerpojo5);

		// Convert SetCustomerPojo class data to Json Payload as a String
		ObjectMapper mapper = new ObjectMapper();
		try {
			customerjsonPayload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfCustomerData);
			System.out.println(customerjsonPayload);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return customerjsonPayload;

	}
	
	

}
