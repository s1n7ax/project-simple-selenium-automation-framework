package gtn.automation.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gtn.automation.core.test_helper.LocatorResolver;

public class DemoPage {

	public static WebElement ele_lblDemoPageHeader(WebDriver driver) {
		String locator = 
				LocatorResolver.resolveParameters(
						CommonLocatorEnum.ele_lblPageHeaderCommon.getText(),
						"Demo page - Web Elements");
		
		return driver.findElement(By.xpath(locator));
	}
}
