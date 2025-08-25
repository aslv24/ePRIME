package com.ePRIME.TestUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersUtility implements ITestListener{
	
	String testName;
	ExtentReports extentReports;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Suite Started Successfully.....");
		extentReports = ReportsUtility.getExtentReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
		System.out.println(testName+" :: Test Method Started....");
		test = extentReports.createTest(testName);
		test.log(Status.INFO, "Test Got Started...");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(testName+" :: Test Method Passed....");
		test.log(Status.PASS, "Test Got Passed...");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(testName+" :: Test Method Failed....");
		String screenshot = DriverUtility.captureScreenshot(testName);
		test.log(Status.FAIL, "Test Got Failed...");
		test.addScreenCaptureFromPath(screenshot, "Failed Screenshot");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(testName+" :: Test Method Skipped....");
		test.log(Status.SKIP, "Test Got Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Finished Successfully.....");
		extentReports.flush();
	}

}
