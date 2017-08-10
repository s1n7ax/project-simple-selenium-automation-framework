package gtn.automation.test.modules;

import org.openqa.selenium.WebDriver;

import gtn.automation.test.pages.DemoPage;
import gtn.automation.test.pages.LoginPage;

public class LogIn {
	public static final void run(WebDriver driver, String userName, String password) {
		// type username and password
		LoginPage.tf_UserInputs(driver, "User Name:").sendKeys(userName);
		LoginPage.tf_UserInputs(driver, "Password:").sendKeys(password);
		
		// click submit
		LoginPage.btn_Submit(driver).click();
		
		// validate the demo page header to confirm the login
		DemoPage.ele_lblDemoPageHeader(driver);
	}
}
