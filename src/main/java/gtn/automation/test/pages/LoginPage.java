package gtn.automation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gtn.automation.core.test.helper.LocatorResolver;

public class LoginPage {

	public static WebElement tf_UserInputs(WebDriver driver, String inputFieldName) {
		String locator = 
				LocatorResolver.resolveParameters(
						LoginPageLocatorEnum.tf_UserInputs.getText(), inputFieldName);
		
		return driver.findElement(By.xpath(locator));
	}
	
	public static WebElement btn_Submit(WebDriver driver) {
		String locator = LoginPageLocatorEnum.btn_Submit.getText();
		return driver.findElement(By.xpath(locator));
	}
}
