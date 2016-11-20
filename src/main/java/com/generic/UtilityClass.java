package com.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilityClass {
	
	public static String getPropertyData(String key)
	{
		FileInputStream fis =null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties");
		} catch (FileNotFoundException e) {
			System.err.println("THe file cannot be found");
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.out.println(" There is a IO exception when reading the property file");
		}
		return prop.getProperty(key);
	}
	
	/*public static void main(String[] args) {
		
		System.out.println(getPropertyData("Browser"));
	}*/

}
