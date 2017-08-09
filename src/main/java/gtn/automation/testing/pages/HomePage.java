package gtn.automation.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gtn.automation.core.test_helper.LocatorResolver;

public class HomePage {
	
	public static WebElement ele_Navigator(WebDriver driver, String navName) {
		String locator = 
				LocatorResolver.resolveParameters(
						HomePageLocatorsEnum.lnk_HomeNavigator.getText(), navName);
		
		return driver.findElement(By.xpath(locator));
	}
}
