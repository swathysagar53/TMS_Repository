package com.TrainerManagementSystem.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream f1=new FileInputStream(src);
			pro=new Properties();
			pro.load(f1);
		}catch(Exception e){
			System.out.println("Exception is"+e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIEpath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	
	public String getFirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}

}
