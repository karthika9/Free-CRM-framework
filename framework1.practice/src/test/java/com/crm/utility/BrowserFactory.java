package com.crm.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver,String browserName, String appUrl) {
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","//Users//jeyakarthikkanainarsureshkumar//Downloads//chromedriver");
			driver=new ChromeDriver();
		}
	
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/geckodriver" );
			driver=new ChromeDriver();
		}
		else {
			System.out.println("we do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		return driver;
	}
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
		
	}
}
