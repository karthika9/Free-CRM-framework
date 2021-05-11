package com.crm.testcases;


import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;


import com.crm.pages.BaseClass;
import com.crm.pages.LoginPage;
import com.crm.utility.Helper;


public class LoginTestCrm extends BaseClass {

	
	@Test
	public void loginApp() {
		
		logger = report.createTest("Login to CRM");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.loginToCrm(excel.getStringData("Sheet 1", 1, 0), excel.getStringData("Sheet 1", 1, 1));
		
		logger.pass("Login successfully");
		
		Helper.captureScreenshot(driver);
	}
}
