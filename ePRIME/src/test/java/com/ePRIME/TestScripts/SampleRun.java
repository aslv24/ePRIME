package com.ePRIME.TestScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ePRIME.PageObjects.LoginPage;
import com.ePRIME.TestBase.BaseClass;
import com.ePRIME.TestUtility.DriverUtility;

public class SampleRun extends BaseClass{
	
	LoginPage loginPage;
	
	@Parameters({"browserName"})
	@BeforeTest
	public void setup(@Optional("chrome")String browserName)
	{
		setDriver(browserName);
		DriverUtility.maximize();
		DriverUtility.implicitlyWait();
		DriverUtility.openUrl("http://localhost/hmsci");
		loginPage=new LoginPage();
	}

	
	@Test(priority = 1)
	public void verifyTitle()
	{
		String pageTitle = DriverUtility.pageTitle();
		System.out.println(pageTitle);
	}
	
	@Test(priority = 2)
	public void verifyUrl()
	{
		String pageUrl = DriverUtility.pageUrl();
		System.out.println(pageUrl);
	}
	
	
	@Test(priority = 3)
	public void verifyLogin()
	{
		loginPage.verifyLogin(1, "admin@mail.com", "12345678");
	}
}
