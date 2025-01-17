package ServerPackage;

import java.io.File;

import DriverPackage.DriverManager;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ServerClass extends ServerAbstract {

	AppiumDriverLocalService server;

	DriverManager driverManager;

	@Override
	public void serverStart() {
		server = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Bharath V\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		server.start();

		driverManager = new DriverManager();
		driverManager.driverLunch();
	}

	@Override
	public void serverStop() {

		driverManager.driverQuit();
		server.stop();

	}

}
