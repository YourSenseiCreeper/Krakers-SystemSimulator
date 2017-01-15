package me.gastherr.crackers.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Messages {
	
	private static Properties prop;

	public Messages(){ // Otwarte Ÿród³o?
		
		String propFileName = "messages.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		try {

			prop = new Properties();

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		try {
			inputStream.close();
		} catch (IOException e) {e.printStackTrace();}

	}
	
	public static Properties getProperties(){
		return prop;
	}
	
	public static String getMessage(String tag){
		if (prop.getProperty(tag) == null) return "NULL"; 
		else return new String(prop.getProperty(tag).getBytes(), StandardCharsets.ISO_8859_1);
	}

}
