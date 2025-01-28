package ContinueWithEmailTestPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import ContinueWithEmail.ContinueWithEmailClass;
import io.appium.java_client.AppiumDriver;

public class ContinueWithEmailTest extends ContinueWithEmailClass {

	public ContinueWithEmailTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void continueWithEmailTest() throws InterruptedException, IOException {
		clickContinueWithEmailButton();
		performEmailValidation();

	}

}
