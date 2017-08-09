package gtn.automation.testing.modules;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import gtn.automation.testing.pages.CommonPage;

public class FillRegistration {
	public static final void run(WebDriver driver, String fName, String lName, String email, String pno, String gender,
			String cmpName, String add1, String add2, String attachFilePath, String skillCount, String skills) {

		// fill Step 1
		CommonPage.tf_Inputs(driver, "First Name").sendKeys(fName);
		CommonPage.tf_Inputs(driver, "Last Name").sendKeys(lName);

		// move to next page
		CommonPage.btn_AncButtons(driver, "Next").click();

		// fill Step 2
		CommonPage.tf_Inputs(driver, "Email").sendKeys(email);
		CommonPage.tf_Inputs(driver, "Phone Number").sendKeys(pno);
		CommonPage.ele_ddSelects(driver, "Gender").selectByVisibleText(gender);

	
		// switch to sub iframe
		driver.switchTo().frame(CommonPage.frm_IframeByName(driver, "companyInfo"));

		CommonPage.tf_Inputs(driver, "Company Name").sendKeys(cmpName);
		CommonPage.tf_Inputs(driver, "Address Line 1").sendKeys(add1);
		CommonPage.tf_Inputs(driver, "Address Line 2").sendKeys(add2);

		// switching to main frame
		driver.switchTo().defaultContent();
		
		// move to next page
		CommonPage.btn_AncButtons(driver, "Next").click();

		// fill Step 2
		CommonPage.btn_Buttons(driver, "Attach").click();

		// save parent window
		Set<String> winHandles = driver.getWindowHandles();
		Iterator<String> winIter = winHandles.iterator();

		String parentWinId = winIter.next();

		// get the new window
		String subWinID = winIter.next();

		// switching to the new window
		driver.switchTo().window(subWinID);

		// set a file
		CommonPage.btn_FileInputs(driver, "file").sendKeys(attachFilePath);

		// upload and done
		CommonPage.btn_InputButtons(driver, "Upload").click();
		CommonPage.btn_InputButtons(driver, "Done").click();

		// switch to parent window
		driver.switchTo().window(parentWinId);

		// set the count and add
		CommonPage.tf_InputsById(driver, "count").sendKeys(skillCount);
		CommonPage.btn_ButtonsById(driver, "add").click();

		// separate different skills by comma
		int skillCountInt = Integer.parseInt(skillCount);
		String[] skillsArr = skills.split(",");

		for (int i = 0; i <= skillCountInt; i++) {
			CommonPage.tf_Inputs(driver, "Skill " + (i + 1)).sendKeys(skillsArr[i]);
		}

		// click finish
		CommonPage.btn_AncButtons(driver, "Finish").click();
	}
}
