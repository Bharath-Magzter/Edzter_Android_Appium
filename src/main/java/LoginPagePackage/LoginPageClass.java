package LoginPagePackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjectModel.LoginPagePom;
import PropertiesPackage.PropertiesReadFile;

public class LoginPageClass extends BaseLoginPageValidation implements LoginPageInterface {

	private WebDriver driver;

	protected LoginPagePom loginPagePom;

	public LoginPageClass(WebDriver driver) {
		super();

		this.driver = driver;
		propertiesReadFile = new PropertiesReadFile();
		loginPagePom = new LoginPagePom(this.driver);
	}

	@Override
	public void clickLetStartButton() {
		loginPagePom.letStartAction();

	}

	@Override
	public boolean validateLoginPageBanner() {
		boolean loginPageBannerStatus = loginPagePom.loginPageBannerAction();
		Assert.assertTrue(loginPageBannerStatus, "Banner is not displayed");
		return loginPageBannerStatus;
	}

	@Override
	public void validateLoginOptions() throws IOException {
		List<WebElement> loginOptionElements = loginPagePom.getLoginOptions();

		validationLoginOptionsPresence(loginOptionElements, "Continue with Smart Reading Zone (SRZ)",
				"ContinueWithSRZ");
		validationLoginOptionsPresence(loginOptionElements, "Continue with Email Address", "ContinueWithEmail");
		validationLoginOptionsPresence(loginOptionElements, "Continue with Access Code", "ContinueWithAccess");

	}



}
