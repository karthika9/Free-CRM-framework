package com.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	
	@FindBy(name="username")WebElement uname;
	
	
	@FindBy(name="password")WebElement pword;
	
	
	@FindBy(xpath="//input[@value='Login']")WebElement loginButton;
	
	
	public void loginToCrm(String username,String pass)
	{
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			
		}
		uname.sendKeys(username);
		
		pword.sendKeys(pass);
		
		loginButton.click();
	}
	
	
}
