package ContinueWithEmail;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LoginPagePackage.LoginPageClass;
import PageObjectModel.ContinueWithEmailPom;
import PropertiesPackage.PropertiesReadFile;

interface ContinueWithEmail {

	void clickContinueWithEmailButton() throws InterruptedException;

	void emailEnterPageValidation();

	void enterEmailValidation();

}

public class ContinueWithEmailClass extends ContinueWithEmailPom implements ContinueWithEmail {

	PropertiesReadFile propertiesReadFile;

	public ContinueWithEmailClass(WebDriver driver) {
		super(driver);
		this.propertiesReadFile = new PropertiesReadFile();
	}

	@Override
	public void clickContinueWithEmailButton() throws InterruptedException {

		Thread.sleep(2000);

		List<WebElement> loginOptionsLists = LoginPageClass.loginOptionElements;
		for (WebElement loginOptionsList : loginOptionsLists) {

			String loginOptionsListText = loginOptionsList.getText();

			try {
				if (loginOptionsListText.equals(propertiesReadFile.readData("ContinueWithEmail"))) {
					getContinueWithEmail();
					break;
				};
			} catch (IOException e) {
				System.out.println("The LoginOptionsList Text issue this is method clickContinueWithEmailButton "
						+ e.getMessage() + this.getClass());
			}

		}

	}

	@Override
	public void emailEnterPageValidation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterEmailValidation() {
		// TODO Auto-generated method stub

	}

}
