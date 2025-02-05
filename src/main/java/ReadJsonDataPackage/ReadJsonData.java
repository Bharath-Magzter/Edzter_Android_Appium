package ReadJsonDataPackage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJsonData {

	public List<HashMap<String, String>> getJsonData() throws IOException {

		// Get JSON file path dynamically
		String filePath = System.getProperty("user.dir")
				+ "\\src\\main\\resources\\Resources\\EdzterTestData\\ContinueWithEmailData.json";

		// Read JSON content as String
		String jsonContent = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);

		// Convert JSON to List of HashMaps
		ObjectMapper objectMapper = new ObjectMapper();

		return objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});

	}

}
