package DriverPackage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverManager {

	private static AppiumDriver driver;

	public void driverLaunch() {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setApp(System.getProperty("user.dir") + "/src/main/resources/Resources/edzter_3_0_2_50.apk");

		options.setDeviceName("realme 5 Pro");

		try {
			driver = new AppiumDriver(new URI("http://127.0.0.1:4723").toURL(), options);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver Lunch issue " + e.getMessage());
		}

	}

	public void driverQuit() {

		if (driver != null) {

			driver.quit();
		}
	}

	public static AppiumDriver getDriver() {

		return driver;
	}

}
