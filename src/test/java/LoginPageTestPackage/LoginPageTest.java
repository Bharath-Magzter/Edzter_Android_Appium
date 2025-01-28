package LoginPageTestPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import LoginPagePackage.LoginPageClass;

public class LoginPageTest extends LoginPageClass {

	public LoginPageTest(WebDriver driver) {
		super(driver);
		
	}
	
	
	public void loginPageTest() throws IOException {
		
		
		clickLetStartButton();
		validateLoginPageBanner();
		validateLoginOptions();
		
		
	}
	
	

}
