package com.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	public WebDriver driver = null;
	
	
	
	public HomePageFactory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@href='/login']")
	public WebElement SigninLink;
	
	@FindBy(xpath="//span[@id='username']/a")
	public WebElement validloginmessage;
	
	public void getBook(String bookname)
	{
		driver.findElement(By.xpath("//div[text(),"+bookname+"]")).click();
	}
}
