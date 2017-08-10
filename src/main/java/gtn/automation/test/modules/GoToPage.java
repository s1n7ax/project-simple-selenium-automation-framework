package gtn.automation.test.modules;

import org.openqa.selenium.WebDriver;

public class GoToPage {
	public static final void run(WebDriver driver, String url) {
		// navigate to the URL
		driver.get(url);
	}
}
