package com.ePRIME.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ePRIME.Reader.PropertyReader;

public class BaseClass {

	
	static WebDriver driver;
	
	public static void createDriver(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(PropertyReader.getProperty("chromeKey"),PropertyReader.getProperty("chromeValue") );
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty(PropertyReader.getProperty("edgeKey"),PropertyReader.getProperty("edgeValue") );
			driver=new EdgeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty(PropertyReader.getProperty("firefoxKey"),PropertyReader.getProperty("firefoxValue") );
			driver=new FirefoxDriver();
		}
		
		else {
		    String errorMessage = "❌ Undefined Browser Setup: '" + browserName + "'. Please check browser configuration...";
		    System.err.println(errorMessage);
		    throw new IllegalArgumentException(errorMessage);
		}

	}
	
	
}
