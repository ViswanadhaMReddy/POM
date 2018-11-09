package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestBase {

	 public static WebDriver driver;
     public static Properties prop;
     
   	public TestBase() 
	{
		try
		{
		prop=new Properties();
		
		FileInputStream fis = new FileInputStream("E:/TestMaven/FreeCRMTest/src/main/java/com/crm/qa/config/config.pro");
		prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
			
	}
	
	public static void initilization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:/Selenium Chrome Driver/chromedriver.exe");
		driver=new ChromeDriver();
		}
		else
			if(browserName.equalsIgnoreCase("FireFox"))
	{
        System.setProperty("webdriver.gecko.driver", "C:/Users/lenovo/Downloads/geckodriver.exe");
		driver=new FirefoxDriver();		
			}
			else 
				if(browserName.equalsIgnoreCase("IE"))
				{
					System.setProperty("webdriver.ie.driver", "C:/Users/lenovo/Downloads/IEDriverServer.exe");
				}
		

        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
