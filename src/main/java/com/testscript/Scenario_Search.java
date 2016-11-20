package com.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.pageFactory.HomePageFactory;
import com.pageFactory.LoginPageFactory;

public class Scenario_Search extends BaseClass {
	
	
	LoginPageFactory login = null;
	HomePageFactory home = null;
	
	@Test
	public void validSearch()
	{
		
		driver.findElement(By.id("srchword")).sendKeys("ways");
		driver.findElement(By.xpath("//input[@class='newsrchbtn'][@type='button']")).click();
		String actual = driver.findElement(By.id("find")).getText();
		if(actual.equals("498"))
		{
			System.out.println(" TC valid search pass");
		}
		else
		{
			System.out.println(" TC valid search fail");
		}
	}

}
