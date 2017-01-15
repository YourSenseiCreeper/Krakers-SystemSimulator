package me.gastherr.crackers.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Messages {
	
	private static Properties prop;

	public Messages(){ //Otwarte Ÿród³o?
		
		prop = new Properties();
		try {
			prop.load(Resource.getFile("src/resource/messages.txt").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getProperties(){
		return prop;
	}
	
	public static String getMessage(String tag){
		if (getProperties().getProperty(tag) == null) return "NULL"; 
		else return new String(getProperties().getProperty(tag).getBytes(), StandardCharsets.ISO_8859_1);
	}

}
