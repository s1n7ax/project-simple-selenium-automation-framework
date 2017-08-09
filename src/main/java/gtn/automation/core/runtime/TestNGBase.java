package gtn.automation.core.runtime;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import gtn.automation.core.runtime_helper.DriverHandler;
import gtn.automation.core.runtime_helper.PropertyReader;
import gtn.automation.core.runtime_helper.exceptions.InvalideBrowserType;


/** this class will defines common TestNg base excluding @Test which will be defined the QA
 * 
 * @author srinesh
 *
 */
public abstract class TestNGBase {

	public WebDriver driver;
	
	/*
	 * before all tests in the suite
	 */
	@BeforeSuite()
	public void beforeSuite() throws InvalideBrowserType, IOException {
	}

	/*
	 * before the first test method 
	 */
	@BeforeClass()
	public void beforeClass() {
	}

	/*
	 * before first test test method even before @BeforeClass
	 */
	@BeforeTest()
	public void beforeTest() {
	}

	/*
	 * before each and every test
	 */
	@Parameters({"browser", "driver_path"})
	@BeforeMethod()
	public void beforeMethod(String browser, String driverPath) throws IOException, InvalideBrowserType {
		// get runtime properties
		PropertyReader prop= new PropertyReader("runtime.properties");
		
		int implecitTimeout = Integer.parseInt(prop.getProperty("IMPLECIT_WAIT_TIME"));
		String url = prop.getProperty("APPLICATION_URL");
		
		// creates a new driver for the test suite in the thread
		driver = DriverHandler.getNewDriver(browser, driverPath);
		
		// setting driver configuration
		driver.manage().timeouts().implicitlyWait(implecitTimeout, TimeUnit.SECONDS);
		driver.get(url);
		
		System.out.println(browser +" session created");
	}

	
	@AfterSuite()
	public void afterSuite() {
	}

	@AfterClass()
	public void afterClass() {
	}

	@AfterTest()
	public void afterTest() {
	}

	@AfterMethod()
	public void afterMethod() {
		// closing the created driver
		driver.close();
		
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browser = cap.getBrowserName().toLowerCase();
		System.out.println(browser + " session closed");
		
	}
}
