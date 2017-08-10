package gtn.automation.test.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gtn.automation.test.pages.CommonPage;

public class PrintProjectSchedule {
	public static void run(WebDriver driver) {
		WebElement scheduleTable = CommonPage.tbl_TablesById(driver, "tblSchedule");
		
		PrintTables pt = new PrintTables(scheduleTable);
		pt.print("Here is your program schedule");
	}
}
