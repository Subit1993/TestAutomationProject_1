package construct_POJO_Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.util.*;

import org.testng.annotations.Test;

public class ReadData {
	static ValidInputData inputData;
	static BufferedReader br = null;

	@Test
	public static String[] getDataFromSource() {
		inputData = new ValidInputData();
		String validInputs = inputData.validInputData();
		List<String> lines = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new StringReader(validInputs))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] linesArray = lines.toArray(new String[0]);
		String csData = lines.toString().replace("[", "").replace("]", "");
		String customerData[] = csData.split(",");
		return customerData;

	}

}