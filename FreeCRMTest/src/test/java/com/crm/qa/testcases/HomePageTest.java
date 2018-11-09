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

public class HomePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;
	
public HomePageTest()
{
super();
}

@BeforeMethod
public void  setUp()
{
initilization();
loginpage = new LoginPage();
testUtil= new TestUtil();
contactspage = new ContactsPage();
homepage=loginpage.LogIn(prop.getProperty("username"),prop.getProperty("password"));
}

	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homepageTitle =homepage.verfiyPageTitle();
	//	At the time of report if title is not matched the below message is displayed
		Assert.assertEquals(homepageTitle, "CRMPRO","homepage title not matched");
		}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
	 testUtil.switchToFrame();   
	 Assert.assertTrue(homepage.verifyCorrectUserName());
	 }
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
	contactspage=homepage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
	



