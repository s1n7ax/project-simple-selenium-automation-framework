package gtn.automation.core.runtime.helper;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import gtn.automation.core.runtime.helper.exceptions.InvalideBrowserType;

public class DriverHandler {
	
	public static WebDriver getNewDriver(String browser, Map<String, String> driverPath) throws InvalideBrowserType, IOException {
		WebDriver driver;
		
		switch (browser.toLowerCase()) {
		
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", driverPath.get("chrome")); 
			driver = new ChromeDriver();
		}
			break;
		
		case "firefox": {
			System.setProperty("webdriver.gecko.driver", driverPath.get("firefox"));
			
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("browserName", "firefox");
			capabilities.setCapability("javascriptEnabled", true);
			capabilities.setCapability("handlesAlerts", true);
			capabilities.setCapability("marionette", true);
 
			driver = new FirefoxDriver(capabilities);
		}
			break;

		case "ie": {
			System.setProperty("webdriver.ie.driver", driverPath.get("ie")); 
			driver = new InternetExplorerDriver();
		}
			break;
			
		default:
			throw new InvalideBrowserType("Invalid browser type " + browser);
		}
		
		return driver;
	}
}
