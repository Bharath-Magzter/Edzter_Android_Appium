package RunnerClass;

import java.io.IOException;

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
import ServerTestPackage.ServerTest;

public class RunnerMethod {

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
//		System.out.println("Testing Login Page...");
//
//		loginPageTest.clickLetStartButton();
//
//		System.out.println("Clicked 'Let's Start' button");
//
//		boolean bannerStatus = loginPageTest.validateLoginPageBanner();
//
//		System.out.println("Banner Validation Status: " + bannerStatus);
//
//		loginPageTest.validateLoginOptions();
//		System.out.println("Login Options Validated");

	}

	@Test(dependsOnMethods = "loginPageRunner", priority = 1)
	public void continueWithEmailRunner() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		continueWithEmailTest.continueWithEmailTestMethods();
	}

	@Test(dependsOnMethods = "loginPageRunner", dataProvider = "loginData", priority = 2) //
	public void continueWithEmailRunner(String emailInputValues) throws InterruptedException, IOException {

		continueWithEmailTest.continueWithEmailTestMethods(emailInputValues);

	}

	@AfterTest
	public void serverRunnerStop() {
		serverTest.serverStopTest();
		System.out.println("Server Stopped");

	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {

		return new Object[][] { { "3456789" }, { "fudfidf#$%$^@gmail.com" }, {"2334545678@#$%^@gmail.com"}

		};
	}

}
