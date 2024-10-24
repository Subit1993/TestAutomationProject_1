package Utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGeneration {
	
	public String ranDomEmailString() {

		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}

	public String ranDomFirstNameString() {

		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}

	public String ranDomLastNameString() {

		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}

	public String ranDomPhoneNumString() {

		String generatedPhoneNum = RandomStringUtils.randomNumeric(10);
		return generatedPhoneNum;
	}
	public String ranDomPassword() {

		String generatedString = RandomStringUtils.randomAlphabetic(6);
		String generatedNum = RandomStringUtils.randomNumeric(5);
		return generatedString+"@"+generatedNum;
	}

}
