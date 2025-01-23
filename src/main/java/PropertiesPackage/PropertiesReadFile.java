package PropertiesPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertiesReadFile {

	public String readData(String key) throws IOException {

		Properties properties = new Properties();

		String FilePath = System.getProperty("user.dir")
				+ "\\src\\main\\resources\\Resources\\EdzterAppData\\EdzterAppText.properties";

		try (FileInputStream fileInput = new FileInputStream(FilePath)) {

			properties.load(fileInput);
		} catch (IOException e) {
			  System.err.println("Error reading properties file: " + e.getMessage());
			 throw e;
		}

		return properties.getProperty(key);

	}

//	public void sentData() throws IOException {
//
//		Properties properties = new Properties();
//
//		// Construct the file path correctly
//		String filePath = System.getProperty("user.dir")
//				+ "\\src\\main\\resources\\Resources\\EdzterAppData\\EdzterAppText.properties";
//
//		FileOutputStream fileOutput = new FileOutputStream(filePath);
//
//		properties.setProperty("ContinueWithSRZ", "Continue with Smart Reading Zone (SRZ)");
//
//		// Write properties to the file
//		properties.store(fileOutput, "Edzter App Properties");
//
//		// Close the file output stream
//		fileOutput.close();
//
//		System.out.println("Property file updated successfully.");
//
//	}	
}
