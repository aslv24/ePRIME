package com.ePRIME.TestScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ePRIME.PageObjects.LoginPage;
import com.ePRIME.TestBase.BaseClass;
import com.ePRIME.TestUtility.DataProviderClass;
import com.ePRIME.TestUtility.DriverUtility;
import com.ePRIME.TestUtility.ListenersUtility;

@Listeners(ListenersUtility.class)
public class SampleRun extends BaseClass{
	
	String expectedTitle="HMS";
	
	String expectedUrl="http://localhost/hmsci";
	
	LoginPage loginPage;
	
	SoftAssert softAssert;
	
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
		softAssert=new SoftAssert();
		String pageTitle = DriverUtility.pageTitle();
		softAssert.assertEquals(pageTitle, expectedTitle);
		System.out.println("This line will execute only if assertion passes.");
		System.out.println(pageTitle);
		softAssert.assertAll();
	}
	
	@Test(priority = 2)
	public void verifyUrl()
	{
		softAssert=new SoftAssert();
		String pageUrl = DriverUtility.pageUrl();
		softAssert.assertEquals(pageUrl, expectedUrl);
		System.out.println("This line will execute only if assertion passes.");
		System.out.println(pageUrl);
		softAssert.assertAll();
	}
	
	
	@Test(priority = 3,dataProvider = "qaData",dataProviderClass = DataProviderClass.class)
	public void verifyLogin(String role, String emailId, String password)
	{
		loginPage.verifyLogin(role, emailId, password);
	}
}
