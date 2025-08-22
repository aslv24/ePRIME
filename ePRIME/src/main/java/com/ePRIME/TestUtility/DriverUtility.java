package com.ePRIME.TestUtility;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ePRIME.TestBase.BaseClass;

public class DriverUtility extends BaseClass{

	
	static WebDriverWait wait;

	public static void maximize() {
		getDriver().manage().window().maximize();
	}

	public static void implicitlyWait() {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void implicitlyWait(int wait) {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
	}

	public static void openUrl(String pageUrl) {
		getDriver().get(pageUrl);
	}

	public static String pageTitle() {
		return getDriver().getTitle();
	}

	public static String pageUrl() {
		return getDriver().getCurrentUrl();
	}

	public static WebElement elementToClickable(WebElement element) {
		wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void clickElement(WebElement element) {
		elementToClickable(element).click();
	}

	public static void clearElement(WebElement element) {
		elementToClickable(element).clear();
	}

	public static void enterValueOnElement(WebElement element, String value) {
		elementToClickable(element).sendKeys(value);
	}

	public static void switchToFrame(int index) {
		getDriver().switchTo().frame(index);
	}

	public static void switchToFrame(String nameOrid) {
		getDriver().switchTo().frame(nameOrid);
	}

	public static void switchToFrame(WebElement element) {
		getDriver().switchTo().frame(element);
	}

	public static void leaveFrame() {
		getDriver().switchTo().defaultContent();
	}

	public static void dropdownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void dropdownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void dropdownByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
}
