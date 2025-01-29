package PageObjectModel;

import java.nio.file.attribute.AclEntry;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import DriverUtilies.DriverMethods;

public class ContinueWithEmailPom {

	protected WebDriver driver;

	public ContinueWithEmailPom(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.magzter.edzter:id/layout_continue_email\"]")
	private WebElement continueWithEmailButton;

	@FindBy(xpath = "//*[@text]")
	private List<WebElement> emailInputPageTextElements;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.magzter.edzter:id/btn_email_submit\"]")
	private static WebElement submitBtn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.magzter.edzter:id/snackbar_text\"]")
	private static WebElement errorMessageEle;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.magzter.edzter:id/edt_email\"]")
	private static WebElement emailInputField;
	//
	//android.widget.TextView[@resource-id="com.magzter.edzter:id/snackbar_text"]
	public void getContinueWithEmail() {
		continueWithEmailButton.click();
	}

	public List<WebElement> getEmailInputPageText() {

		return emailInputPageTextElements;

	}

	public static void getSubmitBtn() {
		submitBtn.click();

	}

	public static void getErrorMessageEle() {

		boolean errorMessageEleStatus = DriverMethods.waitAndDisplayed(errorMessageEle);
		String errorMessageText = errorMessageEle.getText();

		Assert.assertTrue(errorMessageEleStatus, errorMessageText + " Error message is not present on screen");

	}

	public static WebElement getEmailInputField() {

		return emailInputField;
		
	}
}
