package PageObjectModel;

import java.nio.file.attribute.AclEntry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContinueWithEmailPom {

	WebDriver driver;

	public ContinueWithEmailPom(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.magzter.edzter:id/layout_continue_email\"]")
	private WebElement ContinueWithEmail_Loc;
	
	
	
	
	@FindBy (xpath = "//android.widget.LinearLayout")
	private WebElement ContinueWithEmail_Loc1;

	public void getContinueWithEmail() {
		ContinueWithEmail_Loc.click();
	}
	
}
