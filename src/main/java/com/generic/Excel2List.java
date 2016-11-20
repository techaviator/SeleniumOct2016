package com.generic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Excel2List {
	
	public List<Object[]> getXlData(String sheetname, String scriptname) throws IOException
	{
		//String sheetname = "Scenario_Login";
		ExcelReader xl = new ExcelReader(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData.xlsx");
		List<Object[]> ls = new ArrayList<Object[]>();
		Object[] obj =null;
		
		//rowcount  =7 colcount = 5
		int xlRowCount = xl.getXLRowCount(sheetname);
		short xlColCount = xl.getXLColCount(sheetname);
		
		for(int i=1;i<=xlRowCount;i++)
		{
			if(xl.getXLData(sheetname, i, 2).equalsIgnoreCase("Y")&&(xl.getXLData(sheetname, i, 1)).equalsIgnoreCase(scriptname))
			{
				obj= new Object[xlColCount];
				for(int j=0;j<xlColCount;j++)
				{
					obj[j]=xl.getXLData(sheetname, i, j);
				}
				ls.add(obj);
			}
			
		}
		
		return ls;
	}
	
	
	
/*	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		//Excel2List x = new Excel2List();
		
	}*/

}
