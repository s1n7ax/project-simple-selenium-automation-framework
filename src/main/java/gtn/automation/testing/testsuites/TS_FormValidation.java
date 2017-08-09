package gtn.automation.testing.testsuites;

import java.io.IOException;

import javax.xml.bind.PropertyException;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gtn.automation.core.runtime.TestNGBase;
import gtn.automation.core.test_helper.data_provider.ExcelDataProvider;
import gtn.automation.core.test_helper.data_provider.UserDataProviderIntf;
import gtn.automation.testing.modules.LogIn;
import gtn.automation.testing.modules.NavigateFromHomePage;

public class TS_FormValidation extends TestNGBase {

	@Test(dataProvider = "excel_data_provider")
	public final void tc_RegistrationFormValidation(String userName, String password) throws InterruptedException {

		// starting
//		NavigateFromHomePage.run(driver, "Login Page");
//		LogIn.run(driver, userName, password);

		Thread.sleep(20 * 1000);
	}

	@Test(dataProvider = "excel_data_provider")
	public final void tc_RegistrationFormValidation1(String userName, String password) throws InterruptedException {

		// starting
//		NavigateFromHomePage.run(driver, "Login Page");
//		LogIn.run(driver, userName, password);

		Thread.sleep(20 * 1000);
	}

	@Test(dataProvider = "excel_data_provider")
	public final void tc_RegistrationFormValidation2(String userName, String password) throws InterruptedException {

		// starting
//		NavigateFromHomePage.run(driver, "Login Page");
//		LogIn.run(driver, userName, password);

		Thread.sleep(20 * 1000);
	}

	@Test(dataProvider = "excel_data_provider")
	public final void tc_RegistrationFormValidation3(String userName, String password) throws InterruptedException {

		// starting
//		NavigateFromHomePage.run(driver, "Login Page");
//		LogIn.run(driver, userName, password);

		Thread.sleep(20 * 1000);
	}

	@DataProvider(name = "excel_data_provider")
	public Object[][] provider(ITestContext context) throws IOException, PropertyException {
		UserDataProviderIntf eDataProv = new ExcelDataProvider();
		return eDataProv.getProvider(context);
	}
}
