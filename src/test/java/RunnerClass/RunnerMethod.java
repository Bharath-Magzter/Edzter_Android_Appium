package RunnerClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ContinueWithEmailTestPackage.ContinueWithEmailTest;
import DriverPackage.DriverManager;
import LoginPageTestPackage.LoginPageTest;
import ReadJsonDataPackage.DataProviders;
import ReadJsonDataPackage.ReadJsonData;
import ServerTestPackage.ServerTest;

public class RunnerMethod extends ReadJsonData {

	ServerTest serverTest = new ServerTest();

	LoginPageTest loginPageTest;

	ContinueWithEmailTest continueWithEmailTest;

	@BeforeTest(groups = { "Regression" })
	public void serverRunnerStart() {
		serverTest.serverStartTest();
		System.out.println("Server Started");
		continueWithEmailTest = new ContinueWithEmailTest(DriverManager.getDriver());
	}

	@Test(groups = { "Regression" })
	public void loginPageRunner() throws IOException {

		loginPageTest = new LoginPageTest(DriverManager.getDriver());

		loginPageTest.loginPageTestMethods();

	}

	@Test(dependsOnMethods = "loginPageRunner", priority = 1)
	public void continueWithEmailRunner() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		continueWithEmailTest.continueWithEmailTestMethods();
	}

	@Test(dependsOnMethods = "loginPageRunner",  dataProvider = "emailData",dataProviderClass = DataProviders.class, priority = 2) //
	public void continueWithEmailRunner(HashMap<String, String> emailInputValues)
			throws InterruptedException, IOException {

		continueWithEmailTest.continueWithEmailTestMethods(emailInputValues);

	}

	@AfterTest
	public void serverRunnerStop() {
		serverTest.serverStopTest();
		System.out.println("Server Stopped");

	}

}
