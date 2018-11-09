package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilization();
		testUtil= new TestUtil();
		contactspage = new ContactsPage();
		loginpage = new LoginPage();
		homepage=loginpage.LogIn(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
 		contactspage=homepage.clickOnContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest()
	{
		Assert.assertTrue(contactspage.verifyContactsLable(),"Contacts Lable Missing on the page");
	}

	@Test(priority=2)
	public void selectSingleContactsTest()
	{
		contactspage.selectContactsByName("Abhi Ram");
		}
	
	@Test(priority=3)
	public void selectMultipleContactsTest()
	{
		contactspage.selectContactsByName("Abhi Ram");
		contactspage.selectContactsByName("test1 test1");
	}
@AfterMethod

public void tearDown()
{
	driver.quit();
}
	
}