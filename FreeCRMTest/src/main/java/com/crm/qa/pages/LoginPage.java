package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

//	PageFacotry-Object Repository
	
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//input[@type='submit']") WebElement login;
	@FindBy(xpath="//div[@class='container']/div[2]/ul/li[2]/a") WebElement Signup;
	@FindBy(xpath="//img[contains(@class,'img-responsive')]") WebElement CRMlogo;
	
//	Initializing Login Page page objects
		public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
//	Actions
		public String validatePageTitle()
		{
			return driver.getTitle();
		}
		
		public boolean validateCRMImage()
		{
			return CRMlogo.isDisplayed();
			
		}
		
		public HomePage  LogIn(String un, String pwd)
		{
			username.sendKeys(un);
			password.sendKeys(pwd);
			login.submit();
			return new HomePage();
		}
		
	
		}
	

	

