package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		System.out.println(src.exists());
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.out.println("IOException");
			e.printStackTrace();
		}	
	}
	public String getAppUrl()
	{
		String url=pro.getProperty("AppURL");
		return url;
		
	}
	
	public String getUserName()
	{
		String UserName=pro.getProperty("Userid");
		return UserName;
		
	}
	public String getUserPassword()
	{
		String UserPassword=pro.getProperty("password");
		return UserPassword;
		
	}
}
