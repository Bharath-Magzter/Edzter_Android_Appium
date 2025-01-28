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
		System.out.println("App Launched");

		loginPageTest.letStartbtn_Method();

		System.out.println("Landed Login Page");
		
		loginPageTest.loginPageBanner_Method();
		
		System.out.println("Login Page banner validation");

		loginPageTest.loginPageOptions_Method();

	}
	
	
	
	@Test (dependsOnMethods =  "loginPageRunner")
	public void continueWithEmailRunner() throws InterruptedException {
		
		continueWithEmailTest = new ContinueWithEmailTest(DriverManager.getDriver());
		continueWithEmailTest.clickContinueWithEmailButton();
		
		
	}

	@AfterTest
	public void serverRunnerStop() {
		serverTest.serverStopTest();
		System.out.println("Server Stopped");

	}

}
