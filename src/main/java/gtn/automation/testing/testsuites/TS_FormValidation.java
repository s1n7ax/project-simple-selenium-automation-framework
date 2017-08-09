package gtn.automation.testing.testsuites;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.xml.bind.PropertyException;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gtn.automation.core.runtime.TestNGBase;
import gtn.automation.core.test_helper.data_provider.ExcelDataProvider;
import gtn.automation.core.test_helper.data_provider.UserDataProviderIntf;
import gtn.automation.testing.modules.FillRegistration;
import gtn.automation.testing.modules.GoToPage;
import gtn.automation.testing.modules.LogIn;
import gtn.automation.testing.modules.NavigateFromHomePage;

public class TS_FormValidation extends TestNGBase {
	public TS_FormValidation() throws IOException {
		super();
	}

	@Test(dataProvider = "excel_data_provider")
	public final void tc_RegistrationFormValidation(String userName, String password, String fName, String lName,
			String email, String pno, String gender, String cmpName, String add1, String add2, String attachFilePath,
			String skillCount, String skills) throws InterruptedException {

		// starting
		NavigateFromHomePage.run(getThreadLocalDriver().get(), "Login Page");
		LogIn.run(getThreadLocalDriver().get(), userName, password);

		// go back to home page
		GoToPage.run(getThreadLocalDriver().get(), "http://krypton.guru/");

		// navigate to registration form
		NavigateFromHomePage.run(getThreadLocalDriver().get(), "Registration Form");

		// fill the registration form
		FillRegistration.run(getThreadLocalDriver().get(), fName, lName, email, pno, gender, cmpName, add1, add2,
				attachFilePath, skillCount, skills);
	}

	@Test(dataProvider = "excel_data_provider")
	public final void tc_RegistrationFormValidation1(String userName, String password, String fName, String lName,
			String email, String pno, String gender, String cmpName, String add1, String add2, String attachFilePath,
			String skillCount, String skills) throws InterruptedException {

		// starting
		NavigateFromHomePage.run(getThreadLocalDriver().get(), "Login Page");
		LogIn.run(getThreadLocalDriver().get(), userName, password);

		// go back to home page
		GoToPage.run(getThreadLocalDriver().get(), "http://krypton.guru/");

		// navigate to registration form
		NavigateFromHomePage.run(getThreadLocalDriver().get(), "Registration Form");

		// fill the registration form
		FillRegistration.run(getThreadLocalDriver().get(), fName, lName, email, pno, gender, cmpName, add1, add2,
				attachFilePath, skillCount, skills);
	}

	@Test(dataProvider = "excel_data_provider")
	public final void tc_RegistrationFormValidation2(String userName, String password, String fName, String lName,
			String email, String pno, String gender, String cmpName, String add1, String add2, String attachFilePath,
			String skillCount, String skills) throws InterruptedException {

		// starting
		NavigateFromHomePage.run(getThreadLocalDriver().get(), "Login Page");
		LogIn.run(getThreadLocalDriver().get(), userName, password);

		// go back to home page
		GoToPage.run(getThreadLocalDriver().get(), "http://krypton.guru/");

		// navigate to registration form
		NavigateFromHomePage.run(getThreadLocalDriver().get(), "Registration Form");

		// fill the registration form
		FillRegistration.run(getThreadLocalDriver().get(), fName, lName, email, pno, gender, cmpName, add1, add2,
				attachFilePath, skillCount, skills);
	}

	@Test(dataProvider = "excel_data_provider")
	public final void tc_RegistrationFormValidation3(String userName, String password, String fName, String lName,
			String email, String pno, String gender, String cmpName, String add1, String add2, String attachFilePath,
			String skillCount, String skills) throws InterruptedException {

		// starting
		NavigateFromHomePage.run(getThreadLocalDriver().get(), "Login Page");
		LogIn.run(getThreadLocalDriver().get(), userName, password);

		// go back to home page
		GoToPage.run(getThreadLocalDriver().get(), "http://krypton.guru/");

		// navigate to registration form
		NavigateFromHomePage.run(getThreadLocalDriver().get(), "Registration Form");

		// fill the registration form
		FillRegistration.run(getThreadLocalDriver().get(), fName, lName, email, pno, gender, cmpName, add1, add2,
				attachFilePath, skillCount, skills);
	}

	@DataProvider(name = "excel_data_provider")
	public Object[][] provider(ITestContext context, Method method) throws IOException, PropertyException {
		UserDataProviderIntf eDataProv = new ExcelDataProvider();
		return eDataProv.getProvider("dt_FormValidation.xlsx", "Sheet1");
	}
}
