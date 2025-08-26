package com.ePRIME.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ePRIME.Reader.PropertyReader;

public class BaseClass {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static void setDriver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(PropertyReader.getProperty("chromeKey"), PropertyReader.getProperty("chromeValue"));
			driver.set(new ChromeDriver());
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty(PropertyReader.getProperty("edgeKey"), PropertyReader.getProperty("edgeValue"));
			driver.set(new EdgeDriver());
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(PropertyReader.getProperty("firefoxKey"), PropertyReader.getProperty("firefoxValue"));
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--allow-system-access");
			driver.set(new FirefoxDriver(options));
		}

		else {
			String errorMessage = "❌ Undefined Browser Setup: '" + browserName
					+ "'. Please check browser configuration...";
			System.err.println(errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static WebDriver getDriver() {
		return driver.get();

	}

}
