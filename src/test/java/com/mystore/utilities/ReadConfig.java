package com.mystore.utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
	
	Properties proerties;
	
	String path="C:\\Suraj Automation\\Suraj_Automation_Class\\MavenProjectYoutube\\MyStoreV1\\Configuration\\config.properties";
	
	//constructor
	public ReadConfig() {
		try {proerties=new Properties();
		
			FileInputStream fis=new FileInputStream(path);
			proerties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBaseURL() {
		String value=proerties.getProperty("baseUrl");
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("Url not specified in config file");
		}
	}
	public String getBrowser() {
		String value=proerties.getProperty("browser");
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("Url not specified in config file");
		}
	}
	

}
