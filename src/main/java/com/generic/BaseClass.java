package com.generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseClass {
	
	public WebDriver driver = null;
	private String Browser = UtilityClass.getPropertyData("Browser");
	private long WAIT_IN_MILLISECOND = Long.parseLong(UtilityClass.getPropertyData("DriverWait"));
	
	
	@BeforeMethod
	public void initializeBrowser()
	{	
		
		if(Browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", UtilityClass.getPropertyData("chrome"));
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", UtilityClass.getPropertyData("IE"));
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(WAIT_IN_MILLISECOND, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPropertyData("URL"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
			
	}
	
	public void getScreenshot(String TC_ID)
	{
		File file = new File("D:\\Jim\\WorkSpace\\October_2016\\October2016\\Report\\"+TC_ID+"_screenshot.png");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotAs,file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
