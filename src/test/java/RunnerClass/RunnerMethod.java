package RunnerClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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

	}

	@Test(groups = { "Regression" })
	public void loginPageRunner() throws IOException {

		loginPageTest = new LoginPageTest(DriverManager.getDriver());
		System.out.println("Testing Login Page...");

		loginPageTest.clickLetStartButton();

		System.out.println("Clicked 'Let's Start' button");

		boolean bannerStatus = loginPageTest.validateLoginPageBanner();

		System.out.println("Banner Validation Status: " + bannerStatus);

		loginPageTest.validateLoginOptions();
		System.out.println("Login Options Validated");

		

	}

	@Test(dependsOnMethods = "loginPageRunner")
	public void continueWithEmailRunner() throws InterruptedException, IOException {

		continueWithEmailTest = new ContinueWithEmailTest(DriverManager.getDriver());
		
		
		continueWithEmailTest.clickContinueWithEmailButton();
		
		continueWithEmailTest.performEmailValidation();

	}

	@AfterTest
	public void serverRunnerStop() {
		serverTest.serverStopTest();
		System.out.println("Server Stopped");

	}

}
