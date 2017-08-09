package gtn.automation.testing.modules;

import org.openqa.selenium.WebDriver;

import gtn.automation.testing.pages.HomePage;

public class NavigateFromHomePage {
	public static final void run(WebDriver driver, String navName) {
		HomePage.ele_Navigator(driver, navName).click();
	}
}
