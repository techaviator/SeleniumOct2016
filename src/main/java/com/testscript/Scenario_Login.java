package com.testscript;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.pageFactory.HomePageFactory;
import com.pageFactory.LoginPageFactory;
import com.relevantcodes.extentreports.LogStatus;

public class Scenario_Login extends BaseClass {
	
	LoginPageFactory login = null;
	HomePageFactory home = null;
	Logger log = Logger.getLogger(Scenario_Login.class);
	
	@Test(dataProvider="ValidLogin_DP",dataProviderClass = com.dataProvider.Login_DataProvider.class)
	public void validLogin(String TCID, String scriptname,String status,String username, String password, String expected)
	{
		log.info("Starting valid login");
		/*WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://books.rediff.com/");*/
		/*driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.name("logid")).sendKeys("qtpworld2008@gmail.com");
		driver.findElement(By.name("pswd")).sendKeys("learn123");
		driver.findElement(By.cssSelector(".sb1 input")).click();*/
		////*************************
		loginFunctionality(username, password);
		String actual = home.validloginmessage.getText();
		//String actual = driver.findElement(By.xpath("//span[@id='username']/a")).getText();
		if(actual.equalsIgnoreCase("qtpworld2008 g"))
		{
			System.out.println("TC validLogin pass");
			log.info("Validation passed");
			getScreenshot(TCID);
		}
		else
		{
			System.out.println("TC validLogin failed");
			log.warn("Validation failed");
		}
		log.info("Completed valid login");
		//driver.close();
		//logid //pswd //sb1 input
		
		
	}
	
	
	//************************************common Test Case
	
	public void loginFunctionality(String username, String pswd)
	{
		/*driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.name("logid")).sendKeys(username);
		driver.findElement(By.name("pswd")).sendKeys(password);
		driver.findElement(By.cssSelector(".sb1 input")).click();
		*/
		 home = new HomePageFactory(driver);
		home.SigninLink.click();
		 login = new LoginPageFactory(driver);
		
		login.uname.sendKeys(username);
		login.password.sendKeys(pswd);
		login.loginButton.click();
		
	}
	
	
	@Test(dataProvider = "InvalidLogin_DP", dataProviderClass=com.dataProvider.Login_DataProvider.class)
	public void invalidLogin(String TCID, String scriptname,String status,String username, String password, String expected)
	{
		
		
		/*WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://books.rediff.com/");*/
		/*driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.name("logid")).sendKeys("");
		driver.findElement(By.name("pswd")).sendKeys("");
		driver.findElement(By.cssSelector(".sb1 input")).click();*/
		
		//**********************
		loginFunctionality(username,password);
		//String actual = driver.findElement(By.xpath("//b[contains(text(),'Sorry')]")).getText();
		String actual = login.invalidloginmessage.getText();
		if(actual.equalsIgnoreCase("Sorry we were unable to complete this step because :"))
		{
			System.out.println("TC invalidLogin pass");
		}
		else
		{
			System.out.println("TC invalidLogin failed");
		}
		
		//driver.close();
	}

}
