package gtn.automation.testing.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import gtn.automation.core.test_helper.LocatorResolver;

public class CommonPage {
	public static WebElement tf_Inputs(WebDriver driver, String labelName) {
		String locator = LocatorResolver.resolveParameters(
				CommonLocatorEnum.tf_Inputs.getText(), labelName);
		
		return driver.findElement(By.xpath(locator));
	}
	
	public static WebElement tf_InputsById(WebDriver driver, String id) {
		String locator = LocatorResolver.resolveParameters(
				CommonLocatorEnum.tf_InputsById.getText(), id);
		
		return driver.findElement(By.xpath(locator));
	}
	
	public static WebElement btn_Buttons(WebDriver driver, String buttonName) {
		String locator = LocatorResolver.resolveParameters(
				CommonLocatorEnum.btn_Buttons.getText(), buttonName);
		
		return driver.findElement(By.xpath(locator));
	}
	
	public static WebElement btn_AncButtons(WebDriver driver, String buttonInnerText) {
		String locator = LocatorResolver.resolveParameters(
				CommonLocatorEnum.btn_AncButtons.getText(), buttonInnerText);
		
		return driver.findElement(By.xpath(locator));
	}
	
	public static Select ele_ddSelects(WebDriver driver, String selectMenuLabel) {
		String locator = LocatorResolver.resolveParameters(
				CommonLocatorEnum.ele_ddSelects.getText(), selectMenuLabel);
		
		return new Select(driver.findElement(By.xpath(locator)));
	}
	
	public static WebElement btn_FileInputs(WebDriver driver, String fileInputId) {
		String locator = LocatorResolver.resolveParameters(
				CommonLocatorEnum.btn_FileInputs.getText(), fileInputId);		
		
		return driver.findElement(By.xpath(locator));
	}
	
	public static WebElement btn_InputButtons(WebDriver driver, String inputButtonValue) {
		String locator = LocatorResolver.resolveParameters(
				CommonLocatorEnum.btn_InputButtons.getText(), inputButtonValue);		
		
		return driver.findElement(By.xpath(locator));
	}
	
	public static WebElement btn_ButtonsById(WebDriver driver, String buttonId) {
		String locator = LocatorResolver.resolveParameters(
				CommonLocatorEnum.btn_ButtonsById.getText(), buttonId);	
		
		return driver.findElement(By.xpath(locator));
	}
	
	public static WebElement frm_IframeByName(WebDriver driver, String iframeName) {
		String locator = LocatorResolver.resolveParameters(
				CommonLocatorEnum.frm_IFrameByName.getText(), iframeName);
		
		return driver.findElement(By.xpath(locator));
	}
}
