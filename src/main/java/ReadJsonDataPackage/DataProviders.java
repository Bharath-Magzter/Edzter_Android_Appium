package ReadJsonDataPackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	@DataProvider(name = "emailData")
	public Object[][] getEmailData() throws IOException {

		ReadJsonData readJsonData = new ReadJsonData();
		List<HashMap<String, String>> data = readJsonData.getJsonData();

		Object[][] testData = new Object[data.size()][1]; // ✅ Dynamically handle data size
		for (int i = 0; i < data.size(); i++) {
			testData[i][0] = data.get(i);
		}
		return testData;
	}
}
