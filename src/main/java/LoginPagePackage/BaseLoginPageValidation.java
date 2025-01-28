package LoginPagePackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import DriverUtilies.DriverMethods;
import PropertiesPackage.PropertiesReadFile;

public  abstract class BaseLoginPageValidation {

	protected DriverMethods driverMethods;
	protected PropertiesReadFile propertiesReadFile;
	
	
	public BaseLoginPageValidation() {
		this.driverMethods = new DriverMethods();
		this.propertiesReadFile = new PropertiesReadFile();
		
	}
	
	
	public void validationLoginOptionsPresence(List<WebElement> loginOptionElements , String expectedText, String propertyKey ) throws IOException {
		
		for (WebElement webElement : loginOptionElements) {
			
			String actualText = webElement.getText();
			
			if (actualText.equals(expectedText)) {
				boolean isDisplayed = driverMethods.waitAndDisplayed(webElement);
				Assert.assertTrue(isDisplayed, expectedText + " is not visible or in DOM");
				Assert.assertEquals(actualText, propertiesReadFile.readData(propertyKey),
						expectedText + " does not match the expected value.");
				break;
			}
		}
		}
		
		
	}

