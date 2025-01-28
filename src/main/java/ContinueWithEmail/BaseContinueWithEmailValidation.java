package ContinueWithEmail;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import DriverUtilies.DriverMethods;
import PropertiesPackage.PropertiesReadFile;

public abstract class BaseContinueWithEmailValidation {

	protected DriverMethods driverMethods;
	protected PropertiesReadFile propertiesReadFile;

	public BaseContinueWithEmailValidation() {
		this.driverMethods = new DriverMethods();
		this.propertiesReadFile = new PropertiesReadFile();
	}

	public void validateTextPresence(List<WebElement> elements , String expectedText , String propertyKey) throws IOException {
		

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

	public abstract void performEmailValidation() throws IOException;
}
