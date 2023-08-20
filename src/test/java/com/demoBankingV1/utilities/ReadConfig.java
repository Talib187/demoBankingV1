package com.demoBankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import freemarker.core.ReturnInstruction.Return;

public class ReadConfig {

	Properties prop;

	 public ReadConfig() {

		try {

			File src = new File("./Configuration\\config.properties");

			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {

			System.out.println("Issue in ReadConfig");
		}

	}

	public String getURL() {

		String url = prop.getProperty("baseURL");

		return url;  

	}
	
	public String getUsername() {
		
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		
		String password = prop.getProperty("password");
		return password;
	}
}
