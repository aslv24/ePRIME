package com.ePRIME.TestUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ePRIME.Reader.PropertyReader;

public class ReportsUtility {

	
	public static ExtentReports getExtentReports()
	{
		String fileName="extent";
		long timeMillis = System.currentTimeMillis();
		String path=PropertyReader.getProperty("reportPath")+fileName+timeMillis+PropertyReader.getProperty("HTML");
		
		ExtentSparkReporter spark=new ExtentSparkReporter(path);
		
		spark.config().setDocumentTitle("ePRIME Automation Report");
		spark.config().setReportName("ePRIME - Test Results");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setEncoding("UTF-8");
		spark.config().setTimeStampFormat("dd:MM:yyyy hh:mm:ss, a");
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		
		return report;
	}
}
