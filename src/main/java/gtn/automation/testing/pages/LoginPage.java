package gtn.automation.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gtn.automation.core.test_helper.LocatorResolver;

public class LoginPage {

	public WebElement tf_UserInputs(WebDriver driver, String inputFieldName) {
		String locator = 
				LocatorResolver.resolveParameters(
						LoginPageLocatorEnum.tf_UserInputs.name(), inputFieldName);
		
		return driver.findElement(By.xpath(locator));
	}
	
	public WebElement btn_Submit(WebDriver driver) {
		String locator = LoginPageLocatorEnum.btn_Submit.name();
		return driver.findElement(By.xpath(locator));
	}
}
