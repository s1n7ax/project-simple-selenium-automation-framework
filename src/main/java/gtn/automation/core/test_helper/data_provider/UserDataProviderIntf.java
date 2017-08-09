package gtn.automation.core.test_helper.data_provider;

import java.io.IOException;

import javax.xml.bind.PropertyException;

import org.testng.ITestContext;

public interface UserDataProviderIntf {
	public Object[][] getProvider(ITestContext context) throws IOException, PropertyException;
}
