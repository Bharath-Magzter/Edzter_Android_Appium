package DriverUtilies;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverPackage.DriverManager;

public class DriverMethods {

	WebDriver driver;
	static WebDriverWait wait;

	public DriverMethods() {
		this.driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Method to wait for visibility of a WebElement
	public void waitForVisibility(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println("Error in waiting for visibility: " + e.getMessage());
		}
	}

	public boolean waitAndDisplayed(WebElement element) {
		boolean waitStatus = false ;
		try {
			waitStatus= wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
			System.out.println("In Driver Utilies Methods waitStatus is " + waitStatus);
		} catch (Exception e) {
			System.out.println("Error in waiting for visibility: " + e.getMessage());
		}
		return waitStatus;

	}
}
