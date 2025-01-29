package ContinueWithEmailTestPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import ContinueWithEmail.ContinueWithEmailClass;
import io.appium.java_client.AppiumDriver;

public class ContinueWithEmailTest extends ContinueWithEmailClass {

	public ContinueWithEmailTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		System.out.println("Testing Continue with Email Login Page...");
	}

	public void continueWithEmailTestMethods() throws InterruptedException, IOException {
		clickContinueWithEmailButton();
		System.out.println("Clicked Continue with email Option");

		performEmailValidation();
	}
	public void continueWithEmailTestMethods(String emailInputValues) throws InterruptedException, IOException {

		
		performEmailValidation(emailInputValues);
		System.out.println("Validate the email input field");

	}

}
