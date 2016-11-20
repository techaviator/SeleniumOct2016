package com.dataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.generic.Excel2List;

public class Login_DataProvider {
	
	@DataProvider(name="ValidLogin_DP")
	public static Iterator<Object[]> DP_validLogin() throws IOException
	{
		/*List<Object[]> ls = new ArrayList<Object[]>();
		Object[] obj = new Object[2];
		obj[0] = "qtpworld2008@gmail.com";
		obj[1]="learn123";
		ls.add(obj);*/
		Excel2List x = new Excel2List();
		List<Object[]> ls = x.getXlData("Scenario_Login", "validLogin");
		return ls.iterator();
	}
	
	
	
	
	@DataProvider(name = "InvalidLogin_DP")
	public static Iterator<Object[]> DP_InvalidLogin() throws IOException
	{
		/*List<Object[]> ls = new ArrayList<Object[]>();
		Object[] obj = new Object[2];
		obj[0]= "";
		obj[1]="";
		ls.add(obj);*/
		Excel2List x = new Excel2List();
		List<Object[]> xlData = x.getXlData("Scenario_Login","invalidLogin");
		return xlData.iterator();
	}
	
	public void getXLData()
	{
		
	}

}
