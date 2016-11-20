package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	public LoginPageFactory(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="logid")
	public WebElement uname;
	
	@FindBy(name = "pswd")
	public WebElement password;
	
	@FindBy(css=".sb1 input")
	public WebElement loginButton;
	
	@FindBy(xpath="//b[contains(text(),'Sorry')]")
	public WebElement invalidloginmessage;

}
