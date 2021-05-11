package com.crm.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crm.utility.BrowserFactory;
import com.crm.utility.ConfigDataProvider;
import com.crm.utility.ExcelDataProvider;
import com.crm.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	
	public ExcelDataProvider excel;
	
	public ConfigDataProvider config;
	
	public ExtentReports report;
	
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	
	@BeforeClass
	public void setup() {
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
		}
		report.flush();
	}

}
