package ContinueWithEmail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import DriverUtilies.DriverMethods;
import LoginPagePackage.LoginPageClass;
import PageObjectModel.ContinueWithEmailPom;
import PageObjectModel.LoginPagePom;
import PropertiesPackage.PropertiesReadFile;

public class ContinueWithEmailClass extends BaseContinueWithEmailValidation implements ContinueWithEmailInterface {

	private final ContinueWithEmailPom continueWithEmailPom;

	public ContinueWithEmailClass(WebDriver driver) {

		super(driver);
		this.continueWithEmailPom = new ContinueWithEmailPom(driver);

	}

	@Override
	public void clickContinueWithEmailButton() throws InterruptedException {

		Thread.sleep(2000);

		List<WebElement> loginOptionsLists = LoginPagePom.getLoginOptions();
		for (WebElement loginOptionsList : loginOptionsLists) {

			String loginOptionsListText = loginOptionsList.getText();

			try {
				if (loginOptionsListText.equals(PropertiesReadFile.readData("ContinueWithEmail"))) {
					continueWithEmailPom.getContinueWithEmail();
					break;
				}
				;
			} catch (IOException e) {
				System.out.println("The LoginOptionsList Text issue this is method clickContinueWithEmailButton "
						+ e.getMessage() + this.getClass());
			}

		}

	}

	@Override
	public void validateEmailPageTexts() throws IOException {
		List<WebElement> emailTexts = continueWithEmailPom.getEmailInputPageText();

		validateTextPresence(emailTexts,
				"Start reading by providing the email address registered with your institution", "StartReadingTitle");
		validateTextPresence(emailTexts, "Enter your Email address", "EmailInputText");
		validateTextPresence(emailTexts, "For institutional demo & enquiries, Click here", "Enquiries");
	}

	@Override
	public void validateEmailInputWithOutData() {
		continueWithEmailPom.getSubmitBtn();
		continueWithEmailPom.getErrorMessageEle();

	}

	@Override
	public void validateEmailInputPosAndNeg(HashMap<String, String> emailInputValues) {
		WebElement emailInputFieldWebelement = continueWithEmailPom.getEmailInputField();

		validateEmailInputFieldErrorMessages(emailInputFieldWebelement, emailInputValues);

	}

	@Override
	public void performEmailValidation() throws IOException {

		validateEmailPageTexts();
		
		System.out.println("Started this method : validateEmailPageTexts");
		validateEmailInputWithOutData();
		System.out.println("Started this method : validateEmailInputWithOutData");
	}

	@Override
	public void performEmailValidation(HashMap<String, String> emailInputValues) throws IOException {

		validateEmailInputPosAndNeg( emailInputValues);

	}

	
}
