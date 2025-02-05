package ContinueWithEmail;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DriverUtilies.DriverMethods;
import PageObjectModel.ContinueWithEmailPom;
import PropertiesPackage.PropertiesReadFile;

public abstract class BaseContinueWithEmailValidation {

	protected DriverMethods driverMethods;
	protected PropertiesReadFile propertiesReadFile;
	protected WebDriver driver;

	public BaseContinueWithEmailValidation(WebDriver driver) {
		this.driver = driver;
		this.driverMethods = new DriverMethods();
		this.propertiesReadFile = new PropertiesReadFile();
	}

	public void validateTextPresence(List<WebElement> elements, String expectedText, String propertyKey)
			throws IOException {

		for (WebElement element : elements) {
			String actualText = element.getText();
			if (actualText.equals(expectedText)) {
				boolean isDisplayed = driverMethods.waitAndDisplayed(element);
				Assert.assertTrue(isDisplayed, expectedText + " is not visible or in DOM");
				Assert.assertEquals(actualText, propertiesReadFile.readData(propertyKey),
						expectedText + " does not match the expected value.");
				break;
			}
		}

	}

	public void validateEmailInputFieldErrorMessages(WebElement emailInputFieldWebelement,
			HashMap<String, String> emailInputValues) {

		emailInputFieldWebelement.sendKeys(emailInputValues.get("userMailID"));
		ContinueWithEmailPom.getSubmitBtn(); // Click submit

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		boolean errorMessageElement = false;
		try {
			errorMessageElement = ContinueWithEmailPom.getErrorMessageStatus(); // Check for error message presence
		} catch (NoSuchElementException e) {
			// No error message is expected for valid emails, so ignore this exception
			errorMessageElement = false;
		}

		if (errorMessageElement) {
			System.out.println("❌ Invalid Email: Error message is displayed");
			emailInputFieldWebelement.clear(); // Clear input field for next test
		} else {
			// If no error message appears, verify the presence of the "Verify" button
			boolean isElementPresentStatus = ContinueWithEmailPom
					.isElementPresent("//android.widget.Button[@resource-id='com.magzter.edzter:id/btn_email']");

			Assert.assertTrue(isElementPresentStatus, "Verify button is not present for valid email id");

			if (isElementPresentStatus) {
				WebElement VerifyButtonOnOTPPageStatus = wait
						.until(ExpectedConditions.visibilityOf(ContinueWithEmailPom.getVerifyButtonOnOTPPage()));

				System.out.println("✅ Valid Email: 'Verify' button is displayed");

				VerifyButtonOnOTPPageStatus.click();
			}
		}
	}

	public abstract void performEmailValidation(HashMap<String, String> emailInputValues) throws IOException;

	public abstract void performEmailValidation() throws IOException;

}
