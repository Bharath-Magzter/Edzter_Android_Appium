package LoginPagePackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjectModel.LoginPagePom;
import PropertiesPackage.PropertiesReadFile;

interface LoginPageInterface {

	void letStartbtn_Method();

	void loginPageBanner_Method();

	void loginPageOptions_Method() throws IOException;

}

public class LoginPageClass extends LoginPagePom implements LoginPageInterface {

	private WebDriver driver;
	PropertiesReadFile propertiesReadFile;

	public LoginPageClass(WebDriver driver) {

		super(driver);
		this.driver = driver;
		propertiesReadFile = new PropertiesReadFile();
	}

	@Override
	public void letStartbtn_Method() {

		letStartAction();
	}

	@Override
	public void loginPageBanner_Method() {
		boolean loginPageBannerStatus = loginPageBannerAction();

		System.out.println("In the Login Page class loginPageBanner_Method status from loginPageBannerStatus is "
				+ loginPageBannerStatus);
		Assert.assertTrue(loginPageBannerStatus, "Banner is not Displayed");

	}

	@Override
	public void loginPageOptions_Method() throws IOException {
		List<WebElement> loginOptionElements = getLoginOptions();

		for (WebElement loginOptionElement : loginOptionElements) {
			String eachLoginOption = loginOptionElement.getText();
			System.out.println("Login Option: " + eachLoginOption);

			switch (eachLoginOption) {

			case "Continue with Smart Reading Zone (SRZ)":
				Assert.assertEquals(eachLoginOption, propertiesReadFile.readData("ContinueWithSRZ"),
						"SRZ option does not match!");

				break;

			case "Continue with Email Address":
				Assert.assertEquals(eachLoginOption, propertiesReadFile.readData("ContinueWithEmail"),
						"Email option does not match!");

				break;

			case "Continue with Access Code":
				Assert.assertEquals(eachLoginOption, propertiesReadFile.readData("ContinueWithAccess"),
						"Access code option does not match!");

				break;

			default:
				System.out.println("Unexpected login option: " + eachLoginOption);
				break;
			}
		}
	}

}
