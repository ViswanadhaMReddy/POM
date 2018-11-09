package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Vinmayi Reddy')]") WebElement UserNameLabel;
	@FindBy(xpath="//a[contains(text(),'Contacts')]") WebElement ContactsLink;
	@FindBy(xpath="//a[contains(text(),'Deals')]") WebElement DealsLinks;
	@FindBy(xpath="//a[contains(text(),'Tasks')]")WebElement TasksLink;
	
//	Initializing  HomePage Page Objects

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	 
	public String verfiyPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
	return UserNameLabel.isDisplayed();
		
	}
	
	public ContactsPage clickOnContactsLink()
	{
		ContactsLink.click();
		return new ContactsPage();
	}
	
	
		
	}

