package me.gastherr.crackers.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import me.gastherr.crackers.Main;

public class Resource {
	
	public static URL getFile(String path) throws IOException{
		return Main.class.getResource(path);
	}
	
	public static File[] getFiles(String folderpath) throws IOException{
		return new File(Main.class.getResource(folderpath).getFile()).listFiles();
	}

}
