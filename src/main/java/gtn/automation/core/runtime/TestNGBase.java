package gtn.automation.core.runtime;

import org.openqa.selenium.WebDriver;
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
import gtn.automation.core.runtime_helper.exceptions.InvalideBrowserType;


/** this class will defines common TestNg base excluding @Test which will be defined the QA
 * 
 * @author srinesh
 *
 */
public abstract class TestNGBase {

	WebDriver driver;
	
	/*
	 * before all tests in the suite
	 */
	@Parameters({"browser", "driver_path"})
	@BeforeSuite()
	public void beforeSuite(String browser, String driverPath) throws InvalideBrowserType {
		System.out.println("Starting @BeforeSuite");
		
		// creates a new driver for the test suite in the thread
		driver = DriverHandler.getNewDriver(browser, driverPath);
	}

	/*
	 * before the first test method 
	 */
	@BeforeClass()
	public void beforeClass() {
		System.out.println("Starting @BeforeClass");
	}

	/*
	 * before first test test method even before @BeforeClass
	 */
	@BeforeTest()
	public void beforeTest() {
		System.out.println("Starting @BeforeTest");
	}

	/*
	 * before each and every test
	 */
	@BeforeMethod()
	public void beforeMethod() {
		System.out.println("Starting @BeforeMethod");
	}

	
	@AfterSuite()
	public void afterSuite() {
		System.out.println("Starting @AfterSuite");
	}

	@AfterClass()
	public void afterClass() {
		System.out.println("Starting @AfterClass");
	}

	@AfterTest()
	public void afterTest() {
		System.out.println("Starting @AfterTest");
	}

	@AfterMethod()
	public void afterMethod() {
		System.out.println("Starting @AfterMethod");
		
		// closing the created driver
		driver.close();
	}
}
