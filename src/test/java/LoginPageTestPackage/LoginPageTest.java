package LoginPageTestPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import LoginPagePackage.LoginPageClass;

public class LoginPageTest extends LoginPageClass {

	public LoginPageTest(WebDriver driver) {
		super(driver);
		
	}
	
	
	public void loginPageTestMethods() throws IOException {
		
		System.out.println("Testing Login Page..."); 
		
		clickLetStartButton();
		System.out.println("Clicked 'Let's Start' button");
		boolean bannerStatus = 	validateLoginPageBanner();
		
		System.out.println("Banner Validation Status: " + bannerStatus);

		validateLoginOptions();
		
		System.out.println("Login Options Validated");
		
		
	}
	
	

}
