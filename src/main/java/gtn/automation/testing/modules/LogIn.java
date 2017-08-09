package gtn.automation.testing.modules;

import org.openqa.selenium.WebDriver;

import gtn.automation.testing.pages.LoginPage;

public class LogIn {
	public static final void run(WebDriver driver, String userName, String password) {
		LoginPage.tf_UserInputs(driver, "User Name:").sendKeys(userName);
		LoginPage.tf_UserInputs(driver, "Password:").sendKeys(password);
	}
}
