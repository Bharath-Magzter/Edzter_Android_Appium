package PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverPackage.DriverManager;
import DriverUtilies.DriverMethods;

public class LoginPagePom {

	private WebDriver driver;
	private DriverMethods driverMethods;

	public LoginPagePom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.driverMethods = new DriverMethods();
	}

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.magzter.edzter:id/btn_start\"]")
	private WebElement letStart_Loc;

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.magzter.edzter:id/parent_layout\"]")
	private WebElement loginPageBanner_ele;

	@FindBy(xpath = "//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.TextView")
	private static List<WebElement> loginOptionsEle;

	public void letStartAction() {

		driverMethods.waitForVisibility(letStart_Loc);
		letStart_Loc.click();

	}

	public boolean loginPageBannerAction() {

		boolean loginPageBannerElementStatus = false;
		// return loginPageBanner_ele.isDisplayed();

		loginPageBannerElementStatus = driverMethods.waitAndDisplayed(loginPageBanner_ele);
		System.out.println("In the POM class loginPageBannerAction function loginPageBannerElementStatus is  "
				+ loginPageBannerElementStatus);
		return loginPageBannerElementStatus;
	}

	public static List<WebElement> getLoginOptions() {
		return loginOptionsEle;
	}

}
