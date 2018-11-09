package com.crm.qa.util;

import org.openqa.selenium.WebDriver;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=40;
	public static long IMPLICT_WAIT= 30;

	
	public void  switchToFrame()  
	{
		driver.switchTo().frame("mainpanel");
	}
	}
